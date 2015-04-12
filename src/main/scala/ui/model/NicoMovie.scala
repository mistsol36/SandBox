package ui.model

import dispatch._
import dispatch.Defaults._
import scala.util.matching.Regex
import scala.xml.XML

/**
 * ニコニコ動画APIにアクセスし、指定の情報を取得するクラス
 *
 * @param inputText 動画URLまたは動画ID
 * Created by kodama on 2015/04/04.
 */
class NicoMovie (inputText : String) {

  // コンストラクタはクラスのブロック内に書く（基本コンストラクタ）
  /** 動画ID */
  private val movieNo = {
    val noR : Regex = """(sm|nm)?[0-9]+""".r
    val noOption : Option[Regex.Match] = noR.findFirstMatchIn(inputText)
    noOption match {
      case Some( noOp ) => noOption.get.toString()
      case None => inputText
    }
  }

  /**
   * 動画タイトルを取得。
   *
   * @return 動画タイトル
   */
  def getTitle(): String = {   // アクセス修飾子を付けないとpublic
    val svc = url("http://ext.nicovideo.jp/api/getthumbinfo/".union(movieNo))
    val html = Http(svc OK as.String)
    val xml = XML.loadString(html())
    (xml \\ "title").text
  }
}
