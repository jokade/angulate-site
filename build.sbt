version in ThisBuild := "0.1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.11"

organization in ThisBuild := "de.surfice"

lazy val sharedSettings = Seq(
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-Xlint"),
  libraryDependencies ++= Seq(
  ),
  scalacOptions ++= (if (isSnapshot.value) Seq.empty else Seq({
        val a = baseDirectory.value.toURI.toString.replaceFirst("[^/]+/?$", "")
        val g = "https://raw.githubusercontent.com/jokade/angulate-site"
        s"-P:scalajs:mapSourceURI:$a->$g/v${version.value}/"
      }))
)


lazy val angulateSite = project.in(file("."))
  .enablePlugins(Angulate2BundlingPlugin)
  .settings(sharedSettings: _*)
  .settings(dontPublish: _*)
  .settings( 
    name := "angulate-site",
    ngBootstrap := Some("app.AppModule"),
    ngEnableProdMode := false,
    libraryDependencies ++= Seq(
      "de.surfice" %%% "angulate2-material" % "0.0.1-SNAPSHOT"
//      "de.surfice" %%% "angulate2-primeng" % "0.0.1-SNAPSHOT"
    )
    // sbt-web settings
//    markdownFileTask := Nil,
//    markdownFileTask := {
//      import WebKeys._
//      val sourceDir = (sourceDirectory in Assets) / "docs"
//      val targetDir = webTarget.value / "docs"
//      val sources = sourceDir ** "*.md"
//      val mappings = sources pair relativeTo(sourceDir)
//      val renamed = mappings map { case (file, path) => file -> path.replaceAll("md","html") }
//      println(renamed)
//      renamed map (_._2)
//    },
//    sourceGenerators in Assets <+= markdownFileTask,
//    sassExecutable in Assets := List("./node_modules/node-sass/bin/node-sass"),
//    sassCss in Assets := Some( (file) => Seq("-o",file.output.getParentFile.getAbsolutePath,file.input.getAbsolutePath) ),
//    sassCssMinified in Assets := None,
    
//    fastOptJS in Compile <<= (fastOptJS in Compile) dependsOn(WebKeys.stage in Assets)
  )

//val markdownFileTask = taskKey[Seq[File]]("Transpile markdown files in src/main/assets/docs")

lazy val publishingSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra := (
    <url>https://github.com/jokade/angulate-site</url>
    <licenses>
      <license>
        <name>MIT License</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:jokade/angulate-site</url>
      <connection>scm:git:git@github.com:jokade/angulate-site.git</connection>
    </scm>
    <developers>
      <developer>
        <id>jokade</id>
        <name>Johannes Kastner</name>
        <email>jokade@karchedon.de</email>
      </developer>
    </developers>
  )
)
 
lazy val dontPublish = Seq(
    publish := {},
    publishLocal := {},
    publishArtifact := false,
    publishTo := Some(Resolver.file("Unused transient repository",file("target/unusedrepo")))
  )


