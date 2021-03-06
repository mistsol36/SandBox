package ui.model

import org.specs2.mutable._

/**
 * Created by mist on 2015/04/23.
 */
class NicoMovieCommentSpec extends Specification {
  "NicoMovieComment" should {
    "case: test" in {
      // 動作確認のためのテスト
      val comment = new NicoMovieComment("http://www.nicovideo.jp/watch/sm26155774")
      comment.comments.foreach(m => println(m.comment))
      1 must equalTo(1)
    }
  }
}
