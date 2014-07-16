package arithmetic

/**
 * Taken from http://aperiodic.net/phil/scala/s-99/arithmetic1.scala
 * Created by skunnumkal on 7/16/14.
 */
class SkaladInt(val anInt:Int) {

  import SkaladInt._

  def isPrime: Boolean = {
    if(anInt<2){false}
    else{
      (2  to (anInt/2)).toList.foldRight(true){(el,soFar) => anInt%el != 0 && soFar }
    }


  }
}
object SkaladInt{
  implicit  def int2SkaladInt(i:Int):SkaladInt = new SkaladInt(i)
}
