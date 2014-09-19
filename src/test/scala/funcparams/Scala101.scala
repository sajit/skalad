package funcparams

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by sajit on 9/19/14.
 */
class Scala101 extends FlatSpec with Matchers {

  def identity(x:Int) = x
  def squares(x:Int) = x*x
  def cubes(x:Int,n:Int) = x*x*x
  def pow(x:Int,y:Int):Int = Math.pow(x,y).toInt
  it should "work as expected" in {
        val in = List(5,6,4,2)
        val out = ManyWaysDoingSameThing.generic(identity,in)
        out should be (in)
        val out2 = ManyWaysDoingSameThing.generic(squares,in)
        out2 should be (List(25,36,16,4))

  }
  it should "take multiple params" in {

    val out = ManyWaysDoingSameThing.generic2(pow,3,6)
    out should be (pow(3,6))

  }

}
