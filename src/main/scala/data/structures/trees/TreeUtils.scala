package data.structures.trees

/**
 * Created by skunnumkal on 7/23/14.
 */
object TreeUtils {


  def inOrder[T](node:Tree[T]):Unit = {
    if(node.isInstanceOf[Node[T]]){
      inOrder(node.asInstanceOf[Node[T]].left)
    }
    println(node)
    if(node.isInstanceOf[Node[T]]){
      inOrder(node.asInstanceOf[Node[T]].right)
    }
  }

  def count[T](node:Tree[T]):Int = {
    if(node.eq(End)){
      0
    }
    else{
      1 + count(node.asInstanceOf[Node[T]].left) +
      count(node.asInstanceOf[Node[T]].right)
    }
  }

}
