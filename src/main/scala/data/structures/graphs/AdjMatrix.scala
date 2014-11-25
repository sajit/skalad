package data.structures.graphs

import scala.Array

/**
 * Created by sajit on 11/17/14.
 */
class AdjMatrix(val matrix:Array[Array[Int]]) {

   private var visited:Array[Boolean] = Array.fill[Boolean](matrix.length)(false)

   private def doDfs(current:Int):Unit = {
     println("Current Node Idx" + current)
     visited(current) = true
     for ( i <- 0 to (matrix(current).length - 1) ) {
        if(matrix(current)(i) != -1 && !visited(i)){
          doDfs(i)
        }
     }
   }

  def getVisitedCount():Int = {
    visited.foldRight(0)((el,sum) => if(el){ sum + 1} else {sum})

  }

  def resetVisited() = {
    //reset visited array
    visited = Array.fill[Boolean](matrix.length)(false)
  }
  def dfs(start:Int):Unit = {
    doDfs(start)

  }

  def hasPath(current:Int,target:Int):Boolean = {
    visited(current) = true
    if(current==target){
      true
    }
    else{
      var result = false
      for ( i <- 0 to (matrix(current).length - 1) ) {
        if(matrix(current)(i) != -1 && !visited(i)){
          result = hasPath(i,target)
        }
      }
      result
    }


  }



}
