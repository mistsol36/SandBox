package ui.model

import dispatch._
import org.json4s._
import org.json4s.native.JsonMethods._

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by mist on 2015/06/10.
 */
class NicoLiveRanking {

  // http://www59.atwiki.jp/nicoapi/pages/33.html

  // 正体不明
  implicit val formats = DefaultFormats


  val nicoLiveInfos =  initNicoLiveInfoList


  private def initNicoLiveInfoList: List[NicoLiveInfo] ={
    val commentNumList = addNicoLiveInfo("comment_num", 0, List())
    addNicoLiveInfo("view_counter", 0, commentNumList).distinct
  }

  private def addNicoLiveInfo(sortType:String , index: Int,nicoLiveInfoList:List[NicoLiveInfo]): List[NicoLiveInfo] = {
    val rankingUrl = s"http://live.nicovideo.jp/api/getzappinglist?zroute=recent&zpage=${index}&sort=" + sortType +"&order=desc"
    // 取るのは一回でいい
//    val rankReq = url(rankingUrl).GET.addCookie(LoginInfo.getUserSessionByCookie)
    val rankReq = url(rankingUrl).GET.addCookie(LoginInfo.getUserSession)
    val rankRes = Http(rankReq)

    val json = rankRes().getResponseBody
    val onAirStreamInfo = parse(json).extract[OnAirStreamInfo]

    var newList = nicoLiveInfoList
    if(!onAirStreamInfo.onair_stream_list.isEmpty) {
      onAirStreamInfo.onair_stream_list foreach( f =>  newList =  newList :+ new NicoLiveInfo(f))
      addNicoLiveInfo(sortType, index + 1, nicoLiveInfoList)
    }
    newList
  }

  def javaList(): java.util.List[NicoLiveInfo] = nicoLiveInfos.asJava

}
