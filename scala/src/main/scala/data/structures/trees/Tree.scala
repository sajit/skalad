package data.structures.trees

/**
 * Created by skunnumkal on 7/23/14.
 *
 * http://aperiodic.net/phil/scala/s-99/tree1.scala
 */


abstract class Tree[+T]{
  def height:Int
  def stringRep:String
  def dotString:String

}

case class Node[T](value:T,var left:Tree[T],var right:Tree[T]) extends Tree[T]{
  override def toString = "{"+value+",l:" + left.toString + ",r:" + right.toString + " }"
  override def height:Int = {
    Math.max(left.height,right.height) + 1
  }
  override def stringRep:String = {
    val rep = value.toString + "("+ left.stringRep+","+right.stringRep+")"
    val result:String = if(rep == value.toString + "(,)"){value.toString}else{rep}
    result
   }

  override def dotString:String = value.toString + left.dotString + right.dotString
}

case object End extends Tree[Nothing] {
  override def toString = "."
  override def height:Int = 0
  override def stringRep = ""
  override def dotString = End.toString
}

case class PositionedNode[+T](val value: T,val left: Tree[T], val right: Tree[T], x: Int, y: Int) extends Tree[T] {
  override def toString = "T[" + x.toString + "," + y.toString + "](" + value.toString + " " + left.toString + " " + right.toString + ")"
  override def height:Int = {Math.max(left.height,right.height) + 1}
  override def stringRep = "NOT_IMPLEMENTED"
  override  def dotString = stringRep
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
