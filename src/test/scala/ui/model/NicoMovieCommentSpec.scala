package ui.model

import org.specs2.mutable._

/**
 * Created by mist on 2015/04/23.
 */
class NicoMovieCommentSpec extends Specification {
  "NicoMovieCommen" should {
    "case: test" in {
      // 動作確認のためのテスト
      new NicoMovieComment("nm14629738")
      1 must equalTo(1)
    }
  }
}
