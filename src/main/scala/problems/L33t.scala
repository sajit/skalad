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

  def removeOriginalAndDupes(x:List[Int]) = ???

  def isValidPalindrome(str:String):Boolean = {
    str.length match {
      case 0 =>  true
      case 1 =>  true
      case _ => str.charAt(0) == str.charAt(str.length-1) && isValidPalindrome(str.substring(1,str.length-1))
    }
  }



}
class SortedMatrix(matrix:Array[Array[Int]]){

  def doFind(searchVar: Int, x0: Int, y0: Int, x1: Int, y1: Int): Boolean = {
    //println("X0 => "+ x0 + "Y0 => " + y0 + " x1 =>" + x1 + " y1 => " + y1)

    if(x0 <= x1 && y0 <= y1){
      if(x0 == x1 && y0 == y1){
        searchVar == matrix(x0)(y1)
      }
      else{

        val (midX,midY):(Int,Int) = ((x0 + x1)/2,(y0+y1)/2)
        if(matrix(midX)(midY)==searchVar){
          true
        }
        else if(matrix(midX)(midY) < searchVar){
          doFind(searchVar,x0,y0,midX,midY) || doFind(searchVar,x0,midY+1,midX,y1) || doFind(searchVar,midX+1,y0,x1,midY)
        }
        else{
          doFind(searchVar,midX+1,midY+1,x1,y1) || doFind(searchVar,x0,midY+1,midX,y1) || doFind(searchVar,midX+1,y0,x1,midY)
        }
      }

    }else{
      false
    }
  }

  def find(target:Int):Boolean = {
    doFind(target,0,0,matrix.length-1,matrix(0).length-1)
  }

  /**
   * else if(value < mid){
            return doFind(value,matrix,top,left,xMid,yMid) || doFind(value,matrix,top,yMid+1,xMid,right) ||
                    doFind(value,matrix,xMid+1,left,bottom,yMid);
        }
        else{
            return doFind(value,matrix,xMid+1,yMid+1,bottom,right) || doFind(value,matrix,top,yMid+1,xMid,right) ||
                    doFind(value,matrix,xMid+1,left,bottom,yMid);
        }
   */
}
