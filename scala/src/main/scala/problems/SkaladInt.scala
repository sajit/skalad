package problems

import arithmetic.ArithmeticUtil

/**
 * Taken from http://aperiodic.net/phil/scala/s-99/arithmetic1.scala
 * Created by skunnumkal on 7/16/14.
 */
class SkaladInt(val anInt:Int) {

  import problems.SkaladInt._

  /**
   * Calculates whether a number is prime
   * @return
   */
  def isPrime: Boolean = {
    if(anInt<2){false}
    else{
      (2  to (anInt/2)).toList.foldRight(true){(el,soFar) => anInt%el != 0 && soFar }
    }


  }

  def isCoPrime(x:Int):Boolean = {
    ArithmeticUtil.gcd1(anInt,x) == 1
  }

  /**
   * Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
   * @return
   */
  def phi: List[Int] = {
    {for{ r<- 1 to anInt
        if(anInt.isCoPrime(r))} yield(r)}.toList
  }

  def primeFactors:List[Int] = {
    {for{ i <- 2 until anInt/2
         if(anInt%i==0 && i.isPrime)} yield(i)}.toList
  }

  def primeFactorMultiplicity:Map[Int,Int] = {
    val primeFactors = anInt.primeFactors
    primeFactors.map{
      aPf => (aPf,ArithmeticUtil.times(aPf,anInt,0))
    }.toMap
  }


}
object SkaladInt{
  implicit  def int2SkaladInt(i:Int):SkaladInt = new SkaladInt(i)
}
