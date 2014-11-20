package data.structures.graphs

import org.scalatest.{Matchers, FlatSpec}




/**
 * Created by sajit on 11/17/14.
 */
class AdjMatrixSpec extends FlatSpec with Matchers{


  val graph = Array(Array(-1,-1,2,-1,-1),Array(-1,-1,-1,-1,3),Array(2,-1,-1,-1,-1),Array(-1,-1,-1,1,-1),Array(-1,3,-1,-1,-1))
  val matrix = new AdjacencyMatrix()
  val matrix2 = new AdjMatrix(graph)

  it should "dfs on a graph and print 2 nodes" in {
        //val adjMatrix = AdjMatrix(graph)
        matrix2.dfs(0)
    }

  it should "dfs on a graph and print 1 nodes" in {
    //val adjMatrix = AdjMatrix(graph)
    matrix2.dfs(3)
  }

}
