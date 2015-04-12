package ui.model

import org.specs2.mutable._

/**
 * Created by kodama on 2015/04/05.
 */
class NicoMovieSpec extends Specification {
  "NicoMovie#getTitle()" should {
    "case: sm**** URL" in {
      val inputText = "http://www.nicovideo.jp/watch/sm10780722"
      new NicoMovie(inputText).getTitle() must equalTo("おちゃめ機能　歌った")
    }
    "case: sm**** URL + α" in {
      val inputText = "http://www.nicovideo.jp/watch/sm10780722#aaa"
      new NicoMovie(inputText).getTitle() must equalTo("おちゃめ機能　歌った")
    }
    "case: sm**** ID" in {
      val inputText = "sm10780722"
      new NicoMovie(inputText).getTitle() must equalTo("おちゃめ機能　歌った")
    }
// 動画IDは全て入れなければ不可
//    "case: sm**** ID No-only" in {
//      val inputText = "10780722"
//      new NicoMovie(inputText).getTitle() must equalTo("おちゃめ機能　歌った")
//    }
    "case: nm**** URL" in {
      val inputText = "http://www.nicovideo.jp/watch/nm14629738"
      new NicoMovie(inputText).getTitle() must equalTo("【初音ミク】アストロノーツ【オリジナル】")
    }
    "case: nm**** URL + α" in {
      val inputText = "http://www.nicovideo.jp/watch/nm14629738#bbb"
      new NicoMovie(inputText).getTitle() must equalTo("【初音ミク】アストロノーツ【オリジナル】")
    }
    "case: nm**** ID" in {
      val inputText = "nm14629738"
      new NicoMovie(inputText).getTitle() must equalTo("【初音ミク】アストロノーツ【オリジナル】")
    }
// 動画IDは全て入れなければ不可
//    "case: nm**** ID no-only" in {
//      val inputText = "14629738"
//      new NicoMovie(inputText).getTitle() must equalTo("【初音ミク】アストロノーツ【オリジナル】")
//    }
    "case: officialMovie(no prefix) URL" in {
      val inputText = "http://www.nicovideo.jp/watch/1428128959"
      new NicoMovie(inputText).getTitle() must equalTo("将棋電王戦FINAL 第5局 阿久津主税 八段 vs AWAKE")
    }
    "case: officialMovie(no prefix) URL + α" in {
      val inputText = "http://www.nicovideo.jp/watch/1428128959#ccc"
      new NicoMovie(inputText).getTitle() must equalTo("将棋電王戦FINAL 第5局 阿久津主税 八段 vs AWAKE")
    }
    "case: officialMovie(no prefix) ID" in {
      val inputText = "1428128959"
      new NicoMovie(inputText).getTitle() must equalTo("将棋電王戦FINAL 第5局 阿久津主税 八段 vs AWAKE")
    }
    "case: not Nico2 URL" in {
      val inputText = "https://www.google.co.jp"
      new NicoMovie(inputText).getTitle() must beEmpty
    }
  }

}
