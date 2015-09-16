package ui.model

import org.specs2.mutable._

/**
 * Created by mist on 2015/09/16.
 */
class NicoLiveCommentSpec extends Specification {
  "NicoMovieComment" should {
    "case: test" in {
      // 動作確認のためのテスト
      val comment = new NicoLiveComment("234765468")
      //comment.comments.foreach(m => println(m.comment))
      1 must equalTo(1)
    }
  }
}
