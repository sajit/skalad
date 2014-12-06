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

  it should "get max cont sum " in {
    val inList = List(-1,5,7,-14,3,5,1)
    val result = DPContainer.longestContinuousSum(inList)
    result should be (12)
    DPContainer.longestContinuousSum(List(-1,-4)) should be (0)
  }
}
