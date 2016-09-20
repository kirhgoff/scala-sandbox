name := "scala-sandbox"

organization := "org.kirhgoff"

version := "1.2"

scalaVersion := "2.11.7"

resolvers += "Local Maven Repository" at "http://eif-repository.moex.com/nexus/content/repositories/releases"

libraryDependencies ++= Seq(
    "org.scalatest"   %% "scalatest"    % "2.2.4"   % "test",
    "org.scalacheck"  %% "scalacheck"   % "1.12.5"      % "test"
)

scalacOptions ++= List("-feature","-deprecation", "-unchecked", "-Xlint")

javaOptions += "-Xmx4G"






