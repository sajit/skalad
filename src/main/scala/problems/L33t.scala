package problems

/**
 * Created by skunnumkal on 10/12/14.
 */
object L33t {

  def mergeIntervals(in:List[(Int,Int)]):List[(Int,Int)] = {
    val sorted:List[(Int,Int)] = in.sortWith((tuple1,tuple2) => tuple1._1 < tuple2._1)
    var cur = sorted(0)
    var result = List[(Int,Int)]()
    for( a <- 1 to sorted.length-1){
      val n = sorted(a)
      if(overlaps(cur,n)){
        val merged = merge(cur,n)
        result = result.+:(merged)
        cur = merged
      } else{
        if(n._2 > cur._2){
          cur = n
        }
      }

    }
    result
  }

  def overlaps(interval1:(Int,Int),interval2:(Int,Int)):Boolean = {
    !(interval1._2 <= interval2._1 || interval2._2 <= interval1._1)

  }

  def merge(interval1:(Int,Int),interval2:(Int,Int)):(Int,Int) = {
    if(!overlaps(interval1,interval2))
      throw new IllegalArgumentException
    val sorted:List[(Int,Int)] = List(interval1,interval2).sortWith((tuple1,tuple2) => tuple1._1 < tuple2._1)
    (sorted(0)._1,sorted(1)._2)
  }

}
