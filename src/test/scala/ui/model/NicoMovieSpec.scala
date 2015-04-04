package ui.model

import org.specs2.mutable._
import ui.model.NicoMovie

/**
 * Created by kodama on 2015/04/05.
 */
class NicoMovieSpec extends Specification {

  "a NicoMovie" should {
    "title is 'おちゃめ機能　歌った'. (Full address)" in {
      val inputText = "http://www.nicovideo.jp/watch/sm10780722"
      new NicoMovie(inputText).title must equalTo("おちゃめ機能　歌った")
    }
    "title is 'おちゃめ機能　歌った'. (Full address) + α" in {
      val inputText = "http://www.nicovideo.jp/watch/sm10780722#aaa"
      new NicoMovie(inputText).title must equalTo("おちゃめ機能　歌った")
    }
    "title is 'おちゃめ機能　歌った'. (sm + No only)" in {
      val inputText = "sm10780722"
      new NicoMovie(inputText).title must equalTo("おちゃめ機能　歌った")
    }
    "title is 'おちゃめ機能　歌った'. (No only)" in {
      val inputText = "10780722"
      new NicoMovie(inputText).title must equalTo("おちゃめ機能　歌った")
    }
    "title is '【初音ミク】アストロノーツ【オリジナル】'. (Full address)(nm)" in {
      val inputText = "http://www.nicovideo.jp/watch/nm14629738"
      new NicoMovie(inputText).title must equalTo("【初音ミク】アストロノーツ【オリジナル】")
    }
    "title is '【初音ミク】アストロノーツ【オリジナル】'. (Full address + α)(nm)" in {
      val inputText = "http://www.nicovideo.jp/watch/nm14629738#bbb"
      new NicoMovie(inputText).title must equalTo("【初音ミク】アストロノーツ【オリジナル】")
    }
    "title is '【初音ミク】アストロノーツ【オリジナル】'. (nm + No only)" in {
      val inputText = "nm14629738"
      new NicoMovie(inputText).title must equalTo("【初音ミク】アストロノーツ【オリジナル】")
    }
    "title is '【初音ミク】アストロノーツ【オリジナル】'. (No only)(nm)" in {
      val inputText = "14629738"
      new NicoMovie(inputText).title must equalTo("【初音ミク】アストロノーツ【オリジナル】")
    }
    "title is null." in {
      val inputText = "https://www.google.co.jp"
      new NicoMovie(inputText).title must beEmpty
    }
  }

}
