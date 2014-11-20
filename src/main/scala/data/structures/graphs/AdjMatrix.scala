package data.structures.graphs

import scala.Array

/**
 * Created by sajit on 11/17/14.
 */
class AdjMatrix(val matrix:Array[Array[Int]]) {

   private var visited:Array[Boolean] = Array.fill[Boolean](matrix.length)(false)

   private val hdmd = new AdjacencyMatrix()

   private def doDfs(current:Int):Unit = {
     println("Current Node Idx" + current)
     visited(current) = true
     for ( i <- 0 to (matrix(current).length - 1) ) {
        if(matrix(current)(i) != -1 && !visited(i)){
          doDfs(i)
        }
     }
   }

  def dfs(start:Int):Unit = {
    doDfs(start)
    //reset visited array
    visited = Array.fill[Boolean](matrix.length)(false)
  }



}
