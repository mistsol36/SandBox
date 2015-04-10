package ui.model

import dispatch._
import dispatch.Defaults._
import scala.util.matching.Regex
import scala.xml.XML

/**
 * Created by kodama on 2015/04/04.
 */
class NicoMovie (inputText : String) {
  private val smNo = getSmNo()
  private val svc = url("http://ext.nicovideo.jp/api/getthumbinfo/".union(smNo))
  private val html = Http(svc OK as.String)
  private val xml = XML.loadString(html())
  val  title = (xml \\ "title").text

  private def getSmNo():String = {
    val noR : Regex = """/(sm|nm)?[0-9]+""".r;
    val noOption : Option[Regex.Match] = noR.findFirstMatchIn(inputText)
    noOption match {
      case Some( noOp ) => noOption.get.toString()
      case None => inputText
    }
  }
}
