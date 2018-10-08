val ScalatraVersion = "2.6.3"

organization := "com.example"

name := "scalatraTest"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.9.v20180320" % "container;compile",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "net.liftweb" %% "lift-json" % "3.1.1",
  "com.alibaba" % "fastjson" % "1.2.47"
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
