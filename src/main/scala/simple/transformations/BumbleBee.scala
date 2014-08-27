package simple.transformations

/**
 * Created by sajit on 8/27/14.
 */
object BumbleBee {

  def encode(s:String):BigInt =  BigInt(s.getBytes)

  def decode(b:BigInt):String = new String(b.toByteArray)
}
