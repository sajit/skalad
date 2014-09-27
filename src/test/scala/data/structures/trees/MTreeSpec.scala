package data.structures.trees

import org.scalatest._

/**
 * Created by sajit on 9/25/14.
 */
class MTreeSpec extends FlatSpec with Matchers{

  it should "create have two constructors" in {
    val mt1 = MTree("d")
    val mt2 = MTree("d",List())

    mt1.value should be (mt2.value)
    mt1.nodeCount() should be (1)
    mt2.nodeCount() should be (1)
  }

  it should "count generations " in {
    MTree('a', List(MTree('f'))).nodeCount should be (2)
    MTree('a', List(MTree('f',List(MTree('g'))))).nodeCount should be (3)
  }

//  it should "generate build a Tree" in {
//    val expected = MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))
//    val in = "afg^^c^bd^e^^^"
//    MTreeUtils.buildTree(in) should be (expected)
//  }

  it should "process indices correctly" in {
    val idxList:List[Int] = List(9,7,1)
    val in:String = "fg^^c^bd^e^^"
    val subList:List[String] = MTreeUtils.processIndices(in,idxList)
    subList should be (List("fg^^","c^","bd^e^^"))
  }

  it should "split when zeroed" in {
    val in:String = "fg^^c^bd^e^^"
    MTreeUtils.splitWhenZeroed(in) should be (List(9,7,1))
  }
}
