package ui.model

import org.specs2.mutable._

/**
 * Created by mist on 2015/04/23.
 */
class NicoMovieCommentSpec extends Specification {
  "NicoMovieCommen" should {
    "case: test" in {
      new NicoMovieComment()
      1 must equalTo(1)
    }
  }
}
