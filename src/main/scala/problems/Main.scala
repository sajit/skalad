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
}
