package logic

/**
 * Created by skunnumkal on 7/22/14.
 */
object LogicUtils {

  def grayCode(n:Int):List[String] = {
    def buildUp(times:Int,acc:List[String]):List[String] = {
      if(times<=0){
        acc
      }
      else{
        val zeroes = acc.map{aValue => "0" + aValue}
        val ones = acc.map{aValue => "1" + aValue}
        buildUp(times-1,zeroes ++ ones)
      }
    }
    val initList = List("0","1")
    buildUp(n-1,initList)
  }



}
