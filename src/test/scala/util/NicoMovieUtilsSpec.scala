package util

import org.specs2.mutable._

/**
 * Created by bububu10 on 15/05/12.
 */
class NicoMovieUtilsSpec extends Specification {

  "NicoMovieUtils#extractMovieNo" should {
    "case: sm**** URL" in {
      val inputText = "http://www.nicovideo.jp/watch/sm10780722"
      NicoMovieUtils.extractMovieNo(inputText) must equalTo("sm10780722")
    }
    "case: nm**** URL" in {
      val inputText = "http://www.nicovideo.jp/watch/nm14629738"
      NicoMovieUtils.extractMovieNo(inputText) must equalTo("nm14629738")
    }
    "officialMovie(no prefix) URL" in {
      val inputText = "http://www.nicovideo.jp/watch/1428128959"
      NicoMovieUtils.extractMovieNo(inputText) must equalTo("1428128959")
    }
    "case: sm**** URL + α" in {
      val inputText = "http://www.nicovideo.jp/watch/sm10780722"
      NicoMovieUtils.extractMovieNo(inputText) must equalTo("sm10780722")
    }
    "case: sm**** ID" in {
      val inputText = "http://www.nicovideo.jp/watch/sm10780722"
      NicoMovieUtils.extractMovieNo(inputText) must equalTo("sm10780722")
    }
  }

}
