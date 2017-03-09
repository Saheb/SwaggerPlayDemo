package controllers

import io.swagger.annotations._
import play.api.mvc.{Action, BodyParsers, Controller}
import java.sql.Timestamp

import play.api.libs.json._

trait JsonFormats {
  implicit val timestampFormat: Format[Timestamp] = new Format[Timestamp] {

    override def reads(json: JsValue) = {
      JsSuccess(new Timestamp(json.as[Long] * 1000))
    }

    override def writes(o: Timestamp) = {
      JsNumber(o.getTime / 1000)
    }
  }
}

object Reservation extends JsonFormats {
  implicit val reservationWrites: Writes[Reservation] = Json.writes[Reservation]
  implicit val reservationReads: Reads[Reservation] = Json.reads[Reservation]
}

case class Reservation(id: Option[Int],
 @ApiModelProperty(value = "Name of the resource") resourceName: String,
 @ApiModelProperty(value = "Start in epoch seconds", dataType = "Long", example = "1488800328") start: Timestamp,
 @ApiModelProperty(value = "End in epoch seconds", dataType = "Long", example = "1488807528") end: Timestamp)

@Api("Reservation")
class ReservationController extends Controller {

  @ApiImplicitParams(Array(
    new ApiImplicitParam(
      value = "Make Reservation for a resource",
      required = true,
      dataType = "controllers.Reservation", // complete path
      paramType = "body"
    )
  ))
  def reserveResource = Action(BodyParsers.parse.json[Reservation]) { request =>
    val reservation = request.body
    //persist and return Reservation with ID
    val persistedReservation = reservation.copy(id = Some(1))
    Ok(Json.toJson(persistedReservation))
  }
}
