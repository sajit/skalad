package oopsie

import java.util.UUID
/**
 * Created by sajit on 8/8/14.
 */
class Foo1(val name:String,val old:Boolean) {

}
abstract class BaseQ(key:String,text:String){
  //val baseT:String = text
  def this(text:String) = this(UUID.randomUUID().toString,text)
}

case class ShortAnswer(text:String) extends BaseQ(UUID.randomUUID().toString,text)
