package funcparams

/**
 * Created by sajit on 9/19/14.
 */
object ManyWaysDoingSameThing {

  def generic(foo:(Int => Int),aList:List[Int]):List[Int] = {

    aList.map(foo)
  }

}
