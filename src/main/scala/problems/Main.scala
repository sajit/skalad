package problems

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
}



