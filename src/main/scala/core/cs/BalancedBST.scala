package core.cs

/**
 * Created by skunnumkal on 10/24/14.
 */
case class Node(value:Int,left:Option[Node],right:Option[Node])
object BalancedBST {

  def convert(in:List[Int]):Option[Node] = {
    if(in.isEmpty){
      None
    }else{
      val mid = in.length/2
      Some(Node(in(mid),convert(in.dropRight(in.length-mid)),convert(in.drop(mid+1))))
    }
  }

  def print(node:Node):Unit = {
    println(node)
    node.left match {
      case Some(leftChild) => print(leftChild)
      case None => {}
    }
    node.right match {
      case Some(rightChild) => print(rightChild)
      case None => {}
    }
  }
}
