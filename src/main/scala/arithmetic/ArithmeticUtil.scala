package arithmetic

import problems.SkaladInt

import scala.collection.mutable.Stack

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
    val allPairs = goldbachPairs(x)

    allPairs(0)
  }

  private def goldbachPairs(x:Int):List[(Int,Int)] = {
    val primes = primeList(2,x)
    val pairs = for{
      i <- primes
      if(primes.contains(x-i))
    }yield{(i,(x-i))}
    println(x + " has " + pairs.length + " prime pairs")
    pairs.toList
  }

  def goldbachFilteredPair(x:Int,threshold:Int):List[(Int,Int)] = {
    val allPairs = goldbachPairs(x)
    allPairs.filter{aPair => aPair._1 > threshold && aPair._2 > threshold}
  }

  def postFixEvaluation(expr:String):Double = {
    val stack = Stack[Double]()
    var current = expr
    while(!current.isEmpty){
      current.head match {
        case '+' => {
          stack.push(stack.pop() + stack.pop())
        }
        case '-' => {
          stack.push(-stack.pop() + stack.pop())
        }
        case '*' => {
          stack.push(stack.pop() * stack.pop())
        }
        case '/' => {
          stack.push((1/stack.pop()) * stack.pop())
        }
        case x: Char => {
          stack.push(x.asDigit)
        }
      }

      current = current.tail
    }
    stack.pop()
  }

  def compute(op1: Int, operator: Char, op2: Int): Int = {
      operator match {
        case '+' => op1 + op2
        case '-' => op1 - op2
        case '*' => op1 * op2
        case '/' => op1 / op2
      }
  }

  def preFixEvaluation(expr:String):Int  = {
    val stack = Stack[Any]()
    var current = expr
    stack.push(current.head)
    current = current.tail

    while(!current.isEmpty){
     // println("Stack Top " + stack.top + " Current Head " + current.head)
      current.head.isDigit match {
        case false => stack.push(current.head)
        case true => {
          var result = current.head.asDigit
          while(!stack.isEmpty && stack.top.isInstanceOf[Int]){
            val operand = stack.pop().asInstanceOf[Int]
            val operator = stack.pop().asInstanceOf[Char]
            result = compute(operand,operator,result)
          }

          stack.push(result)
        }
      }
      current = current.tail
    }
    //println(stack.size + " Stack size")
    stack.pop().asInstanceOf[Int]
  }


}
