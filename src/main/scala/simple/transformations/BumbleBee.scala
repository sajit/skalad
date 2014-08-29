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
}
