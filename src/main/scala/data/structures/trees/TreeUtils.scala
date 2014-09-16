package data.structures.trees

import java.util

import scala.collection.mutable
import scala.collection.mutable.Queue
import scala.collection.mutable.MutableList
import scala.util.Random

/**
 * Created by skunnumkal on 7/23/14.
 */
object TreeUtils {


  def inOrder[T](node:Tree[T]):List[T] = {
    def doInOrder(aNode:Tree[T],soFar:List[T]):List[T] = {
      aNode match {
        case someNode:Node[T] => {
          val leftResult = doInOrder(someNode.left,soFar)
          val updated = someNode.value :: leftResult
          doInOrder(someNode.right,updated)
        }
        case End => soFar
      }
    }
    doInOrder(node,List()).reverse
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

  /**
   * This method tests whether two nodes are symmetric
   * Rule 1 : Both node1 and node2 need to be Node class and not End Objects
   * if either of them are of differnt types return false
   * Check isMirrorOf on the left child of node1 and right child of node2
   * Check isMirrofOf on the right child of node1 and left child of node1
   * @param node1
   * @param node2
   * @tparam T
   * @return
   */
  def isMirrofOf[T](node1:Tree[T],node2:Tree[T]):Boolean = {
    if(node1.isInstanceOf[Node[T]]){
      if(node2.isInstanceOf[Node[T]]){
          val iNode1 = node1.asInstanceOf[Node[T]]
          val iNode2 = node2.asInstanceOf[Node[T]]
          isMirrofOf(iNode1.left,iNode2.right) && isMirrofOf(iNode1.right,iNode2.left)
      }
      else{
        false
      }
    }
    else{
      !node2.isInstanceOf[Node[T]]
    }

  }

  def bst(x:Int,node:Option[TreeNode[Int]]):TreeNode[Int] = {
    node match {
      case None => TreeNode(x,None,None)
      case Some(node) => {
        if(node.value<x){
          node.right = Some(bst(x,node.right))
        }
        else if(node.value > x){
          node.left = Some(bst(x,node.left))
        }
        node
      }


    }

  }
  def buildBST(nums:List[Int]):TreeNode[Int] = {
    val root = TreeNode(nums.head,None,None)
    nums.tail.foreach{
      i => bst(i,Some(root))
    }
    root
  }

  def leafCount[T](node:Tree[T]):Int = {
    node match {
      case Node(_,End,End) => 1
      case End => 0
      case node:Node[T] => leafCount(node.left) + leafCount(node.right)
    }
  }

  def leafCollect[T](node:Tree[T]):List[Node[T]] = {
     def doCollectLeaf(aNode:Tree[T],soFar:List[Node[T]]):List[Node[T]] = {
       aNode match {
         case Node(x,End,End) => Node(x,End,End) :: soFar
         case End => soFar
         case node:Node[T] => (doCollectLeaf(node.left,soFar) ++ doCollectLeaf(node.right,soFar))
       }
     }
    doCollectLeaf(node,List[Node[T]]())
  }

  def internalNodeCollection[T](node:Tree[T]):List[Node[T]] = {
    def collectInternalNodes(aNode:Tree[T],soFar:List[Node[T]]):List[Node[T]] = {
      aNode match {
        case Node(x,End,End) => soFar
        case End => soFar
        case node:Node[T] => node :: (collectInternalNodes(node.left,soFar) ++ collectInternalNodes(node.right,soFar))
      }
    }
    collectInternalNodes(node,List[Node[T]]())
  }

  def atLevel[T](level:Int,node:Tree[T]):List[Node[T]] = {
    def traverseAndCollect(aNode:Tree[T],currentLevel:Int,soFar:List[Node[T]]):List[Node[T]] = {
      if(currentLevel<level){
         aNode match {
           case someNode:Node[T] => traverseAndCollect(someNode.left,currentLevel+1,soFar) ++ traverseAndCollect(someNode.right,currentLevel+1,soFar)
           case End => soFar
         }
      }
      else if(currentLevel == level){
        aNode match {
          case someNode:Node[T] => someNode :: soFar
          case End => soFar
        }
      }else {
        soFar
      }


    }
    traverseAndCollect(node,1,List[Node[T]]())
  }

  def findNode(node: Node[Char], c: Char):Option[Node[Char]] = {
    def checkChild(child:Tree[Char]): Option[Node[Char]] = {
      child match {
        case aNode: Node[Char] => findNode(aNode, c)
        case End => None
      }
    }
    if(node.value == c){
      Some(node)
    }else{
      checkChild(node.left) match {
        case Some(matchingNode) => Some(matchingNode)
        case None => checkChild(node.right)
      }
    }
  }

  def constructCompleteTree(initList:List[Char]):Node[Char] = {
    val ll = '1' :: initList
    val root:Node[Char] = Node(initList.head,End,End)
    for( i <- 1 until ll.length){
      val el = ll(i)
      val leftChildIdx = 2 * i
      val rightChildIdx = 2 * i + 1
      val leftChild = if(leftChildIdx<ll.length){
        Node(ll(leftChildIdx),End,End)
      }else {End}
      val rightChild = if(rightChildIdx<ll.length) { Node(ll(rightChildIdx),End,End)} else End
      findNode(root,el) match {
        case Some(foundNode) => {
             foundNode.left = leftChild
             foundNode.right = rightChild
        }
        case None => {}
      }


    }
    root
  }

  def bfs[T](node:Node[T]):List[T] = {
    val queue = new Queue[Node[T]]
    var result = MutableList[T]()
    queue += node

    while(!queue.isEmpty){
      val currentNode = queue.dequeue()
      result += currentNode.value
      if(currentNode.left.isInstanceOf[Node[T]]) {
        queue += currentNode.left.asInstanceOf[Node[T]]
      }
      if(currentNode.right.isInstanceOf[Node[T]]) {
        queue += currentNode.right.asInstanceOf[Node[T]]
      }
    }
    result.toList
  }
  //http://codereview.stackexchange.com/questions/29699/bfs-and-dfs-in-scala
  def bfs_v2[T](node:Node[T]):List[T] = {
    def enQueueNext(queue: Queue[Node[T]], aNode: Tree[T]) {
      aNode match {
        case internalNode: Node[T] => queue += internalNode
        case End => {}
      }
    }
    def bfs_visit(queue:Queue[Node[T]],visited:List[T]):List[T] = {
      if(queue.isEmpty){
        visited
      }
      else{
        val currentNode = queue.dequeue()
        enQueueNext(queue, currentNode.left)
        enQueueNext(queue,currentNode.right)
        bfs_visit(queue,currentNode.value :: visited )
      }
    }
    val aQueue = new mutable.Queue[Node[T]]()

    bfs_visit(aQueue += node,List[T]()).reverse
  }

  def getPosition[T](xNode:Node[T],treeRoot:Node[T]):(Int,Int) = {
     val result = TreeUtils.inOrder(treeRoot)
     val idx:Int = result.indexOf(xNode.value)
    (idx,xNode.height)
  }

  def convert2Positional(rootNode:Node[Char]):PositionedNode[Char] = {
    def doConvert(jNode:Tree[Char]):Tree[Char] = {
      jNode match {
        case someNode:Node[Char] => {
          val (x,y) = getPosition(someNode,rootNode)
          PositionedNode(someNode.value,doConvert(someNode.left),doConvert(someNode.right),x,y)
        }
        case End => {End}
      }
    }
    val (rootX,rootY) = getPosition(rootNode,rootNode)
    PositionedNode(rootNode.value,doConvert(rootNode.left),doConvert(rootNode.right),rootX,rootY)

  }



}
