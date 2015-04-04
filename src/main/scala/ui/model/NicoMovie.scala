package ui.model

import dispatch._
import dispatch.Defaults._
import scala.xml.XML

/**
 * Created by kodama on 2015/04/04.
 */
class NicoMovie (inputText : String) {
  private def getSmNo() = inputText
  private val smNo = getSmNo()
  private val svc = url("http://ext.nicovideo.jp/api/getthumbinfo/sm".union(smNo))
  private val html = Http(svc OK as.String)
  private val xml = XML.loadString(html())
  val  title = (xml \\ "title").text
}
