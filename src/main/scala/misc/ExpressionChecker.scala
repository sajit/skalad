package misc

import java.util.Stack

/**
 * Created by skunnumkal on 12/26/14.
 */
class ExpressionChecker {

}
object ExpressionChecker {
  /**
   * Check validity of an infix expression without any paranthesis
   * @param expr
   * @return
   */
  def isValid(expr:String):Boolean = {
     val validSymbols = List[Char]('+','-','/','*')
     def doCheck(remain:String,prev:Char):Boolean = {
       if(remain.isEmpty){
         true
       }
       else{
         val head:Char = remain.charAt(0)
         if(head.isDigit){
           if(prev.isDigit){
             false
           }
           else{
             doCheck(remain.tail,head)
           }
         }
         else{
           if(validSymbols.contains(head)){
             if(!prev.isDigit){
               false
             }
             else{
               doCheck(remain.tail,head)
             }
           }
           else{
             false
           }
         }

       }
     }
    if(expr.isEmpty){
      false
    }
    else{
      val first:Char = expr.charAt(0)
      if(first.isDigit){
        doCheck(expr.tail,first)
      }
      else{
        false
      }
    }
  }
}