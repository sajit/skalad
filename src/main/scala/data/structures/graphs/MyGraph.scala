package data.structures.graphs

/**
 * Created by skunnumkal on 10/8/14.
 */

case class GraphNode[T](value: T){
  var adj: List[GraphEdge[T]] = Nil
  def addEdge(edge:GraphEdge[T]) = edge :: adj
}

  //def neighbors: List[Node] = adj.map(edgeTarget(_, this).get)

case class GraphEdge[T](n1:T,n2:T,weight:Int)
class UndirectedGraph [T]{
  var nodeMap:Set[GraphNode[T]] = Set.empty
  def addNode(node:GraphNode[T]) = nodeMap + node
  def addNodes(nodes:Set[GraphNode[T]]) = nodeMap ++ nodes

  def addEdge(n1:T,n2:T,weight:Int) = {
    //if(nodeMap.contains(Graph))
    val e1 = GraphEdge(n1,n2,weight)
    val e2 = GraphEdge(n2,n1,weight)

  }
}
