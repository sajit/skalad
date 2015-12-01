package reactive

import org.scalatest.{Matchers, FlatSpec}
import rx._

/**
 * Created by skunnumkal on 9/24/14.
 */
class ScalaRxBasicSpec extends FlatSpec with Matchers{

  it should "be reactive" in {
    val a = Var(1); val b = Var(2)
    val c = Rx{ a() + b() }
    true should be (true)
    c() should be (3)
    a() = 4
    c() should be (6)
  }

}
