package ui.model

import dispatch.retry.Success
import dispatch.{Http, as, url}
import scala.concurrent.ExecutionContext
import scala.util.Try
import scala.xml.XML

/**
 * Created by bububu10 on 15/04/12.
 */
class NicoMovieComment(implicit xc: ExecutionContext = ExecutionContext.global) {
  val loginUrl = "https://secure.nicovideo.jp/secure/login?site=niconico"
  val getflvUrl = "http://flapi.nicovideo.jp/api/getflv/"
  val mail = "yamagishi_mist@yahoo.co.jp"
  val pass = "********"

  val req = url(loginUrl)
  val reqWithParams = req.POST
    .setContentType("application/x-www-form-urlencoded","UTF-8")
    .addParameter("mail_tel",mail)
    .addParameter("password", pass)
  val future = Http(reqWithParams)

  val postXml = <thread thread="スレッドID" version="20061206" res_from="100" fork="1" />

}
