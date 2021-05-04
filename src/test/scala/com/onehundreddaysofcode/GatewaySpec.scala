package com.onehundreddaysofcode

import org.scalatest.scalatest.{DiagrammedAssertions, FlatSpec}
import org.scalatest.concurrent.TimeLimits.failAfter
import org.scalatest.mockito.MockitoSugar
import org.scalatest.time.SpanSugar._
import org.mockito.Mockito.when

class GatewaySpec extends FlatSpec with DiagrammedAssertions with MockitoSugar {
  val calc = new Calc

  "Calc.sum function" should "fetch integers array, and can return sum them all." in {
    assert(calc.sum(Seq(1, 2, 3)) === 6) // true
    assert(calc.sum(Seq(0)) === 0) // true
    assert(calc.sum(Seq(-1, 1)) === 0) // true
    //  assert(calc.sum(Seq()) === 9999)     // false
  }

  it should "Overflow occure when sum them all is over Integer.MAX_VALUE." in {
    assert(calc.sum(Seq(Integer.MAX_VALUE, 1)) === Integer.MIN_VALUE)
  }
}
