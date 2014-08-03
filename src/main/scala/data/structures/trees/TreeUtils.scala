package data.structures.trees

import scala.util.Random

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

  def insert(node: Tree[Char], value: Char): Tree[Char] = {
    if(node.eq(End)){
      Node(value,End,End)
    }
    else{
      val internalNode = node.asInstanceOf[Node[Char]]
      if(internalNode.left.height == internalNode.right.height){

          if(Random.nextBoolean()){ //choose left
            internalNode.left = insert(internalNode.left,value)
          }else{
            internalNode.right = insert(internalNode.right,value)
          }

      }
      else if(internalNode.left.height > internalNode.right.height){ //insert into right
          internalNode.right = insert(internalNode.right,value)
      }
      else{ //insert into right
          internalNode.left = insert(internalNode.left,value)
      }
      internalNode
    }

  }

  def cBalanced(nums:List[Char]):Node[Char] = {
         val root = Node(nums.head,End,End)
      nums.tail.foreach{
        el => insert(root,el)
      }
    root
  }

  def balancedInsert(node:Tree[Char],value:Char):Tree[Char]= {
    if(node.eq(End)){
      Node(value,End,End)
    }
    else{
      val internalNode = node.asInstanceOf[Node[Char]]
      val leftCount = count(internalNode.left)
      val rightCount = count(internalNode.right)
      if(leftCount==rightCount){
        if(Random.nextBoolean()){ //choose left
          internalNode.left = balancedInsert(internalNode.left,value)
        }else{
          internalNode.right = balancedInsert(internalNode.right,value)
        }
      }
      else if(leftCount>rightCount){
        internalNode.right = balancedInsert(internalNode.right,value)
      }
      else{
        internalNode.left = balancedInsert(internalNode.left,value)
      }
      internalNode
    }
  }
  /**
   * Number of |nodes in left subtree - nodes in right subtree| <= 1
   * @param nums
   * @return
   */
  def balanced(nums:List[Char]):Node[Char] = {
    val root = Node(nums.head,End,End)
    val xy:Tree[Char] = balancedInsert(root,root.value)
    nums.tail.foreach{
      el => balancedInsert(root,el)
    }
    root
  }

}
