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

}
