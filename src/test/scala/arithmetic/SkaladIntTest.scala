package arithmetic

import org.scalatest._


/**
 * Created by skunnumkal on 7/16/14.
 */
class SkaladIntTest extends FlatSpec with Matchers{
  import arithmetic.SkaladInt
  it should "identify primes" in {
    val anInt:SkaladInt = 17
    anInt.isPrime should be (true)
    val ten:SkaladInt = 10
    ten.isPrime should be (false)

    val one:SkaladInt = 1
    one.isPrime should be (false)
  }

}
