package data.structures.graphs

/**
 * Created by skunnumkal on 10/8/14.
 */

case class GraphNode[T](value: T)
//{
//  var adj: List[GraphEdge[T]] = Nil
//  def addEdge(edge:GraphEdge[T]) = edge :: adj
//}

  //def neighbors: List[Node] = adj.map(edgeTarget(_, this).get)

case class GraphEdge[T](n1:T,n2:T,weight:Int)
class UndirectedGraph[T] extends MyGraph[T]{

  override def addEdge(n1:T,n2:T,weight:Int) = {
    addEdgeToNode(GraphNode(n1), GraphEdge(n1, n2, weight))
    addEdgeToNode(GraphNode(n2), GraphEdge(n2, n1, weight))
  }



}

class DirectedGraph[T] extends MyGraph[T] {
  override def addEdge(n1: T, n2: T, weight: Int): Unit = {
    val node1 = GraphNode(n1)
    val node2 = GraphNode(n2)
    if(!nodeMap.contains(node2) || !nodeMap.contains(node1)){
      throw new IllegalArgumentException("Node not found")
    }
    val e1 = GraphEdge(n1,n2,weight)
    addEdgeToNode(node1,e1)
  }
}
abstract class MyGraph[T] {
  var nodeMap:Map[GraphNode[T],List[GraphEdge[T]]] = Map()
  def addNode(node:GraphNode[T]) = nodeMap += node -> List()
  def addNodes(nodes:List[T]) = {
    val graphNodes:List[GraphNode[T]] = nodes.map{aNode => GraphNode(aNode)}
    val tuples = graphNodes.map{aNode => aNode -> List()}
    nodeMap ++= tuples
  }

  def addEdge(n1:T,n2:T,weight:Int)

  def addEdgeToNode(node:GraphNode[T],edge:GraphEdge[T]) = {
    nodeMap.get(node) match {
      case Some(edges) => {
        val updated:List[GraphEdge[T]] = edge :: edges
        nodeMap += node -> updated
      }
      case None => throw  new IllegalArgumentException("Not found node " + node)
    }
  }

  // If the edge E connects N to another node, returns the other node,
  // otherwise returns None.
  def edgeTarget(e: GraphEdge[T], n: GraphNode[T]): Option[GraphNode[T]] = {
    nodeMap.get(n) match {
      case Some(edges) => {

        edges.contains(e) match {
          case true => Some(GraphNode(e.n2))
          case false => None
        }
      }
      case _ => None
    }
  }

  def toTerm():(List[T],List[GraphEdge[T]]) = {
    val allEdges:List[GraphEdge[T]] = nodeMap.foldRight(List[GraphEdge[T]]())((el,x) => x ++ el._2)
    (nodeMap.keySet.toList.map{x => x.value},allEdges)
  }

  def nodeCount():Int = nodeMap.keySet.size

}
class TraversalGraphNode[T](value:T,var visited:Boolean) extends GraphNode[T](value:T)
