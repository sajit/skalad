package data.structures.graphs

import org.scalatest.{Matchers, FlatSpec}



/**
 * Created by sajit on 11/17/14.
 */
class AdjMatrisSpec extends FlatSpec with Matchers{


  val graph = Array(Array(-1,-1,2,-1,-1),Array(-1,-1,-1,-1,3),Array(2,-1,-1,-1),Array(-1,-1,-1,1,-1),Array(-1,3,-1,-1,-1))

  it should "dfs on a graph" in {
        val adjMatrix = AdjMatrix(graph)
        adjMatrix.dfs(0)
    }

}
