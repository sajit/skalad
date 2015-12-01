package logic

/**
 * Created by skunnumkal on 7/22/14.
 */
class SkaLogic {

}

object SkaLogic {



  def not(a: Boolean) = a match {
    case true  => false
    case false => true
  }
  def and(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (true, true) => true
    case _            => false
  }
  def or(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (true, _) => true
    case (_, true) => true
    case _         => false
  }

  def nand(a:Boolean,b:Boolean):Boolean = not(and(a,b))

  def nor(a:Boolean,b:Boolean):Boolean = not(or(a,b))

  def xor(a:Boolean,b:Boolean) = or(and(a,not(b)),and(not(a),b))

  def equ(a: Boolean, b: Boolean): Boolean = xor(a,b) == false


}
