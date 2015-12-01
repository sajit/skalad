package data.structures.trees

/**
 * Created by sajit on 8/6/14.
 * http://codereview.stackexchange.com/questions/28773/immutable-binary-search-tree-using-scala
 */
sealed abstract class BSTNode[T]
case object Leaf extends BSTNode[Nothing]
//case class InnerNode[T] extends BSTNode[T]
object BST {
  def empty[T](implicit c:(T,T) => Int) : BST[T] = new EmptyBST(c)
}

sealed abstract class BST[T] {
  // abstract: whatever methods you want to support
  def add(t:T):BST[T]
}

case class EmptyBST[T](c:(T,T) => Int) extends BST[T] {
  // trivial implementation of all methods for an empty BST
  // abstract: whatever methods you want to support
  override def add(t: T): BST[T] = ???
}

case class NonEmptyBST[T](left:BST[T], right:BST[T], value:T, c:(T,T) => Int) extends BST[T] {
  // non-trivial implementation of all methods for the non-empty case
  override  def add(t:T):BST[T] = ???
}