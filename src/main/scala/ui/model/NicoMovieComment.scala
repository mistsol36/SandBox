package ui.model

import dispatch._
import util.NicoMovieUtils

import collection.JavaConverters._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.xml.XML

/**
 * コメントを取得するクラス。
 *
 * ニコ動のAPIについては以下を参考にした。
 * http://d.hatena.ne.jp/celitan/20101219/1292750813
 * http://blog.nanoway.net/web/nicovideo-comment-api
 *
 * dispatchの使い方については以下を参考にした。
 * http://stackoverflow.com/questions/19575891/setting-a-cookie-for-http-post-in-scala-with-dispatch
 *
 * TODO 要リファクタリング
 * Created by bububu10 on 15/04/12.
 */
class NicoMovieComment(inputText: String) {

  val comments = initComments

  private def initComments: List[NicoCommentModel] = {

    val no = NicoMovieUtils.extractMovieNo(inputText)

    val getflvUrl = s"http://flapi.nicovideo.jp/api/getflv/$no"

    // getflvへアクセス
    val reqGetFlv = url(getflvUrl).POST.addCookie(LoginInfo.getUserSessionByCookie)
    //    val reqGetFlv = url(getflvUrl).POST.addCookie(LoginInfo.getUserSessionByCookie)
    val resFutureGetFlv = Http(reqGetFlv)
    //  println("---------getflvから返却された奴-----------")
    //  println(resFutureGetFlv().getResponseBody)

    // デコード、&区切りで返ってきているので分割
    val decoded = java.net.URLDecoder.decode(resFutureGetFlv().getResponseBody, "UTF-8")
    val divided = decoded.split("&")
    //  println("---------デコードして分割した奴-----------")
    //  println(divided.foreach(r => println(r)))

    // スレッドIDとメッセージサーバのURLを取得
    // TODO ハードコーディング直す
    val threadId = divided(0).drop(10)
    val msgSrvUrl = divided(3).drop(3)

    // postするxmlの準備
    val postXml = <thread thread={threadId} version="20061206" res_from="446"/>

    // xmlをメッセージサーバに送信
    val reqMsg = url(msgSrvUrl).POST.setBody(postXml.toString)
    val resFutureMsg = Http(reqMsg)

    // 戻ってくるXMLの構造は以下
    // http://blog.goo.ne.jp/hocomodashi/e/3ef374ad09e79ed5c50f3584b3712d61
    //  println("---------コメント-----------")
    //  println(resFutureMsg().getResponseBody)
    //  println(XML.loadString(resFutureMsg().getResponseBody))

    val body = new String(resFutureMsg().getResponseBodyAsBytes, "UTF-8")
    val xml = XML.loadString(body)
    val chatNodeSeq = xml \\ "chat"

    var chatList: List[NicoCommentModel] = List()
    chatNodeSeq.foreach(chat => chatList = chatList :+ new NicoCommentModel(chat))

    chatList
  }

  def javaList(): java.util.List[NicoCommentModel] = comments.asJava
}
