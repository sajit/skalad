package problems

import scala.util.Random

/**
 * http://aperiodic.net/phil/scala/s-99/
 */
object Main extends App {
  println("Evanescense")

  /**
   * Return the last element in an array
   * @param x
   * @tparam T
   * @return
   */
  def last[T](x: List[T]): Option[T] = x.isEmpty match {
    case true => None
    case false => Some(x.last)
  }

  /**
   * Return last but one element in array [version 1]
   * @param x
   * @tparam T
   * @return
   */
  def lastButOnev1[T](x: List[T]): Option[T] = x.size match {
    case 0 => None
    case 1 => None
    case _ => Some(x(x.length - 2))
  }

  /*
    Version 2
   */

  //  def lastButOnev2[T](x:List[T]):Option[T] = x match {
  //    case Nil => None
  //    case a :: Nil => None
  //    case a :: b :: Nil  =>   Some(a)
  //    case _ :: a :: b :: Nil => Some(a)
  //  }


  /**
   * Find kth element in a list
   * @param x
   * @param k
   * @tparam T
   * @return
   */
  def kth[T](x: List[T], k: Int): Option[T] = x.size < k match {
    case true => None
    case _ => Some(x(k - 1))

  }


  def reverse[T](x: List[T]): List[T] = {
    def reverseHelper[T](aList: List[T], acc: List[T]): List[T] = {
      if (aList.isEmpty) {
        acc
      }
      else {
        reverseHelper(aList.tail, aList.head :: acc)
      }
    }
    reverseHelper(x, List())
  }


  def isPalindrome[T](list: List[T]): Boolean = list match {

    case Nil => true
    case Nil :: a :: Nil => true
    case _ => {
      val head = list.head
      val last = list.last

      head == last && isPalindrome(list.slice(1, list.length - 1))
    }
  }

  /**
   * Version 1
   * @param ll
   * @tparam T
   * @return
   */
  def flatten1[T](ll: List[List[T]]): List[T] = ll.flatten


  def flatten2[T](ll: List[List[T]]): List[T] = ll.foldRight(List[T]())((sum, x) => sum ++ x)


  /**
   * Remove consecutive duplicates from a list
   * @param a
   * @return
   */
  def compress(a: List[Int]): List[Int] = {
    def compressHelper(aList: List[Int], acc: List[Int]): List[Int] = {
      if (aList.isEmpty) {
        acc
      }
      else {
        if (acc.isEmpty) {
          compressHelper(aList.tail, acc :+ aList.head)
        } else {
          if (aList.head == acc.last) {
            //skip
            compressHelper(aList.tail, acc)
          }
          else {
            //add
            compressHelper(aList.tail, acc :+ aList.head)
          }
        }
      }
    }
    compressHelper(a, List())
  }

  /**
   * Pack consecutive duplicates of list elements into sublists.
  If a list contains repeated elements they should be placed in separate sublists.
   */

  def pack(x: List[Char]): List[List[Char]] = {
    val mapOfList = x.groupBy(el => el)
    mapOfList.values.toList.sortWith((aList, bList) => aList.head < bList.head)
  }

  def neopack(x: List[Char]): List[List[Char]] = {
    def doNeoPack(aList: List[Char]): List[List[Char]] = {
      if (aList.isEmpty) {
        Nil
      }
      else {
        val (sub, rest) = aList.span { el => el == aList.head}
        sub :: doNeoPack(rest)

      }
    }
    doNeoPack(x)

  }

  /*
  Use the result of problem P09 to implement the so-called run-length encoding data compression method.
   Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E
   */
  def encodeX(packed: List[List[Char]]):List[(Int,Char)] = {
    packed.map(aList => (aList.length,aList.head)).toList
  }

  /*
  Modify the result of problem P10 (encode) in such a way that if an element has no duplicates
  it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
   */


  /**
   * Run-length encoding of a list.
Use the result of problem neopack to implement the so-called run-length encoding data compression method.
  Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
*/

  def encode1(x:List[Char]):List[(Int,Char)] = {
    val result:List[List[Char]] = neopack(x)

    result.map{aList => (aList.length, aList.head)}.toList
  }

  def encodeAny(tuples:List[(Int,Char)]):List[Any] = {
    tuples.map((tuple) => if(tuple._1 > 1){tuple} else {tuple._2} )
  }

  def decode(tuples:List[(Int,Char)]):List[Char] = {
    for{ (a,b) <- tuples;
         z <- 0 until a
       } yield(b)
  }

  def duplicateUp_v1[T](x:List[T],times:Int):List[T] = {
    //option 1
    for {el <- x;
         t <- 0 until times
    }yield(el)

  }

  def doubleUp_v2[T](x:List[T]) = {
    x.flatMap{ case el => List(el, el) }
  }

  def doubleUp_v3[T](x:List[T]) = {
    x.map{ el => List(el,el)}.flatten
  }

  def dropNth[T](x:List[T],n:Int):List[T] = {
    def dropHelper(aList:List[T]):List[T] = {
      if(aList.length<n){
        aList
      }else{
        val (prefix,suffix) = aList.splitAt(n-1)
        prefix ++ dropHelper(suffix.tail)
      }
    }
    dropHelper(x)
  }

  def split[T](pos:Int,x:List[T]):(List[T],List[T]) = {
    if(pos >= x.length){
      throw new NoSuchElementException
    }
    (x.take(pos),x.takeRight(x.length-pos))
  }

  def extract[T](start:Int,end:Int,x:List[T]):List[T] = {
    if(start > end || start <0 || end >= x.length){
      throw new IllegalArgumentException
    }
    val anIndexedSeq = for{
      i <- 0 until x.length
      if(i >= start && i < end)
    }yield{x(i)}

    anIndexedSeq.toList
  }

  def rotate[T](times:Int,x:List[T]):List[T] = {

    x.takeRight(times) ++ x.take(x.length-times)

  }

  /**
   * Takes a list and the position to remove an element from and return a tuple
   * @param pos
   * @param x
   * @tparam T
   * @return
   */
  def removeAt[T](pos:Int,x:List[T]):(List[T],T) = {
    (x.take(pos-1) ++ x.takeRight(x.length - pos),x(pos-1))
  }

  def insertAt[T](pos:Int,x:List[T],el:T):List[T] = {
    val (pre,post) = x.splitAt(pos)
    pre ++ List(el) ++ post
  }

  def range(start:Int,end:Int):List[Int] = {
    val indexedSeq = for{x <- start until end} yield(x)
    indexedSeq.toList
  }

  //TODO do some shapeless magic later to make sure that output list has that many elements
  def randomSelect[T](count:Int,list:List[T]):List[T] = {
    if (count <=0) {
      return Nil;
    }
    val idx = Random.nextInt(list.length)
    val (prefix, suffix) = list.splitAt(idx)
    if (prefix.length > 1) {
      val remaining = prefix.take(prefix.length - 1) ++ suffix
      prefix.last :: randomSelect(count - 1, remaining)
    }
    else {
      suffix.head :: randomSelect(count - 1, suffix.tail)
    }
  }

  def lotto(count:Int,max:Int):List[Int] = {
    {for{ i <- 1 to count} yield {Random.nextInt(max)}}.toList
  }

  def shuffle[T](x:List[T]) = {
    Random.shuffle(x)
  }

  /**
   * Generate all possible combinations of aList C k
   * @param k
   * @param aList
   * @tparam T
   * @return
   */
  def combinations[T](k:Int,aList:List[T]):List[List[T]] = {

    def combHelper(n:Int,x:List[T]):List[List[T]] = {
      if(n<=1){
        val indexedSeqOfList = for{el <-x}yield{List(el)}
        indexedSeqOfList.toList
      }
      else{
        x.flatMap{
          el => {
            val remaining = x.filterNot{otherElem => otherElem == el}
            val ll = combHelper(n-1,remaining)
            ll.map{aList => aList :+ el}
          }
        }

      }

    }
    val aListOfLists:List[List[T]] = combHelper(k,aList) //this will have duplicates, since
    //we care about selections and not order we remove duplicates
    val listOfSets:List[Set[T]] = aListOfLists.map{someList => someList.toSet}
    val uniqueListOfSets = listOfSets.distinct
    val uniqueListOfLists = uniqueListOfSets.map{ aSet => aSet.toList}
    uniqueListOfLists
  }


  /**
   * Generate a disjoint subset, with each set consisting of number elements as in remaining
   * @param remaining
   * @param remInput
   * @tparam T
   * @return
   */
  def disjointSet[T](remaining:List[Int],remInput:List[T]):List[List[T]] = {
    if(remaining.isEmpty){
      Nil
    }
    else{
      val currentChoose = remaining.head
      if(currentChoose > remInput.length){
        throw new IllegalArgumentException
      }
      else{
        val indexSeq:IndexedSeq[T] = for{ i <- 0 until currentChoose} yield{remInput(Random.nextInt(remInput.length))}
        indexSeq.toList :: disjointSet(remaining.tail,remInput.filter{x => !indexSeq.contains(x)})
      }
    }
  }

  def sortListOfLists[T](ll:List[List[T]]):List[List[T]] = ll.sortBy{aList => aList.length}



}



