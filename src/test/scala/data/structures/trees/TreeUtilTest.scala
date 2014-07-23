package data.structures.trees

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by skunnumkal on 7/23/14.
 */
class TreeUtilTest extends FlatSpec with Matchers{

  it should "create a tree" in {

    val root = Node('a',End,Node('b',End,End))

    //TreeUtils.inOrder(root)

  }

  it should "count number of nodes to 2 " in {
    val root = Node('a',End,Node('b',End,End))
    TreeUtils.count(root) should be (2)
  }

  def searchTree(node: Node[Char]): Unit = {
    node.left.height - node.right.height should be <= 1
    if(!node.left.eq(End)){
      searchTree(node.left.asInstanceOf[Node[Char]])
    }
    if(!node.right.eq(End)){
      searchTree(node.right.asInstanceOf[Node[Char]])
    }
  }

  it should "create a balanced tree" in {
    val nums = List('a','x','i','d','y','g')
    val root = TreeUtils.cBalanced(nums)
    TreeUtils.inOrder(root)
    TreeUtils.count(root) should be (nums.length)
    searchTree(root);
  }

}
