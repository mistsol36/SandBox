package ui.model

import dispatch._
import org.json4s._
import org.json4s.native.JsonMethods._
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by mist on 2015/06/10.
 */
class NicoLiveRanking {

  val rankUrl = "http://live.nicovideo.jp/api/getzappinglist?zroute=recent&zpage=0&sort=comment_num&order=desc"

  val rankReq = url(rankUrl).GET.addCookie(LoginInfo.getUserSession)
  val rankRes = Http(rankReq)

  println(rankRes().getResponseBody)

  val json = rankRes().getResponseBody

  println(parse(json))
  println(parse(json).values)

}
