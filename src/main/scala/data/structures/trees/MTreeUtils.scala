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

  /**
   * Should return indices of all partitions for a string
   * @param s
   * @return
   */
  def splitWhenZeroed(s: String): List[Int] = {
    def doSplit(rem:String,soFar:List[Int],sum:Int):List[Int] = {
      if(rem.isEmpty){
        soFar

      }
      else{
        val head = rem.head
        val diff = if(head == '^'){ -1} else { 1}
        val newList = if(sum+diff == 0){rem.length :: soFar} else {soFar}
        doSplit(rem.tail,newList,sum+diff)
      }
    }
    doSplit(s,List(),0).reverse
  }

  /**
   * Given a string partition it into substrings that represent subtrees
   * @param str
   * @return
   */
  def partitionToSubStrings(str:String):List[String] = {
    val idx:List[Int] = splitWhenZeroed(str)
    processIndices(str, idx)
  }

  /**
   * Helper method that returns a list of strings given the original string
   * and list of indices to split it
   * @param str
   * @param idx
   * @return
   */
  def processIndices(str: String, idx: List[Int]): List[String] = {
    val endIdx = idx.map { el => str.length - el}
    println("End Idxes" + endIdx)
    val tuples: List[(Int, Int)] = if(endIdx.length > 1){
      endIdx.sliding(2).map { aList => (aList(0)+1, aList(1))}.toList
    }else{
      Nil
    }
    println(tuples)
    val allTuples: List[(Int, Int)] = ((0, endIdx(0)) :: tuples)

    allTuples.map { tuple => str.substring(tuple._1, tuple._2+1)}
  }
}
