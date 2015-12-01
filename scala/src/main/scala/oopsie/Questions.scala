package oopsie

/**
 * Created by sajit on 8/8/14.
 */
trait Base{
  val key:String
  type A <:Base
  def find():A
}

case class SA(key:String,text:String) extends Base{
  type A = SA
  override def find():SA = new SA("flipsyde","toh")
}


object Questions {

}
