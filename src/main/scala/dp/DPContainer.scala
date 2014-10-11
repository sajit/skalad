package dp

/**
 * Created by skunnumkal on 10/11/14.
 */
object DPContainer {

  def longestPalindrome(x:String):Int = {
    val c = Array.ofDim[Int](x.length,x.length)

    for ( i <- 0 to (c.length - 1)) {
      c(i)(i) = 1
    }
    var max:Int = 0
    for( i <- c.length-2  to 0 by -1){
      for(j <- (i+1) to c.length-1){
        if(x(i)==x(j) && c(i+1)(j-1)>=0){
          c(i)(j) = c(i+1)(j-1) + 2
          if(c(i)(j)>max){
            max = c(i)(j)
          }
        }else{
          c(i)(j) = -1
        }
      }

    }
//    for(i <- 0 to c.length -1){
//      for(j <- 0 to c.length -1){
//        print(c(i)(j)+ " ")
//      }
//      println()
//    }
    max

  }


  def main(args:Array[String]) = {
    val str = "malayalam"
    println(longestPalindrome(str))
  }
}
