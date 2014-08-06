package oops

import data.structures.trees.TreeNode
import org.scalatest.{Matchers, FlatSpec}

import scala.collection.mutable.Stack

/**
 * Created by sajit on 8/6/14.
 */
class OopTests extends FlatSpec with Matchers{

  it should "have multiple constructors" in {
     val a = TreeNode(6,None,None)
     val b = new TreeNode(6)
     b.equals(a) should be (true)
  }

  it should "apply" in {
    val a = TreeNode(5,None,None)
    val b = TreeNode.apply(5)
    b.equals(a) should be (true)
    val c = TreeNode(5)
    c.equals(a) should be (true)
  }
}
