package recursion

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by sajit on 12/5/14.
 */
class RecursionSpec extends FlatSpec with Matchers{

  it should "print params" in {
    RecursionUtils.printParam(0,0,3,"")
  }

  it should "return max" in {
    RecursionUtils.maxVal(List[Integer](4,1,-5,3)) should be (4)
  }

  it should "flatten a mixed list 1 " in {
    val ll = List(1,List(4,5))
    RecursionUtils.myFlatten(ll) should be (List(1,4,5))
  }

  it should "flatten mixed list 2 " in {
    val ll = List(List(4,5))
    RecursionUtils.myFlatten(ll) should be (List(4,5))
  }
  it should "take 4 elements " in {
    RecursionUtils.takeN(4,List(4,5,2,5,6,6,7,3))
  }

  it should "throw exception if take more" in {
    try{
      RecursionUtils.takeN(4,List(5,3,4))
      fail()
    }catch{
      case re:RuntimeException => {}
      case _:Throwable => fail()
    }
  }

}
