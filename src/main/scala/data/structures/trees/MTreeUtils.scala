package data.structures.trees



/**
 * Created by sajit on 9/25/14.
 */
object MTreeUtils {

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
   * Helper method that returns a list of strings given the original string
   * and list of indices to split it
   * @param str
   * @param idx
   * @return
   */
  def processIndices(str: String, idx: List[Int]): List[String] = {
    val endIdx = idx.map { el => str.length - el}
    val tuples: List[(Int, Int)] = if(endIdx.length > 1){
      endIdx.sliding(2).map { aList => (aList(0)+1, aList(1))}.toList
    }else{
      Nil
    }
    val allTuples: List[(Int, Int)] = ((0, endIdx(0)) :: tuples)

    allTuples.map { tuple => str.substring(tuple._1, tuple._2+1)}
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

  def buildTree(str:String):MTree[Char] = {
    if(str.length == 2 && str.charAt(1) == '^'){
        MTree(str.charAt(0))
    }
    else{
      val subTrees:List[String] = partitionToSubStrings(str.substring(1,str.length-1))
      val children:List[MTree[Char]] = subTrees.map{aSubtreePattern => buildTree(aSubtreePattern)}
      MTree(str.charAt(0),children)
    }

  }

  def dfs[T](node:MTree[T]):Unit = {
    //println(node.value)
    node.children.foreach(dfs)
  }
  def dfsAndCount[T](node:MTree[T],current:Int):Int = ???

  def nodeHeight[T](node:MTree[T],height:Int,soFar:List[Int]):List[Int] = {
    val newList = soFar.updated(height,soFar(height)+1)
    node.children.foldRight(newList)((child,currentList) => nodeHeight(child,height+1,currentList))

  }

  def postOrder[T](node:MTree[T]):List[T] = {

      val list = for{
        child <- node.children
      }yield(postOrder(child))
    //val rls = list.map{ l => l.reverse}
    val flattened = list.flatten :+ node.value
    flattened

  }
  def lispy[T](node:MTree[T]):String = {
    def buildReverseLispLikeTree(cur:MTree[T]):String = {


      val childLists:List[String] = for{
        child <- cur.children
      }yield(buildReverseLispLikeTree(child))
      val concatStr = childLists.foldLeft(cur.value.toString)((childList,currentStr) => {
        //println("Current iteration " + childList)
        currentStr + childList})
      val result = if(!cur.children.isEmpty){
        ")"+concatStr+"(" //why this looks weird is because finally we reverse this string and hence paranthesis need to be in other order
      } else{
        concatStr
      }
      result
    }
    val fullTree = buildReverseLispLikeTree(node).reverse
    println(fullTree)
    fullTree
  }
}
