package ui.model

import java.io.File
import java.util.Calendar

import com.ning.http.client.cookie.Cookie
import dispatch.Defaults._
import dispatch._

import scala.collection.JavaConverters._
import scala.collection.immutable.Map
import scala.slick.driver.SQLiteDriver.simple._

/**
 * ログイン情報はアプリケーション内で１つでいい気がするのでobjectにする。
 *
 * Created by bububu10 on 15/05/27.
 */
object LoginInfo {

  /** Login URL */
  val loginUrl: String = "https://secure.nicovideo.jp/secure/login?site=niconico"

  // TODO メアド・パスワードは設定ファイルから読み込むようにする
  /** メールアドレス */
  val mailAddress: String = "***"

  /** パスワード */
  val password: String = "***"

  /** ユーザーセッション */
  def getUserSession: Cookie = {
    // リクエストの作成。
    // メソッドはPOST、パラメータにメールアドレスとパスワードを渡す。
    // ref. http://www.flotsam.nl/dispatch-periodic-table.html
    val req = url(loginUrl).POST << Map("mail" -> mailAddress, "password" -> password)

    // HTTPアクセス、レスポンスを取得。
    // Future,Promiseについては理解できていない。非同期処理？なんで？
    // 以下scalaとdispatchの公式。あとで読む。
    // ref-1. http://docs.scala-lang.org/ja/overviews/core/futures.html
    // ref-2. http://dispatch.databinder.net/Promising+success+and+failure.html
    val resFuture = Http(req)

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
    //    println(cookie)
    //    cookie.foreach(c => println(c.getName + " : " + c.getValue))

    // クッキーからユーザセッションの生きてる奴を抜いてくる
    //    println(cookie.filter(c => c.getName == "user_session" && c.getValue != "deleted"))
    //    println(cookie.filter(c => c.getName == "user_session"))
    val userSession = cookie.filter(c => c.getName == "user_session" && c.getValue != "deleted")
    userSession(0)
  }

  def getUserSessionByCookie: Cookie = {
    val basePath = getBasePath("C:\\Users\\mist\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles")
    val cookiePath = basePath + "\\cookies.sqlite"

    val Initialize = !new File(cookiePath).exists()

    val db = Database.forURL("jdbc:sqlite:" + cookiePath, driver = "org.sqlite.JDBC")
    val con = db.createSession().conn
    val stmt = con.prepareStatement("select * from main.moz_cookies where name = 'user_session' and baseDomain = 'nicovideo.jp'")
    val result = stmt.execute()
    val resultSet = stmt.executeQuery()

  //  println(resultSet.next())
    val name = resultSet.getString("name")
    val value = resultSet.getString("value")
    val host = resultSet.getString("host")
    val path = resultSet.getString("path")
//    val expiry =   resultSet.getLong("expiry") * 1000
    val cal = Calendar.getInstance()
    cal.set(2030,1,1)
    val expiry = cal.getTime.getTime
    val isSecure =    resultSet.getBoolean("isSecure")
    val isHttpOnly =    resultSet.getBoolean("isHttpOnly")

    Cookie.newValidCookie(name, value, host, value, path, expiry, -1, isSecure, isHttpOnly)
  }

  private def getBasePath(dir: String) = {
    new File(dir).listFiles.head.getPath
    //println(path)
  }
}
