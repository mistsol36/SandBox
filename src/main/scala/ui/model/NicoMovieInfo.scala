package ui.model

import dispatch.Defaults._
import dispatch._
import util.NicoMovieUtils

import scala.xml.XML

/**
 * 動画の情報を保持するクラス
 *
 * @param inputText 動画URLまたは動画ID
 * Created by kodama on 2015/04/04.
 */
class NicoMovieInfo (inputText : String) { // コンストラクタはクラスのブロック内に書く（基本コンストラクタ）

  /** API URL */
  val apiUrl = "http://ext.nicovideo.jp/api/getthumbinfo/"

  /** 動画ID */
  val movieNo = NicoMovieUtils.extractMovieNo(inputText)

  /** APIから返却されたXML */
  val rtnXml = {
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
