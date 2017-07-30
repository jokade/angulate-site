//     Project: angulate-site
//      Module:
// Description:
package app

import angulate2.material.MdButtonModule
import angulate2.router.{NavigationStart, Router}
import angulate2.std._

import scala.scalajs.js

@Component(
  selector = "angulate-site-app"
)
@LoadTemplate
@LoadStyles
class AppComponent(router: Router) {
  var showNavbarShadow = false

  router.events.subscribe { data =>
    showNavbarShadow = data.url != "/"
  }
}
