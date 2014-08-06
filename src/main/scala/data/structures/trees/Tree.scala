package data.structures.trees

/**
 * Created by skunnumkal on 7/23/14.
 *
 * http://aperiodic.net/phil/scala/s-99/tree1.scala
 */


abstract class Tree[+T]{
  def height:Int

}

case class Node[T](value:T,var left:Tree[T],var right:Tree[T]) extends Tree[T]{
  override def toString = "{"+value+",l:" + left.toString + ",r:" + right.toString + " }"
  override def height:Int = {
    Math.max(left.height,right.height) + 1
  }



}

case object End extends Tree[Nothing] {
  override def toString = "."
  override def height:Int = 0

}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

case class TreeNode[T](value:T,var left : Option[TreeNode[T]],var right:Option[TreeNode[T]]) {

  def this(t:T) = this(t,None,None)



}
object TreeNode{

  def apply[T](t:T) = new TreeNode(t)
}
