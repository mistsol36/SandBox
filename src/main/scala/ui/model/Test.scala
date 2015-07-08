package ui.model

import scala.slick.driver.SQLiteDriver.simple._
import java.io.File

/**
 * Created by mist on 2015/07/08.
 */
class Test {
  // database フォルダの test.sqlite3 ファイルをデータベースとして使用
  // val DatabasePath = "%UserProfile%\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cookies"
  val DatabasePath = "C:\\Users\\mist\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cookies"

  val Initialize = !new File(DatabasePath).exists()

  val db = Database.forURL("jdbc:sqlite:" + DatabasePath, driver = "org.sqlite.JDBC")
  val con = db.createSession().conn
  val stmt = con.prepareStatement("select * from cookies")
  val result = stmt.execute()
  val resultSet = stmt.executeQuery()
}
