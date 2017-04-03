package controllers

import io.swagger.annotations.Api
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def redirectDocs = Action {
    Redirect("/assets/lib/swagger-ui/index.html?/url=http://localhost:9000/swagger.json")
  }
}