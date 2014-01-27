import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "Scalai"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    initialCommands := """
       |// make app resources accessible
       |Thread.currentThread.setContextClassLoader(getClass.getClassLoader)
       |new play.core.StaticApplication(new java.io.File("."))
       |import com.sogima.ai._
      """.stripMargin

  )

}
