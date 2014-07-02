package problems

/**
 * http://aperiodic.net/phil/scala/s-99/
 */
object Main extends App{
 System.out.println("Evanescense")

  def last[T](x:List[T]):Option[T] = x.isEmpty match {
    case true => None
    case false => Some(x.last)
  }
}
