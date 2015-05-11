package ui.model

import javafx.beans.property.{StringProperty, SimpleStringProperty}
;

/**
 * Created by bububu10 on 15/05/12.
 */
class CommentTableModel(userId: String, comment: String) {
  def userIdProperty: StringProperty = new SimpleStringProperty(userId)
  def commentProperty: StringProperty = new SimpleStringProperty(comment)
}
