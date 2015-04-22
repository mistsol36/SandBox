package ui.model

import dispatch._
import dispatch.Defaults._
import scala.util.matching.Regex
import scala.xml.XML

/**
 * 動画の情報を保持するクラス
 *
 * @param inputText 動画URLまたは動画ID
 * Created by kodama on 2015/04/04.
 */
class NicoMovieInfo (inputText : String) { // コンストラクタはクラスのブロック内に書く（基本コンストラクタ）

  /** 動画ID */
  private val movieNo = {
    val noR : Regex = """(sm|nm)?[0-9]+""".r
    val noOption : Option[Regex.Match] = noR.findFirstMatchIn(inputText)
    noOption match {
      case Some( noOp ) => noOption.get.toString()
      case None => inputText
    }
  }

  /** API URL */
  private val apiUrl = "http://ext.nicovideo.jp/api/getthumbinfo/"

  /** APIから返却されたXML */
  private val rtnXml = {
    val svc = url(apiUrl.union(movieNo))
    val html = Http(svc OK as.String)
    XML.loadString(html())
  }

  /**
   * 動画タイトルを取得。
   *
   * @return 動画タイトル
   */
  def getTitle: String = { // アクセス修飾子を付けないとpublic
    (rtnXml \\ "title").text
  }
}
