package data.structures.graphs

import org.scalatest.{Matchers, FlatSpec}




/**
 * Created by sajit on 11/17/14.
 */
class AdjMatrixSpec extends FlatSpec with Matchers{


  val graph = Array(Array(-1,-1,2,-1,-1),Array(-1,-1,-1,-1,3),Array(2,-1,-1,-1,-1),Array(-1,-1,-1,1,-1),Array(-1,3,-1,-1,-1))
  val matrix2 = new AdjMatrix(graph)

  val graph1 = Array(Array(-1,1,2,-1),Array(1,-1,3,-1),Array(2,3,-1,-1),Array(-1,-1,-1,-1))

  it should "init visited" in {
    matrix2.getVisitedCount() should be (0)

  }

  it should "dfs on a graph and print 2 nodes" in {

        matrix2.dfs(0)
        matrix2.getVisitedCount() should be (2)
        matrix2.resetVisited()

    }

  it should "dfs on a graph and print 1 nodes" in {
    //val adjMatrix = AdjMatrix(graph)
    matrix2.dfs(3)
    matrix2.getVisitedCount() should be (1)
    matrix2.resetVisited()
  }

  it should "identify a path" in {
    matrix2.hasPath(0,2) should be (true)
    matrix2.hasPath(0,1) should be (false)
  }

  it should "identify cycles" in {
    val matrix = new AdjMatrix(graph1)
    val result = matrix.countCycles(0)
    //println("Result " + result)
    result.length should be (1)
    matrix.countCycles(3) should be (List[String]())
  }

  it should "identify ze cycles" in {
    val bigGraph = Array(
      Array(-1,1,-1,1,1,-1),
      Array(1,-1,1,-1,-1,-1),
      Array(-1,1,-1,1,-1,1),
      Array(1,-1,1,-1,1,1),
      Array(1,-1,-1,1,-1,-1),
      Array(-1,-1,1,1,-1,-1))
    val matrix = new AdjMatrix(bigGraph)
    val result = matrix.countCycles(0)
    //println("Result " + result)
    result.length should be (5)
  }



}
