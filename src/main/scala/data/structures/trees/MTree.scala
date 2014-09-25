package data.structures.trees

/**
 * Created by sajit on 9/25/14.


Multiway Trees

A multiway tree is composed of a root element and a (possibly empty) set of successors which are multiway trees
themselves. A multiway tree is never empty. The set of successor trees is sometimes called a forest.

The code to represent these is somewhat simpler than the code for binary trees,
partly because we don't separate classes for nodes and terminators, and
partly because we don't need the restriction that the value type be ordered.
*/
case class MTree[+T](value: T, children: List[MTree[T]]) {
  def this(value: T) = this(value, List())
  override def toString = "M(" + value.toString + " {" + children.map(_.toString).mkString(",") + "})"
}

object MTree {
  def apply[T](value: T) = new MTree(value, List())
  //def apply[T](value: T, children: List[MTree[T]]) = new MTree(value, children)
}