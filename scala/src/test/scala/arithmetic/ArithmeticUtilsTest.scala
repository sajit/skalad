package arithmetic

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by skunnumkal on 7/17/14.
 */
class ArithmeticUtilsTest  extends FlatSpec with Matchers{

  it should " determine gcd" in {
    ArithmeticUtil.gcd1(24,60) should be (12)
    ArithmeticUtil.gcd2(24,60) should be (12)
    ArithmeticUtil.gcd1(60,24) should be (12)
    ArithmeticUtil.gcd2(60,24) should be (12)

    ArithmeticUtil.gcd1(29,60) should be (1)
    ArithmeticUtil.gcd2(29,60) should be (1)
    ArithmeticUtil.gcd1(60,29) should be (1)
    ArithmeticUtil.gcd2(60,29) should be (1)


  }

  it should "show number of times a number is divisible" in {
    ArithmeticUtil.times(2,16,0) should be (4)
    ArithmeticUtil.times(3,16,0) should be (0)
  }

  it should "list of primes in range" in {
    val result = ArithmeticUtil.primeList(7,31)
    val expected = List(7,11,13,17,19,23,29,31)
    result should be (expected)
  }

  it should "determine goldbachs numbers" in {
    val (x,y) = ArithmeticUtil.goldbach(28)
    import  problems.SkaladInt._
    x.isPrime should be (true)
    y.isPrime should be (true)


  }

  it should "remove pairs below threshold" in {
     val result = ArithmeticUtil.goldbachFilteredPair(992,50)
    //println(result)
    result.foreach{case (x,y) => {x should be > 50
    y should be > 50}
    }

  }

  it should "evaluate postfix expression" in {
    val expr = "45*"
    ArithmeticUtil.postFixEvaluation(expr) should be (20.0)
    ArithmeticUtil.postFixEvaluation("46*4-") should be (20.0)
    ArithmeticUtil.postFixEvaluation("63/5-") should be (-3.0)
    ArithmeticUtil.postFixEvaluation("442+*53-/") should be (12.0)
  }

  it should "evaluate prefix expression" in {
    val expr = "*45"
    ArithmeticUtil.preFixEvaluation(expr) should be (20)
    ArithmeticUtil.preFixEvaluation("-*464") should be (20)
    ArithmeticUtil.preFixEvaluation("/*4+42-53") should be (12)
    //ArithmeticUtil.preFixEvalutation("-/635") should be (-3.0)
  }
}
