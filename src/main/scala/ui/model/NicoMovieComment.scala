package ui.model

import dispatch.Defaults._
import dispatch._

import scala.collection.immutable.Map
import scala.collection.JavaConverters._

/**
 * コメントを取得するクラス。
 *
 * ニコ動のAPIについてはhttp://d.hatena.ne.jp/celitan/20101219/1292750813を参考にした。
 * webで見つかる個人ブログ等の情報は古かったり間違っていたりするので、
 * Chrome等のDeveloperToolで実際のリクエストとレスポンスを見るのがたぶん正攻法。
 *
 * Created by bububu10 on 15/04/12.
 */
class NicoMovieComment {
  // FIXME ログイン時のクッキーからユーザセッションを取得する処理は別クラスへ切り出す
  val loginUrl = "https://secure.nicovideo.jp/secure/login?site=niconico"
  val mail = "yamagishi_mist@yahoo.co.jp"
  val pass = "***********"

  // リクエストの作成。
  // メソッドはPOST、パラメータにメールアドレスとパスワードを渡す。
  // ref. http://www.flotsam.nl/dispatch-periodic-table.html
  val req = url(loginUrl).POST << Map("mail" -> mail, "password" -> pass)

  // HTTPアクセス、レスポンスを取得。
  // Future,Promiseについては理解できていない。非同期処理？なんで？
  // 以下scalaとdispatchの公式。あとで読む。
  // ref-1. http://docs.scala-lang.org/ja/overviews/core/futures.html
  // ref-2. http://dispatch.databinder.net/Promising+success+and+failure.html
  val http = new Http
  val resFuture = http(req)

  // レスポンスヘッダの中身をコンソールに出力（動作確認用）
  println("#############responseHeader##############")
  println(resFuture().getHeaders)

  // クッキーを取得
  val cookie = resFuture().getCookies.asScala

  // ちなみにgetCookie()で得られるのはjava.util.Listなので、上ではscalaのBufferに変換している。
  // 変換にはscala.collection.JavaConverters._をimportする必要がある。
  // JavaConversionsというパッケージもあるが、これは上のように{javaのコレクション}.asScalaと
  // 明示的に書かなくても暗黙的に変換するらしい。あとあと混乱しそうなのでJavaConverters推奨。
  // ref-1. http://docs.scala-lang.org/ja/overviews/collections/conversions-between-java-and-scala-collections.html
  // ref-2. http://www.ne.jp/asahi/hishidama/home/tech/scala/collection/javaconv.html

  // 一度クッキーを全部コンソールに出力（動作確認用）
  // ロギングの考え方使い方が分かってない。ちゃんと作るときはdebugレベルで動かすとログが出るように設定したい。
  println("#############cookie##############")
  cookie.foreach(c => println(c.getName + " = " + c.getValue))

  // クッキーからユーザセッションの生きてる奴を抜いてくる
  val userSession = cookie.filter( c => c.getName == "user_session" && c.getValue != "deleted" )

  // 動作確認
  println("#############userSession(ALIVE)##############")
  userSession.foreach(us => println(us.getName + " = " + us.getValue))

  // 以下はまだ
  val getflvUrl = "http://flapi.nicovideo.jp/api/getflv/"
  val postXml = <thread thread="スレッドID" version="20061206" res_from="100" fork="1" />

}
