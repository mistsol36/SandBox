package ui.model

/**
 * Created by mist on 2015/06/10.
 */
class NicoLiveInfo(builder: NicoLiveInfoBuilder) {
  val id: Int = builder.id toInt
  val hideZapping: Boolean = builder.hide_zapping
  val isNsen: Boolean = builder.is_nsen
  val isProduct: Boolean = builder.is_product
  val isZappingModeEnabled: Boolean = builder.is_zapping_mode_enabled
  val thumbnailSmallUrl: String = builder.thumbnail_small_url
  val title: String = builder.title
//   val viewCounter: Int = builder.view_counter toInt

  // Add and multiply by prime numbers
  override def hashCode = id

  override def equals(other:Any) = other match {
    case that: NicoLiveInfo => (that canEqual other) && (this.id == that.id)
    case _ => false
  }

  private def canEqual(other: Any) = {
    other.isInstanceOf[NicoLiveInfo]
  }

}

case class OnAirStreamInfo(onair_stream_list: List[NicoLiveInfoBuilder])
case class NicoLiveInfoBuilder(hide_zapping: Boolean,id: String, is_nsen: Boolean, is_product: Boolean, is_zapping_mode_enabled: Boolean, thumbnail_small_url: String, title: String, view_counter: String)

