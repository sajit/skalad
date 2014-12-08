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

  def longestContinuousSum(inList:List[Int]):Int = {
    var currentSeqSum = 0
    var maxSeqSum = 0
    for(i <- 0 to inList.length-1){
      currentSeqSum += inList(i)
      if(currentSeqSum<0){
        currentSeqSum = 0
      }
      if(currentSeqSum > maxSeqSum){
        maxSeqSum = currentSeqSum
      }

    }
    maxSeqSum

  }
  val weights = List(12,2,1,4,1)
  val values = List(4,2,1,10,2)

  def kp1(weight:Int):Int = {

    //There are infinite numbers of each item
    def recursiveKp(idx:Int,remainingWeight:Int):Int = {
      //println(idx+" | " + remainingWeight)
      if(idx < 0){
        return -1000
      }
      if(remainingWeight<0){
        return -1000
      }
      if(remainingWeight == 0){
        return 0
      }
      Math.max(recursiveKp(idx-1,remainingWeight),
               recursiveKp(idx,remainingWeight-weights(idx))+values(idx))
    }
    recursiveKp(values.length-1,weight)
  }

  def kp2(weight:Int):Int = {
    val factors:IndexedSeq[(Double,Int,Int)] = for { i <- 0 until values.length}
    yield ((values(i).toDouble/weights(i).toDouble),values(i),weights(i))
    val sortedFactors = factors.sortBy{aVal => aVal._1}.reverse
    var remainingWeight = weight
    var value = 0
    var i=0
    while(remainingWeight>=0){
      value += sortedFactors(i)._2
      i+=1
      remainingWeight-=sortedFactors(i)._3
    }
    value
  }

//This is not working
//  def kp2(weight:Int):Int = {
//    //only 1 item of each type
//    def recursiveKp1Item(idx:Int,remainingWeight:Int):Int = {
//
//      if(idx < 0 ){ return -1000 }
//      if(remainingWeight < 0 ){
//        return -1000
//      }
//      if(remainingWeight == 0 ){ return 0}
//      val withoutIdx = recursiveKp1Item(idx-1,remainingWeight)
//      val withIdx = recursiveKp1Item(idx-1,remainingWeight-weights(idx))+values(idx)
//      println("Idx="+idx+",Weight="+remainingWeight, "With="+withIdx," Without="+withoutIdx)
//      Math.max(withoutIdx,withIdx)
//    }
//    recursiveKp1Item(values.length-1,weight)
//  }


  def main(args:Array[String]) = {
    val str = "malayalam"
    println(longestPalindrome(str))
  }
}
