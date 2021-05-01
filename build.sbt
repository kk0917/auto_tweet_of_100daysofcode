// give the user a nice default project!
ThisBuild / organization := "com.100DaysOfCode"
ThisBuild / scalaVersion := "2.13.5"

//scalastyleSources in Compile := (unmanagedSourceDirectories in Compile).value

lazy val root = (project in file(".")).settings(
  name := "Diary Tweet of 100DaysOfCode",
  libraryDependencies ++= Seq(
    "org.scalactic"              %% "scalactic"                % "3.2.2",
    "org.scalatest"              %% "scalatest"                % "3.2.2"  % Test,
    "org.scalatest"              %% "scalatest-flatspec"       % "3.2.2"  % Test,
    "org.scoverage"              %% "scalac-scoverage-runtime" % "1.4.0"  % Test,
    "org.scoverage"              %% "scalac-scoverage-plugin"  % "1.4.0"  % "provided",
    "org.mockito"                 % "mockito-core"             % "2.21.0" % Test,
    "com.beautiful-scala"        %% "scalastyle"               % "1.5.0",
    "com.google.cloud.functions"  % "functions-framework-api"  % "1.0.4"
  ),
  assembly / test := {},
  assembly / mainClass := Some("functions.gcloud.Diary"),
  assembly / assemblyJarName := "100DaysOfCode.jar"
)
