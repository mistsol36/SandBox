package common

import dispatch.Defaults._
import dispatch._

import scala.collection.JavaConverters._
import scala.collection.immutable.Map

/**
 * Created by bububu10 on 15/05/12.
 */
class NicoMovieLogin(mailAddress: String, password: String) {

    val loginUrl = "https://secure.nicovideo.jp/secure/login?site=niconico"

    // リクエストの作成。
    // メソッドはPOST、パラメータにメールアドレスとパスワードを渡す。
    // ref. http://www.flotsam.nl/dispatch-periodic-table.html
    val req = url(loginUrl).POST << Map("mail" -> mailAddress, "password" -> password)

    // HTTPアクセス、レスポンスを取得。
    // Future,Promiseについては理解できていない。非同期処理？なんで？
    // 以下scalaとdispatchの公式。あとで読む。
    // ref-1. http://docs.scala-lang.org/ja/overviews/core/futures.html
    // ref-2. http://dispatch.databinder.net/Promising+success+and+failure.html
    val http = new Http
    val resFuture = http(req)

    //    println("#############responseHeader##############")
    //    println(resFuture().getHeaders)

    // クッキーを取得
    val cookie = resFuture().getCookies.asScala

    // ちなみにgetCookie()で得られるのはjava.util.Listなので、上ではscalaのBufferに変換している。
    // 変換にはscala.collection.JavaConverters._をimportする必要がある。
    // JavaConversionsというパッケージもあるが、これは上のように{javaのコレクション}.asScalaと
    // 明示的に書かなくても暗黙的に変換するらしい。あとあと混乱しそうなのでJavaConverters推奨。
    // ref-1. http://docs.scala-lang.org/ja/overviews/collections/conversions-between-java-and-scala-collections.html
    // ref-2. http://www.ne.jp/asahi/hishidama/home/tech/scala/collection/javaconv.html

    //    println("#############allCookie##############")
    //    cookie.foreach(c => println(c.getName + " = " + c.getValue))

    // クッキーからユーザセッションの生きてる奴を抜いてくる
    val userSession = cookie.filter(c => c.getName == "user_session" && c.getValue != "deleted")

    //    println("#############userSession(ALIVE)##############")
    //    userSession.foreach(us => println(us.getName + " = " + us.getValue))

}
