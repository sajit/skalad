package data.structures.trees

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by skunnumkal on 7/23/14.
 */
class TreeUtilTest extends FlatSpec with Matchers{

  it should "create a tree" in {

    val root = Node('a',End,Node('b',End,End))

    //TreeUtils.inOrder(root)

  }

  it should "count number of nodes to 2 " in {
    val root = Node('a',End,Node('b',End,End))
    TreeUtils.count(root) should be (2)
  }

  def searchTree(node: Node[Char]): Unit = {
    node.left.height - node.right.height should be <= 1
    if(!node.left.eq(End)){
      searchTree(node.left.asInstanceOf[Node[Char]])
    }
    if(!node.right.eq(End)){
      searchTree(node.right.asInstanceOf[Node[Char]])
    }
  }

  it should "create a balanced tree" in {
    val nums = List('a','x','i','d','y','g')
    val root = TreeUtils.cBalanced(nums)
    TreeUtils.inOrder(root)
    TreeUtils.count(root) should be (nums.length)
    searchTree(root);
  }

  it should "create a balanced tree in terms of count" in {
    val nums = List('a','x','i','d','y','g')
    val root = TreeUtils.balanced(nums)
    val diff = Math.abs(TreeUtils.count(root.left)-TreeUtils.count(root.right))
    diff should be <= 1
  }

  it should "be a mirror image" in {
    val tree = Node('x',Node('a',End,Node('t',End,End)),Node('b',Node('d',End,End),End))
    TreeUtils.isMirrofOf(tree.left,tree.right) should be (true)
  }

  it should "wont be a mirror image" in {
    val tree = Node('x',Node('a',End,Node('t',End,End)),Node('b',Node('d',End,End),Node('b',End,End)))
    TreeUtils.isMirrofOf(tree.left,tree.right) should be (false)
  }

  it should "build up a BST" in {
    val nums = List(10,15,5,7)
    val root = TreeUtils.buildBST(nums)
    root.value should be (10)
    root.left.get.value should be (5)
    root.left.get.right.get.value should be (7)


  }

  it should "count leaves" in {
    val tree = Node('a',Node('b',End,Node('c',End,End)),Node('d',Node('e',End,End),Node('f',End,End)))
    TreeUtils.leafCount(tree) should be (3)
  }

  it should "collect leaves" in {
    val cNode = Node('c',End,End)
    val eNode = Node('e',End,End)
    val fNode = Node('f',End,End)
    val tree = Node('a',Node('b',End,cNode),Node('d',eNode,fNode))
    val result = TreeUtils.leafCollect(tree)
    result.length should be (3)
    val leafNames = result.map{ x => x.value}
    leafNames should be (List(cNode.value,eNode.value,fNode.value))
  }

  it should "collect internal nodes" in {

    val (dNode: Node[Char], bNode: Node[Char], tree: Node[Char]) = createTree

    val result = TreeUtils.internalNodeCollection(tree)
    result.length should be (3)
    val internalNodeNames = result.map{ x => x.value}
    internalNodeNames should be (List(tree.value,bNode.value,dNode.value))
  }

  it should "collect internal nodes at level 2" in {

    val (dNode: Node[Char], bNode: Node[Char], tree: Node[Char]) = createTree
    val result = TreeUtils.atLevel(2,tree)
    result.length should be (2)
    val internalNodeNames = result.map{ x => x.value}
    internalNodeNames should be (List(bNode.value,dNode.value))
  }

  def createTree: (Node[Char], Node[Char], Node[Char]) = {
    val cNode = Node('c', End, End)
    val eNode = Node('e', End, End)
    val fNode = Node('f', End, End)
    val dNode = Node('d', eNode, fNode)
    val bNode = Node('b', End, cNode)
    val tree = Node('a', bNode, dNode)
    (dNode, bNode, tree)
  }

  it should "do BFS traversal " in {
    val (dNode: Node[Char], bNode: Node[Char], tree: Node[Char]) = createTree
    TreeUtils.bfs(tree) should be (List('a','b','d','c','e','f'))
  }

  it should "do BFS traversal v2 " in {
    val (dNode: Node[Char], bNode: Node[Char], tree: Node[Char]) = createTree
    TreeUtils.bfs_v2(tree) should be (List('a','b','d','c','e','f'))
  }

  it should "edit children" in {
    val aNode = Node('a',End,End)
    aNode.left = Node('b',End,End)

    aNode.height should be (2)
    aNode.right should be (End)
    aNode.left match {
      case xNode:Node[Char] => xNode.value should be ('b')
      case _ => assert(false)
    }
  }

  it should "find a Node" in {
    val (aNode,bNode,rootNode) = createTree
    TreeUtils.findNode(rootNode,'a') should be (Some(rootNode))
    TreeUtils.findNode(rootNode,'z') should be (None)
  }

  it should "construct a tree from a list" in {
    val ll = List('a','b','c','d','e','f')
    val root = TreeUtils.constructCompleteTree(ll)
    ll.foreach{ el => TreeUtils.findNode(root,el) should not be (None) }
    root.height should be (3)
    TreeUtils.count(root) should be (ll.length)
  }

  it should "output the order list" in {
    val (aNode,bNode,rootNode) = createTree
    val result = TreeUtils.inOrder(rootNode)
    result should be (List('b','c','a','e','d','f'))
  }

//  it should "convert to positional nodes " in {
//    val (x,y,root) = createTree
//    val positionalTree = TreeUtils.convert2Positional(root)
//    positionalTree.value should be (root.value)
//  }
}
