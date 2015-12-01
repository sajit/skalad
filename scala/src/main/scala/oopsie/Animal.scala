package oopsie



/**
 * Created by skunnumkal on 8/9/14.
 */
trait Animal {
  val name:String
  type T <: Animal
  def find():T
  def findName():String = find().name

}


case class Dog(name:String) extends Animal{
  override type T = Dog

  override def find(): T = Dog("fido")
}
