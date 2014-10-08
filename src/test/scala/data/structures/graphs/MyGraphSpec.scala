package data.structures.graphs

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by skunnumkal on 10/8/14.
 */
class MyGraphSpec extends FlatSpec with Matchers{

  it should "not distinguish same nodes" in {
    val n1 = GraphNode('a')
    val n2 = GraphNode('a')
    n1.equals(n2) should be (true)
  }

  it should "not distinguish same nodes with diff edges" in {
    val n1 = GraphNode('a')
    val n2 = GraphNode('a')
    n2.addEdge(GraphEdge('a','b',4))
    n1.equals(n2) should be (true)
  }
}
