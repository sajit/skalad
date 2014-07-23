package data.structures.trees

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by skunnumkal on 7/23/14.
 */
class TreeUtilTest extends FlatSpec with Matchers{

  it should "create a tree" in {

    val root = Node('a',End,Node('b',End,End))

    TreeUtils.inOrder(root)

  }

  it should "count number of nodes to 2 " in {
    val root = Node('a',End,Node('b',End,End))
    TreeUtils.count(root) should be (2)
  }

}
