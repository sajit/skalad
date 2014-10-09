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
    val graph = new DirectedGraph[Char]()
    graph.addNode(n1)
    graph.addEdge(n1.value,n2.value,5)

    n1.equals(n2) should be (true)
    n1.equals(GraphNode('b')) should be (false)
  }

  it should "add an edge to a graph" in {

    val n1 = GraphNode('a')
    val n2 = GraphNode('a')
    val graph = new DirectedGraph[Char]()
    graph.addNode(n1)
    graph.addEdge(n1.value,n2.value,5)

    graph.edgeTarget(GraphEdge(n1.value,n2.value,5),n1) should be (Some(n1))

  }
}
