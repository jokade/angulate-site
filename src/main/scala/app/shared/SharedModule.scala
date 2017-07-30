//     Project: angulate-site
//      Module:
// Description:
package app.shared

import angulate2.material.{MdButtonModule, MdToolbarModule}
import angulate2.router.RouterModule
import angulate2.std._

@NgModule(
  imports = @@[RouterModule,MdToolbarModule,MdButtonModule],
  exports = @@[AppNavbarComponent],
  declarations = @@[AppNavbarComponent]
)
class SharedModule
