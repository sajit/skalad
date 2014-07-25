package logic

/**
 * Created by skunnumkal on 7/22/14.
 */
object LogicUtils {

  def grayCode(n:Int):List[String] = {
    def buildUp(times:Int,acc:List[String]):List[String] = {
      if(times<=0){
        acc
      }
      else{
        val zeroes = acc.map{aValue => "0" + aValue}
        val ones = acc.map{aValue => "1" + aValue}
        buildUp(times-1,zeroes ++ ones)
      }
    }
    val initList = List("0","1")
    buildUp(n-1,initList)
  }



  /**
   * We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples.
   * E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)).
   * Our objective is to construct a list of (S, C) Tuples, where C is the Huffman code word for the symbol S.

   */
  def huffman(tuples:List[(Char,Int)]):List[(Char,String)] = {
    var map:List[(Char,String)] = List()
    val sortedTuples = tuples.sortWith{(a,b) => a._2 < b._2}
    val small1 = sortedTuples(0)
    val small2 = sortedTuples(1)
    val internalNode = InternalNode(LeafNode(small2._1,small2._2),LeafNode(small1._1,small1._2))
    def buildTree(tupleList:List[(Char,Int)],node:InternalNode[Char]):InternalNode[Char] = {
      if(tupleList.isEmpty){
        node
      }
      else{
        val head = tupleList.head
        buildTree(tupleList.tail,InternalNode(LeafNode(head._1,head._2),node))
      }
    }
    def traverse(node: Tree[Char], prefix:String):Unit = {
      if(node.isInstanceOf[LeafNode[Char]]){
        val leaf = node.asInstanceOf[LeafNode[Char]]
        map = (leaf.element,prefix) :: map
      }
      else{
        val internal = node.asInstanceOf[InternalNode[Char]]
        traverse(internal.left,prefix+"0")
        traverse(internal.right,prefix+"1")
      }
    }

    val root = buildTree(sortedTuples.drop(2),internalNode)


    traverse(root,"")
    map

  }

  private abstract sealed class Tree[A] {
    val freq: Int
    def toCode: List[(A, String)] = toCodePrefixed("")
    def toCodePrefixed(prefix: String): List[(A, String)]
  }
  private final case class InternalNode[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
    val freq: Int = left.freq + right.freq
    def toCodePrefixed(prefix: String): List[(A, String)] =
      left.toCodePrefixed(prefix + "0") ::: right.toCodePrefixed(prefix + "1")
  }
  private final case class LeafNode[A](element: A, freq: Int) extends Tree[A] {
    def toCodePrefixed(prefix: String): List[(A, String)] = List((element, prefix))
  }



}
