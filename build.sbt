libraryDependencies ++= Seq(
  "com.twitter" %% "finagle-http" % "6.16.0",
  "com.twitter" %% "finagle-stats" % "6.16.0",
  "com.twitter" %% "twitter-server" % "1.7.0"
)

resolvers += "twttr" at "http://maven.twttr.com"

organization := "com.mosesn"

name := "integration"

scalaVersion := "2.10.4"
