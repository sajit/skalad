package pandc

import scala.collection.mutable

/**
 * Created by skunnumkal on 10/29/14.
 */
object PandCUtil {

  def generatePermutations(str:String):List[String] = {
    if(str.length==1){
      List(str)
    }
    else{
      val head = str.head
      val tempList = generatePermutations(str.tail)
      tempList.map{aStr => insertIntoEveryPosition(head,aStr)}.flatten
    }
  }

  def insertIntoEveryPosition(ch:Char,str:String):List[String] = {

    val result= new mutable.MutableList[String]()
    for(i <- 0 to str.length){
      val prefix = str.substring(0,i)
      val suffix = str.substring(i+1);

      //println(prefix + " : " + suffix)
      result += prefix + String.valueOf(ch) + suffix
    }
    //print(result.toList + " | ")
    result.toList
  }
}
