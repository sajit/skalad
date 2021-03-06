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
    DPContainer.longestContinuousSum(List(-7,1,2,-2,5,6)) should be (12)
  }

  it should "do 0-1 KP" in {
    DPContainer.kp1(15) should be (36)
  }
  it should "do 0-1 KP with 1 item per type" in {
    DPContainer.kp2(15) should be (15)
  }
}
