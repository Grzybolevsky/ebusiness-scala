ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """ebusiness-scala""",
    libraryDependencies ++= Seq(
      guice,
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.11.4",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.11.4",
      "io.lemonlabs" %% "scala-uri" % "4.0.2",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )