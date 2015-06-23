package ui.model

import dispatch._
import org.json4s._
import org.json4s.native.JsonMethods._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.mutable.Set

/**
 * Created by mist on 2015/06/10.
 */
class NicoLiveRanking {

  // http://www59.atwiki.jp/nicoapi/pages/33.html

  // 正体不明
  implicit val formats = DefaultFormats


  val nicoLiveInfoSet =  Set.empty[NicoLiveInfo]
  for (index <- 0 until 10) {
    val rankingUrl = s"http://live.nicovideo.jp/api/getzappinglist?zroute=recent&zpage=${index}&sort=comment_num&order=desc"
    val rankReq = url(rankingUrl).GET.addCookie(LoginInfo.getUserSession)
    val rankRes = Http(rankReq)

    val json = rankRes().getResponseBody
    val onAirStreamInfo = parse(json).extract[OnAirStreamInfo]

    println(onAirStreamInfo.onair_stream_list.size)

    onAirStreamInfo.onair_stream_list foreach( f =>  nicoLiveInfoSet += new NicoLiveInfo(f))
  }
  for (index <- 0 until 10) {
    val rankingUrl = s"http://live.nicovideo.jp/api/getzappinglist?zroute=recent&zpage=${index}&sort=view_counter&order=desc"
    val rankReq = url(rankingUrl).GET.addCookie(LoginInfo.getUserSession)
    val rankRes = Http(rankReq)

    val json = rankRes().getResponseBody
    val onAirStreamInfo = parse(json).extract[OnAirStreamInfo]

    println(onAirStreamInfo.onair_stream_list.size)

    onAirStreamInfo.onair_stream_list foreach( f =>  nicoLiveInfoSet += new NicoLiveInfo(f))
  }
  println("nicoLiveInfoSet.size" + nicoLiveInfoSet.size)


}

