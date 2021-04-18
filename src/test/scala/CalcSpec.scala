import org.scalatest.{DiagrammedAssertions, FlatSpec}
import org.scalatest.concurrent.TimeLimits.failAfter
import org.scalatest.mockito.MockitoSugar
import org.scalatest.time.SpanSugar._
import org.mockito.Mockito.when

class CalcSpec extends FlatSpec with DiagrammedAssertions with MockitoSugar {
  val calc = new Calc

  "Calc.sum function" should "fetch integers array, and can return sum them all." in {
    assert(calc.sum(Seq(1, 2, 3)) === 6) // true
    assert(calc.sum(Seq(0)) === 0)       // true
    assert(calc.sum(Seq(-1, 1)) === 0)   // true
//  assert(calc.sum(Seq()) === 9999)     // false
  }

  it should "Overflow occure when sum them all is over Integer.MAX_VALUE." in {
    assert(calc.sum(Seq(Integer.MAX_VALUE, 1)) === Integer.MIN_VALUE)
  }

  "Calc.div function" should "Receive two Integer value, and return float value divided the numerator by the denominator." in {
    assert(calc.div(6, 3) === 2.0)
    assert(calc.div(1, 3) === 0.3333333333333333)
  }
  it should "Exception is thrown when dividing by 0." in {
    intercept[ArithmeticException] {
      calc.div(1, 0)
    }
  }

  "Calc.isPrime function" should "Return boolean value whether or not it is prime number." in {
    assert(calc.isPrime(0) === false)
    assert(calc.isPrime(-1) === false)
    assert(calc.isPrime(2))
    assert(calc.isPrime(17))
  }

  it should "Be able to process judging prime number under 1000 thousand value within 1 seconds." in {
    failAfter(1000 millis) {
      assert(calc.isPrime(9999991))
    }
  }

  "Calc Mock's object" should "Be able to camouflage behaviours" in {
    val mockCalc = mock[Calc]
    when(mockCalc.sum(Seq(3, 4, 5))).thenReturn(12)
    assert(mockCalc.sum(Seq(3, 4, 5)) === 12)
  }

  /** Run Coverage Test Report - scoverage
   *
   * ❯ sbt clean coverage test
   * [info] welcome to sbt 1.4.0 (Oracle Corporation Java 1.8.0_152)
   * [info] loading global plugins from /Users/ko-kamenashi/.sbt/1.0/plugins
   * [info] loading settings for project scalatest-build from plugins.sbt ...
   * [info] loading project definition from /Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/project
   * [info] loading settings for project scalatest from build.sbt ...
   * [info] set current project to ScalaTest (in build file:/Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/)
   * [success] Total time: 0 s, completed 2020/10/26 6:28:33
   * [info] Defining ThisBuild / coverageEnabled
   * [info] The new value will be used by Compile / compile / scalacOptions, libraryDependencies
   * [info] Reapplying settings...
   * [info] set current project to ScalaTest (in build file:/Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/)
   * [info] Updating
   * https://repo1.maven.org/maven2/org/scoverage/scalac-scoverage-runtime_2.12/1.3.1/scalac-scoverage-runtime_2.12-1.3.1.pom
   *   100.0% [##########] 1.9 KiB (2.2 KiB / s)
   * [info] Resolved  dependencies
   * [info] Fetching artifacts of
   * [info] Fetched artifacts of
   * [info] compiling 1 Scala source to /Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/target/scala-2.12/classes ...
   * [info] [info] Cleaning datadir [/Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/target/scala-2.12/scoverage-data]
   * [info] [info] Beginning coverage instrumentation
   * [info] [info] Instrumentation completed [18 statements]
   * [info] [info] Wrote instrumentation file [/Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/target/scala-2.12/scoverage-data/scoverage.coverage.xml]
   * [info] [info] Will write measurement data to [/Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/target/scala-2.12/scoverage-data]
   * [info] compiling 1 Scala source to /Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/target/scala-2.12/test-classes ...
   * [info] CalcSpec:
   * [info] Calc.sum function
   * [info] - should fetch integers array, and can return sum them all.
   * [info] - should Overflow occure when sum them all is over Integer.MAX_VALUE.
   * [info] Calc.div function
   * [info] - should Receive two Integer value, and return float value divided the numerator by the denominator.
   * [info] - should Exception is thrown when dividing by 0.
   * [info] Calc.isPrime function
   * [info] - should Return boolean value whether or not it is prime number.
   * [info] - should Be able to process judging prime number under 1000 thousand value within 1 seconds.
   * [info] Calc Mock's object
   * [info] - should Be able to camouflage behaviours
   * [info] Run completed in 1 second, 418 milliseconds.
   * [info] Total number of tests run: 7
   * [info] Suites: completed 1, aborted 0
   * [info] Tests: succeeded 7, failed 0, canceled 0, ignored 0, pending 0
   * [info] All tests passed.
   * [success] Total time: 19 s, completed 2020/10/26 6:28:56
   */
  /** scoverage Report
   *
   * ❯ sbt coverageReport
   * [info] welcome to sbt 1.4.0 (Oracle Corporation Java 1.8.0_152)
   * [info] loading global plugins from /Users/ko-kamenashi/.sbt/1.0/plugins
   * [info] loading settings for project scalatest-build from plugins.sbt ...
   * [info] loading project definition from /Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/project
   * [info] loading settings for project scalatest from build.sbt ...
   * [info] set current project to ScalaTest (in build file:/Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/)
   * [info] Waiting for measurement data to sync...
   * [info] Reading scoverage instrumentation [/Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/target/scala-2.12/scoverage-data/scoverage.coverage.xml]
   * [info] Reading scoverage measurements...
   * [info] Generating scoverage reports...
   * [info] Written Cobertura report [/Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/target/scala-2.12/coverage-report/cobertura.xml]
   * [info] Written XML coverage report [/Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/target/scala-2.12/scoverage-report/scoverage.xml]
   * [info] Written HTML coverage report [/Users/ko-kamenashi/Desktop/Samples/Scala/N予備校/workspace/ScalaTest/target/scala-2.12/scoverage-report/index.html]
   * [info] Statement coverage.: 100.00%
   * [info] Branch coverage....: 100.00%
   * [info] Coverage reports completed
   * [info] All done. Coverage was [100.00%]
   * [success] Total time: 3 s, completed 2020/10/26 6:37:42
   */
}
