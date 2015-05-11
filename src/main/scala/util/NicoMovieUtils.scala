package util

import scala.util.matching.Regex

/**
 * Created by bububu10 on 15/05/12.
 */
object NicoMovieUtils {
  // objectの使いどころがいまいち分からない
  // ref. http://www.slideshare.net/maedaunderscore/scala-36370185

  /**
   * URLから動画idを抜き出す。
   * 
   * @param url
   * @return movieNo
   */
  def extractMovieNo(url: String): String = {
    val noR : Regex = """(sm|nm)?[0-9]+""".r
    val noOption : Option[Regex.Match] = noR.findFirstMatchIn(url)
    noOption match {
      case Some( noOp ) => noOption.get.toString()
      case None => url
    }
  }
  
}
