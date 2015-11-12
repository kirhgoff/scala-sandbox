name := """scala-sandbox"""

version := "1.0-SNAPSHOT"

//resolvers += "Local Maven Repository" at "http://eif-repository.moex.com/nexus/content/repositories/releases"

libraryDependencies ++= {
  val akkaV = "2.3.6"
  Seq(
    "org.specs2" %% "specs2-core" % "2.4.16" % "test"
  )
}


fork in run := true
