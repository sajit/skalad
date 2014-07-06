package problems

/**
 * http://aperiodic.net/phil/scala/s-99/
 */
object Main extends App{
 System.out.println("Evanescense")

  /**
   * Return the last element in an array
   * @param x
   * @tparam T
   * @return
   */
  def last[T](x:List[T]):Option[T] = x.isEmpty match {
    case true => None
    case false => Some(x.last)
  }

  /**
   * Return last but one element in array [version 1]
   * @param x
   * @tparam T
   * @return
   */
  def lastButOnev1[T](x:List[T]):Option[T] = x.size match {
    case 0 => None
    case 1 => None
    case _ => Some(x(x.length-2))
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
    def kth[T](x:List[T],k:Int):Option[T] = x.size < k match {
      case true => None
      case _ => Some(x(k-1))

    }


    def reverse[T](x:List[T]):List[T] = {
      def reverseHelper[T](aList:List[T],acc:List[T]):List[T] = {
        if(aList.isEmpty){
          acc
        }
        else{
          reverseHelper(aList.tail,aList.head :: acc)
        }
      }
      reverseHelper(x,List())
    }


   def isPalindrome[T](list:List[T]):Boolean = list match {

     case Nil => true
     case Nil :: a :: Nil => true
     case _ => {
       val head = list.head
       val last = list.last
       head.equals(last) && isPalindrome(list.slice(1,list.length-1))
     }
   }

  /**
   * Version 1
   * @param ll
   * @tparam T
   * @return
   */
  def flatten1[T](ll:List[List[T]]):List[T] = ll.flatten


  
  def flatten2[T](ll:List[List[T]]):List[T] = ll.foldRight(List[T]())((sum,x) => sum ++ x)


  /**
   * Remove consecutive duplicates from a list
   * @param a
   * @tparam T
   * @return
   */
  def compress(a:List[Int]):List[Int] = {
    def compressHelper(aList:List[Int],acc:List[Int]):List[Int] = {
      if(aList.isEmpty){
        acc
      }
      else{
        if(acc.isEmpty){
          compressHelper(aList.tail,acc :+ aList.head)
        }else{
          if(aList.head == acc.last){
            //skip
            compressHelper(aList.tail,acc)
          }
          else{
            //add
            compressHelper(aList.tail,acc :+ aList.head)
          }
        }
      }
    }
    compressHelper(a,List())
  }



}
