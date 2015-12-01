package funcparams

/**
 * Created by sajit on 9/19/14.
 */
object ManyWaysDoingSameThing {

  def generic(foo:(Int => Int),aList:List[Int]):List[Int] = {

    aList.map(foo)
  }

  def generic2(foo:((Int,Int) => Int),base:Int,pow:Int):Int = foo(base,pow)

}
