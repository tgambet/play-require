import sbt._
import sbt.Keys._

object PluginBuild extends Build {

  lazy val playRequirejs = Project(
    id = "play-requirejs",
    base = file("."),
    settings = mainSettings
  )

  lazy val mainSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ Seq(
    sbtPlugin := true,
    organization := "org.github.tgambet",
    name := "play-requirejs",
    version := "0.1-SNAPSHOT",
    resolvers ++= Seq(
      Classpaths.typesafeReleases,
      Classpaths.typesafeSnapshots
    ),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.0.M5b" % "test",
      "org.json4s" %% "json4s-native" % "3.2.4",
      "com.google.protobuf" % "protobuf-java" % "2.5.0"
    ),
    scalacOptions ++= Seq("-deprecation", "-unchecked"),
    parallelExecution in Test := false
  ) ++ addSbtPlugin("play" % "sbt-plugin" % "2.1.0")

}
