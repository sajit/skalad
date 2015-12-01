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

  def countCycles(start:Int):List[Set[Int]] = {
    var cycles = List[Set[Int]]()
    def doCountCycles(current:Int,start:Int,currentCycle:Set[Int]):Unit= {
      visited(current) = true
      for(i <- 0 to (matrix(current).length -1)) {
        if(matrix(current)(i) != -1 && i==start && currentCycle.size>2){
          cycles = currentCycle :: cycles
        }
        if(matrix(current)(i) != -1 && !visited(i)){
          doCountCycles(i,start, currentCycle + i)
        }
      }
      visited(current) = false

    }
    doCountCycles(start,start,Set(start))
    cycles.distinct
  }



}
