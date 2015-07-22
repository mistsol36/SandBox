package ui.model

import scala.slick.driver.SQLiteDriver.simple._
import java.io.File

/**
 * Created by mist on 2015/07/08.
 */
class Test {
  // database フォルダの test.sqlite3 ファイルをデータベースとして使用
  // val DatabasePath = "%UserProfile%\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cookies"
  // val DatabasePath = "C:\\Users\\mist\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cookies"

  val basePath = getBasePath("C:\\Users\\mist\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles")
  val cookiePath = basePath + "\\cookies.sqlite"
  
  val Initialize = !new File(cookiePath).exists()

  val db = Database.forURL("jdbc:sqlite:" + cookiePath, driver = "org.sqlite.JDBC")
  val con = db.createSession().conn
  val stmt = con.prepareStatement("select * from main.moz_cookies")
  val result = stmt.execute()
  val resultSet = stmt.executeQuery()

  def getBasePath(dir: String) = {
    new File(dir).listFiles.head.getPath
    //println(path)
  }
}
