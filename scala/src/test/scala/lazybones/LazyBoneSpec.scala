package lazybones

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by sajit.kunnumkal on 12/4/2015.
 */
class LazyBoneSpec extends FlatSpec with Matchers{

  val forgetfulMes = new ForgetFulFoo()


  it should "read cached value" in {

    val result = forgetfulMes.bar(5)
    result should be (4)
  }

  it should "throw an error when bad strict params" in {
    intercept[ArithmeticException](forgetfulMes.printX(1/0))
  }

  it should "not throw an error unless params were called " in {
    forgetfulMes.lazyPrintNonX1(1/0)
  }

  it should "blow up but only when lazy param is needed " in {
    intercept[ArithmeticException](forgetfulMes.lazyPrintX(1/0))
  }


}
