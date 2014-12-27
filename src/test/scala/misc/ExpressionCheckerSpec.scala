package misc

/**
 * Created by skunnumkal on 12/26/14.
 */
import org.scalatest._
class ExpressionCheckerSpec extends FlatSpec with Matchers{

  it should "say its valid " in {
    val expr = "1+1"
    ExpressionChecker.isValid(expr) should be (true)
  }

  it should "identify invalid infix" in {
    ExpressionChecker.isValid("+11") should be (false)
    ExpressionChecker.isValid("11+") should be (false)
  }

  it should "be Ok with long expression" in {
    ExpressionChecker.isValid("1+3+4+3") should be (true)

  }

  it should "not support numbers > 9" in {
    ExpressionChecker.isValid("1+34+3") should be (false)
  }

  it should "not be Ok with bad expressions" in {
    ExpressionChecker.isValid("1+34/+3") should be (false)
    ExpressionChecker.isValid("1+/3") should be (false)
  }
  it should "say its valid2 " in {
    val expr = "1+1"
    ExpressionChecker.isValid2(expr) should be (true)
  }

  it should "identify invalid infix 2" in {
    ExpressionChecker.isValid2("+11") should be (false)
    ExpressionChecker.isValid2("11+") should be (false)
  }

  it should "be Ok with long expression2" in {
    ExpressionChecker.isValid2("1+3+4+3") should be (true)

  }

  it should "not support 2 numbers > 9" in {
    ExpressionChecker.isValid2("1+34+3") should be (false)
  }

  it should "not be Ok with 2 bad expressions" in {
    ExpressionChecker.isValid2("1+34/+3") should be (false)
    ExpressionChecker.isValid2("1+/3") should be (false)
  }

}
