package data.structures.trees
import scala.collection.mutable.MutableList


/**
 * Created by sajit on 9/25/14.
 */
object MTreeUtils {

  def buildTree(str:String):MTree[Char] = {
      def foo(aStr:String,current:MTree[Char]):(String,MTree[Char]) = {
        if(aStr.isEmpty){
          (aStr,current)
        }
        if(aStr.head == '^'){
          (aStr.tail,current)
        }
        else{
          foo(aStr.tail,MTree(aStr.head))
        }
      }
      var rem = str
      var children = MutableList[MTree[Char]]()
      while(!rem.isEmpty){
        val (rx,child) = foo(rem.tail,MTree(rem.head))
        rem = rx
        children += child
      }
      MTree(rem.head,children.toList)



  }

  def splitWhenZeroed(s: String): List[Int] = ???

  def partitionToSubStrings(str:String):List[String] = {
    val idx:List[Int] = splitWhenZeroed(str)
    processIndices(str, idx)
  }

  def processIndices(str: String, idx: List[Int]): List[String] = {
    val endIdx = idx.map { el => str.length - el}
    val tuples: List[(Int, Int)] = endIdx.sliding(2).map { aList => (aList(0)+1, aList(1))}.toList
    val allTuples: List[(Int, Int)] = ((0, endIdx(0)) :: tuples)
    allTuples.map { tuple => str.substring(tuple._1, tuple._2+1)}
  }
}
