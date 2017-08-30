
name := "$name$"
description:= "$project_description$"

scalaVersion := "2.11.8"
organization := "io.tabmo"

scalacOptions ++= Seq(
  "-deprecation",           // Warn when deprecated API are used
  "-feature",               // Warn for usages of features that should be importer explicitly
  "-unchecked",             // Warn when generated code depends on assumptions
  "-Xlint",                 // Additional warnings (see scalac -Xlint:help)
  "-Xlog-reflective-calls", // Print a message when a reflective method call is generated
  "-Xfuture",               // Turn on future language features
  "-Ywarn-numeric-widen",   // Warn when numeric are widened
  "-Ywarn-dead-code",       // Warn when dead code is identified
  "-Yno-adapted-args",      // Error if an argument list is modified to match the receive
  "-Ywarn-inaccessible",    // Warn about inaccessible types in method signatures
  "-Ywarn-nullary-override",// Warn when non-nullary overrides nullary, e.g. def foo() over def foo.
  "-Ywarn-infer-any",       // Warn when a type argument is inferred to be `Any`.
  "-encoding", "UTF-8"
)

scalacOptions in doc in Compile := Nil

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(PlayRestSettings)
  .settings(
    libraryDependencies ++= Seq(
      ws,
      filters,
      json,
      "org.scalatest" %% "scalatest" % "$scalatest_version$" % "test",
      "org.scalatestplus.play" %% "scalatestplus-play" % "$scalatestplay_version$" % Test
    )
  )


routesGenerator := InjectedRoutesGenerator

/**
 * Rest-specific configuration to override play2 layout
 * `assets` and `public` folder will not be generated
 */
lazy val PlayRestSettings = {
  val blackhole = new java.io.File("/dev/null")
  Seq(
    sourceDirectory in Assets  := blackhole,
    sourceDirectory in TestAssets := blackhole,
    resourceDirectory in Assets := blackhole,
    routesImport ++= Seq()
  )
}
