package simple.transformations

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
    def doBinary2Dec(aList:List[Char],sum:Int):Int = {
      if (aList.isEmpty) {
        sum
      } else {
        val cur = aList.head.toInt-48 //because '0'.toInt  = 48
        doBinary2Dec(aList.tail, sum + Math.pow(2, aList.tail.length).toInt * cur)


      }
    }
    doBinary2Dec(bin,0)
  }

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
