package ui.model

import scala.xml.Node

/**
 * Created by mist on 2015/09/02.
 */
class NicoCommentModel(chat: Node) {
  val thread = (chat \\ "chat" \ "@thread").toString()
  val no = (chat \\ "chat" \ "@no").toString()
  val vpos = (chat \\ "chat" \ "@vpos").toString()
  val date = (chat \\ "chat" \ "@date").toString()
  val mail = (chat \\ "chat" \ "@mail").toString()
  val user_id = (chat \\ "chat" \ "@user_id").toString()
  val premium = (chat \\ "chat" \ "@premium").toString()
  val anonymity = (chat \\ "chat" \ "@anonymity").toString()
  val comment = chat.text
}
