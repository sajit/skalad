package arithmetic

import problems.SkaladInt

/**
 * Created by skunnumkal on 7/17/14.
 */
object ArithmeticUtil {

  def gcd1(m:Int,n:Int):Int = {
    if(n ==0) m else gcd1(n,m%n)
  }

  def factors(i: Int): Set[Int] = {
    val indexedSeq:IndexedSeq[Int] = for{  j <- 2 to i/2
       if(i%j==0)}yield{j}
    indexedSeq.toSet
  }

  def gcd2(m:Int,n:Int):Int = {
    val facts1:Set[Int] = factors(m)
    val facts2:Set[Int] = factors(n)
    val intersection = facts1.intersect(facts2)
    if(intersection.isEmpty){
      1
    }
    else{
      intersection.max
    }
  }


  def times(factor:Int,multiple:Int,acc:Int):Int = {
    if(multiple%factor != 0){
      acc
    }else{
      times(factor,multiple/factor,acc+1)
    }
  }

  def primeList(start:Int,end:Int):List[Int] = {
    import SkaladInt._
    for{ i <- start to end
    if(i.isPrime)}yield(i)
  }.toList

  def goldbach(x:Int):(Int,Int) = {
    if(x%2 != 0){
      throw new IllegalArgumentException("Not even. Not cool")
    }
    val primes = primeList(2,x)
    val pairs = for{
      i <- primes
      if(primes.contains(x-i))
    }yield{(i,(x-i))}
    println(x + " has " + pairs.length + " prime pairs")
    pairs(0)
  }

}
