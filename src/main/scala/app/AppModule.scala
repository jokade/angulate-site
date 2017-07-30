//     Project: angulate-site
//      Module:
// Description:
package app

import angulate2.forms.FormsModule
import angulate2.material._
import angulate2.platformBrowser.BrowserModule
import angulate2.std._
import app.pages.PagesModule
import app.pages.docs.Documents
import app.pages.homepage.Homepage
import app.shared.SharedModule

@NgModule(
  imports = @@[
    BrowserModule,
    FormsModule] ++
    // app modules
  @@[
    SharedModule,
    PagesModule,
    AppRoutingModule],
  declarations = @@[AppComponent],
  bootstrap = @@[AppComponent]
)
class AppModule

@Routes(
  root = true,
  Route(path = "", component = %%[Homepage], pathMatch = "full" ),
  Route(path = "docs", component = %%[Documents])
)
class AppRoutingModule
