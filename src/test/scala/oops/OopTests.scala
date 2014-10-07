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
case class Node(x:Char)
case class Edge(n1:Node,n2:Node,value:Int)

class CaseTests extends FlatSpec with Matchers {
  it should "be sane" in {
    true should be (true)
  }
  it should "check case class equality" in {
    val n1 = Node('a')
    val n2 = Node('a')
    n1.equals(n2) should  be (true)
    n2.equals(n1) should be (true)
    Node('b').equals(Node('a')) should be (false)
  }
  it should "check case for edge class equality" in {
    val e1 = Edge(Node('a'),Node('b'),4)
    val e2 = Edge(Node('b'),Node('a'),4)
    e1.equals(e2) should be (false)
    e1.equals(Edge(Node('a'),Node('b'),4)) should be (true)
  }

  it should "check case class list equality" in {

    val l1 = List(Edge(Node('a'),Node('b'),4))
    val l2 = List(Edge(Node('a'),Node('b'),4))
    l1.equals(l2) should be (true)
  }
}
