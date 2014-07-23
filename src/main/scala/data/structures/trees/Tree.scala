package data.structures.trees

/**
 * Created by skunnumkal on 7/23/14.
 *
 * http://aperiodic.net/phil/scala/s-99/tree1.scala
 */


abstract class Tree[+T]

case class Node[T](value:T,left:Tree[T],right:Tree[T]) extends Tree[T]{
  override def toString = "{"+value+",l:" + left.toString + ",r:" + right.toString + " }"
}

case object End extends Tree[Nothing] {
  override def toString = "."
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}