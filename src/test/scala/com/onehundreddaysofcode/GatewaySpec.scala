package com.onehundreddaysofcode

import com.google.cloud.functions.HttpResponse
import org.scalatest.flatspec.AnyFlatSpec

class GatewaySpec extends AnyFlatSpec {
  val gateway = new Gateway()

  "buildResponse def of gateway" should "returns responses that has 200" in {
    assert(gateway.buildResponse(resp: HttpResponse) == )
    assert(gateway.sum(Seq(1, 2, 3)) === 6) // true
    assert(gateway.sum(Seq(0)) === 0) // true
    assert(gateway.sum(Seq(-1, 1)) === 0) // true
    //  assert(gateway.sum(Seq()) === 9999)     // false
  }

  it should "Overflow occure when sum them all is over Integer.MAX_VALUE." in {
    assert(gateway.sum(Seq(Integer.MAX_VALUE, 1)) === Integer.MIN_VALUE)
  }
}
