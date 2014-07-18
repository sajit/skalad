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

  it should "identify coprimes" in {
    val anInt:SkaladInt = 24
    anInt.isCoPrime(60) should be (false)
    val ten:SkaladInt = 10
    ten.isCoPrime(20) should be (false)

    val one:SkaladInt = 1
    one.isCoPrime(31) should be (true)

    val four:SkaladInt = 4
    four.isCoPrime(9) should be (true)
  }

  it should "get phis" in {
    val nine:SkaladInt = 9
    nine.phi.length should be (6)
  }

}
