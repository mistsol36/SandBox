package ui.model

import org.specs2.mutable._

/**
 * Created by mist on 2015/07/08.
 */
class TestSpec extends Specification {
  "TestSpec" should {
    "case: test" in {
      // 動作確認のためのテスト
      val test = new Test()
      println("Initialize:" + test.Initialize)
      println("result:" + test.result)
      println("resultSet:" + test.resultSet)
      1 must equalTo(1)
    }
  }
}
