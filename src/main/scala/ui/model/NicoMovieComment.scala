package ui.model

import common.NicoMovieLogin
import dispatch._
import util.NicoMovieUtils

/**
 * コメントを取得するクラス。
 *
 * ニコ動のAPIについてはhttp://d.hatena.ne.jp/celitan/20101219/1292750813を参考にした。
 * webで見つかる個人ブログ等の情報は古かったり間違っていたりするので、
 * Chrome等のDeveloperToolで実際のリクエストとレスポンスを見るのがたぶん正攻法。
 *
 * Created by bububu10 on 15/04/12.
 */
class NicoMovieComment(inputText: String) {

  val cookie = new NicoMovieLogin("****", "****")
  val no = NicoMovieUtils.extractMovieNo(inputText)

  val getFlvUrl = s"http://flapi.nicovideo.jp/api/getflv/$no"
  val req = url(getFlvUrl).GET.setBody(cookie.userSession.toString())

  val postXml = <thread thread="スレッドID" version="20061206" res_from="100" fork="1" />

}
