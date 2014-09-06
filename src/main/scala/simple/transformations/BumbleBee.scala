package simple.transformations

import scala.collection.mutable

/**
 * Created by sajit on 8/27/14.
 */
object BumbleBee {

  def encode(s:String):BigInt =  BigInt(s.getBytes)

  def decode(b:BigInt):String = new String(b.toByteArray)

  def toBinary(num:Int):List[Char] = {
    def do2Binary(n:Int,ch:List[Char]):List[Char] = {
      if(n==0){
        '0' :: ch

      }
      else if(n==1){
        '1' :: ch
      }
      else{
        val rem:Char = n%2 match {
          case 0 => '0'
          case 1 => '1'
        }
        do2Binary(n/2,rem :: ch)
      }
    }
    do2Binary(num,List())
  }

  def binaryToDec(bin:List[Char]):Int = {

    doBaseToDec(bin,0,2)
  }
  def doBaseToDec(aList:List[Char],sum:Int,base:Int):Int = {
    if (aList.isEmpty) {
      sum
    } else {
      val head = aList.head
      val cur = base match {
        case 2 => head.toInt - 48   //because '0'.toInt  = 48
        case 16 => reverseHexMap.get(head).get
      }
      doBaseToDec(aList.tail, sum + Math.pow(base, aList.tail.length).toInt * cur,base)


    }
  }

  def dec2Hex(num:Int):List[Char] = {
    var x = num
    var result:mutable.MutableList[Char] = new mutable.MutableList[Char]
    while(x>0){
      val quotient = x / 16
      val remainder = x % 16
      x = quotient
      result += hexMap.get(remainder).get
    }
    result.toList.reverse
  }

  def hex2Dec(hex:List[Char]):Int = {
    doBaseToDec(hex,0,16)
  }
  val hexMap = Map(0 -> '0',1 -> '1', 2 -> '2', 3 -> '3', 4 -> '4', 5 -> '5', 6 -> '6', 7 -> '7' , 8 -> '8', 9 -> '9',10 -> 'A',11 -> 'B',12 -> 'C',13-> 'D', 14-> 'E',15 -> 'F')
  val reverseHexMap = hexMap.map{ _.swap}

  def decToHex(num:Int):String = {
     var varNum = num
     var result:List[Char] = List[Char]()
     while(varNum>0){
       val rem = getHexRemainder(varNum)
       result = rem :: result
       varNum = varNum/16

     }
    result.mkString
  }
  def getHexRemainder(aNum:Int):Char = {
    dec2HexMapping(aNum%16)
  }
  val dec2HexMapping = Map(0 -> '0',1 -> '1',2-> '2',3->'3',4->'4',5->'5',6->'6',7->'7',8->'8',9->'9',10->'A',11->'B',12->'C',13->'D',14->'E',15->'F')
}
