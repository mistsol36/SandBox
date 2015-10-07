package ui.model

import dispatch._
import util.NicoMovieUtils
import scala.xml.XML

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by mist on 2015/09/16.
 */
class NicoLiveComment(inputText: String) {

  val comments = initComments

//  private def initComments:List[NicoCommentModel] = {
  private def initComments = {

//    val no = NicoMovieUtils.extractMovieNo(inputText)
    val no = "lv237725731"

    // val getPlayerStatus = s"http://watch.live.nicovideo.jp/api/getplayerstatus?v=$no"
    // val getPlayerStatus = s"http://live.nicovideo.jp/api/getplayerstatus?v=$no"
    val getPlayerStatus = s"http://live.nicovideo.jp/api/getplayerstatus?v=$no"

    val reqPlayerStatus = url(getPlayerStatus).POST.addCookie(LoginInfo.getUserSessionByCookie)

    val reqFuturePlayerStatus = Http(reqPlayerStatus)
    println(reqFuturePlayerStatus().getResponseBody)

    val decoded = new String(reqFuturePlayerStatus().getResponseBodyAsBytes, "UTF-8")
    val xml = XML.loadString(decoded)
    val port = xml \\ "addr"
    println(port)


  }

}
