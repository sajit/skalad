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

}
