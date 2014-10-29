package pandc

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by skunnumkal on 10/29/14.
 */
class PandCSpec extends FlatSpec with Matchers{

  it should "generate a list" in {
    val result = PandCUtil.generatePermutations("abc")
    println(result)
    result.size should be (6)
    result.distinct.size should be (6)
  }

  it should "insert into every position" in {
    val result = PandCUtil.insertIntoEveryPosition('c',"ab")
    val expected = List("cab","acb","abc")
    result.foreach{ el => expected.contains(el) should be (true)}
    result.size should be (3)
  }

}
