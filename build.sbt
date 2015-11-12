name := "scala-sandbox"

organization := "org.kirhgoff"

version := "1.2"

scalaVersion := "2.11.7"

resolvers += "Local Maven Repository" at "http://eif-repository.moex.com/nexus/content/repositories/releases"

//Define dependencies. These ones are only required for Test and Integration Test scopes.
libraryDependencies ++= Seq(
    "org.scalatest"   %% "scalatest"    % "2.2.4"   % "test",
    "org.scalacheck"  %% "scalacheck"   % "1.12.5"      % "test"
)

// Compiler settings. Use scalac -X for other options and their description.
// See Here for more info http://www.scala-lang.org/files/archive/nightly/docs/manual/html/scalac.html 
scalacOptions ++= List("-feature","-deprecation", "-unchecked", "-Xlint")



