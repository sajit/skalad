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

  it should "test base case for partitioning" in {
    val idxList:List[Int]=List(1)
    val in:String = "g^"
    MTreeUtils.processIndices(in,idxList) should be (List("g^"))
  }

  it should "split when zeroed base case" in {
    MTreeUtils.splitWhenZeroed("g^") should be (List(1))
  }


    it should "generate build a Tree" in {
      val expected = MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))
      val in = "afg^^c^bd^e^^^"
      MTreeUtils.buildTree(in) should be (expected)
    }

  it should "generate a single node" in {
    val in = "g^"
    val result = MTreeUtils.buildTree(in)
    result.value should be ('g')
    result should be (MTree('g'))
  }

  it should "calculate internal path length aka sum of length of paths to all nodes" in {
   val single = MTree('a')
    single.internalPathLength() should be (0)

    val small = MTree('a',List(MTree('b'),MTree('c')))
    small.internalPathLength() should be (2)
  }

  it should "calculate internal paths 1" in {
    val tree = MTree('a', List(MTree('f', List(MTree('g')))))
    tree.internalPathLength() should be (3)

  }

  it should "print out nodes in dfs" in {
    val tree = MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))
    MTreeUtils.dfs(tree)
  }
}
