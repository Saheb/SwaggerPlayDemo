name := "SwaggerDemo"

version := "1.0"

lazy val `swaggerdemo` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq( jdbc , cache , ws   , specs2 % Test ,
  "io.swagger" %% "swagger-play2" % "1.5.3",
  "com.typesafe.play" %% "play-json" % "2.5.10",
  "org.webjars" %% "webjars-play" % "2.5.0-4",
  "org.webjars" % "swagger-ui" % "2.2.0"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  