package data.structures.graphs

/**
 * Created by sajit on 10/5/14.
 */

abstract class GraphBase[T, U] {
  case class Edge(n1: Node, n2: Node, value: U) {
    def toTuple = (n1.value, n2.value, value)
    override def equals(o: Any) = o match {
      case e:Edge => { ((n1.equals(e.n1) && n2.equals(e.n2)) || (n1.equals(e.n2) && n2.equals(e.n1))) &&
        e.value.equals(value)
      }
      case _ => false
    }
    override def hashCode():Int = n1.hashCode()+n2.hashCode()+value.hashCode()
  }
  case class Node(value: T) {
    var adj: List[Edge] = Nil
    def neighbors: List[Node] = adj.map(edgeTarget(_, this).get)
  }

  var nodes: Map[T, Node] = Map()
  var edges: List[Edge] = Nil

  // If the edge E connects N to another node, returns the other node,
  // otherwise returns None.
  def edgeTarget(e: Edge, n: Node): Option[Node]

  override def equals(o: Any) = o match {
    case g: GraphBase[T,U] => {
//      println("Are edges equal?" + edges.toSet.equals(g.edges.toSet))
//      println("This edges" + edges.toSet)
//      println("Those edges " + g.edges.toSet)
      ((nodes.keys.toSet -- g.nodes.keys.toSet == Set.empty) &&
      edges.equals(g.edges))}
      //edges.map(_.toTuple).toSet -- g.edges.map(_.toTuple).toSet == Set.empty)
    case _ => false
  }

  def addNode(value: T) = {
    val n = new Node(value)
    nodes = Map(value -> n) ++ nodes
    n
  }

  def print() = {
    println("Nodes " + nodes.keys.toSet)
    println("Edges " + edges.map(_.toTuple).toSet)
  }
}

class Graph[T, U] extends GraphBase[T, U] {

  override def equals(o: Any) = o match {
    case g: Graph[T,U] => super.equals(g)
    case _ => false
  }

  def edgeTarget(e: Edge, n: Node): Option[Node] =
    if (e.n1 == n) Some(e.n2)
    else if (e.n2 == n) Some(e.n1)
    else None

  def addEdge(n1: T, n2: T, value: U) = {
    val e = new Edge(nodes(n1), nodes(n2), value)
    edges = e :: edges
    nodes(n1).adj = e :: nodes(n1).adj
    nodes(n2).adj = e :: nodes(n2).adj
  }
}

class Digraph[T, U] extends GraphBase[T, U] {
  override def equals(o: Any) = o match {
    case g: Digraph[T,U] => super.equals(g)
    case _ => false
  }

  def edgeTarget(e: Edge, n: Node): Option[Node] =
    if (e.n1 == n) Some(e.n2)
    else None

  def addArc(source: T, dest: T, value: U) = {
    val e = new Edge(nodes(source), nodes(dest), value)
    edges = e :: edges
    nodes(source).adj = e :: nodes(source).adj
  }
}
