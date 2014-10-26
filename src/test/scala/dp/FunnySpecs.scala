package dp

import org.scalatest._
/**
 * Created by sajit on 10/26/14.
 */
class FunnySpecs extends FlatSpec with Matchers{

  it should "get max seq" in {
    val asd = new LongestIncSeq(List(0,4,2,16,7))
    asd.lndsLen() should be (3)
  }

}
