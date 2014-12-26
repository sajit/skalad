package misc

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by skunnumkal on 12/23/14.
 */
class KnightsTourSpec extends FlatSpec with Matchers{



  it should "get some tours" in {
    val knightsTour = new KnightsTour(5)
    knightsTour.getTotalCount() should be (0)
    knightsTour.knightsTour(0,0)
    val validSolns = knightsTour.getValidSolns()
    validSolns.isEmpty should be (false)
    val aSoln = validSolns(0)

  }

  it should "not complete any tour on a small board" in {
    val knightsTour = new KnightsTour(4)
    knightsTour.knightsTour(0,0)
    knightsTour.getTotalCount() should be (0)

  }

  it should "get only valid next Positions 1" in {
    val integerSnapshot = Array(Array(0,9,-1,5,2),Array(13,4,1,10,-1),Array(8,-1,12,3,6),Array(-1,14,7,-1,11),Array(-1,-1,-1,-1,-1))
    val booleanSnapshot:Array[Array[Boolean]] = integerSnapshot.map{row => row.map{ el => el >=0 }}

    val knightsTour = new KnightsTour(5)
    val nextSteps = knightsTour.getValidNexts(3,1,booleanSnapshot)
    nextSteps.length should be (1)
    nextSteps(0) should be ((4,3))


  }

  it should "get only valid next Positions 2" in {
    val integerSnapshot = Array(Array(0,9,-1,5,2),Array(13,4,1,10,-1),Array(8,-1,12,3,6),Array(-1,14,7,-1,11),Array(-1,-1,-1,-1,-1))
    val booleanSnapshot:Array[Array[Boolean]] = integerSnapshot.map{row => row.map{ el => el >=0 }}

    val knightsTour = new KnightsTour(5)
    val nextSteps = knightsTour.getValidNexts(0,2,booleanSnapshot)
    nextSteps.length should be (2)



  }

  it should "get only valid next Positions 3" in {
    val integerSnapshot = Array(Array(0,9,-1,5,2),Array(13,4,1,10,-1),Array(8,-1,12,3,6),Array(-1,14,7,-1,11),Array(-1,-1,-1,-1,-1))
    val booleanSnapshot:Array[Array[Boolean]] = integerSnapshot.map{row => row.map{ el => el >=0 }}

    val knightsTour = new KnightsTour(5)
    val nextSteps = knightsTour.getValidNexts(4,4,booleanSnapshot)
    nextSteps.isEmpty should be (true)



  }

}
