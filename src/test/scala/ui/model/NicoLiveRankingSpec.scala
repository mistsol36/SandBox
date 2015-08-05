package ui.model

import org.specs2.mutable.Specification

/**
 * Created by mist on 2015/06/10.
 */
class NicoLiveRankingSpec  extends Specification {
  "NicoLiveRanking" should {
    "case: test" in {
      // 動作確認のためのテスト
      val nicoLiveRanking = new NicoLiveRanking()
      nicoLiveRanking.nicoLiveInfos.foreach( f => {
        println(f.title)
      })
      1 must equalTo(1)
    }
  }
}
