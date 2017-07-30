//     Project: angulate-site
//      Module:
// Description:
package app.pages

import angulate2.material.MdButtonModule
import angulate2.router.RouterModule
import angulate2.std._
import app.pages.docs.Documents
import app.pages.homepage.Homepage

@NgModule(
  imports = @@[
  RouterModule,
  MdButtonModule],
  declarations = @@[Homepage,Documents]
)
class PagesModule {

}
