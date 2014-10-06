package data.structures.graphs

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by sajit on 10/5/14.
 */
class GraphBaseSpec extends FlatSpec with Matchers {

  it should "check equality (base case)" in {
    val g1 = new Graph[Char,Int]()
    val nodes = List('a','b','c')
    g1.addNode(nodes(0))
    g1.addNode(nodes(1))
    g1.addNode(nodes(2))

    val g2 = new Graph[Char,Int]()
    g2.addNode(nodes(1))
    g2.addNode(nodes(2))
    g2.addNode(nodes(0))

    g1.equals(g2) should be (true)


    g1.equals(g1) should be (true)

  }

  it should "not be equal if nodes are diff" in {
    val g1 = new Graph[Char,Int]()
    g1.addNode('a')
    val g2 = new Graph[Char,Int]()
    g2.addNode(('b'))
    g1.equals(g2) should be (false)
    g2.addNode('a')
    g2.equals(g1) should be (false)
    g1.addNode('b')
    g1.equals(g2) should be (true)
  }

  it should "test equality based on edges" in {
    val g1 = new Graph[Char, Int]()
    g1.addNode('a')
    val g2 = new Graph[Char, Int]()
    g2.addNode(('b'))
    g2.addNode('a')
    g1.addNode('b')
    g1.equals(g2) should be (true)
    g1.addEdge('a','b',5)
    g1.equals(g2) should be (false)
    g2.addEdge('b','a',5)
    g1.equals(g2) should be (false)
  }

  //it should "check equality for edges"
}
