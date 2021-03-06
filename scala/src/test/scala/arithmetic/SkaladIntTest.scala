package arithmetic

import org.scalatest._


/**
 * Created by skunnumkal on 7/16/14.
 */
class SkaladIntTest extends FlatSpec with Matchers{

  import problems.SkaladInt

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

  it should "get prime factors " in {
    val sixty:SkaladInt = 60
    val expected = Set(2,3,5)
    val result = sixty.primeFactors
    result.size should be (expected.size)
    result.foreach{ factor => expected.contains(factor) should be (true)}
  }

  it should "show the multiplicy of factors" in {
    val t15: SkaladInt = 315
    val map = t15.primeFactorMultiplicity
    map.get(3) should be(Some(2))
    map.get(7) should be(Some(1))
    map.get(5) should be(Some(1))
    map.size should be (3)
  }




}
