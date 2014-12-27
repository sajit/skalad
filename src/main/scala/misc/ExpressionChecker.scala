package misc

import java.lang.Integer
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
  //TODO refactor this
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

  def isValid2(expr:String):Boolean = {
    val validSymbols = List[Char]('+','-','/','*')
    def doCheck(remain:String,prev:Char):Boolean = {
      remain.isEmpty match {
        case true => true
        case false => {
          val head: Char = remain.charAt(0)
          head.isDigit match {
            case true => {
              prev.isDigit match {
                case true => false
                case false => doCheck(remain.tail, head)
              }
            }
            case false => {
              /** head is a char **/
              validSymbols.contains(head) match {
                case false => false
                case true => {
                  prev.isDigit match {
                    case false => false
                    case true => doCheck(remain.tail, head)
                  }
                }
              }



            }

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

  def validParans(expr:String):Boolean = {

    def doCheck(in:String,pattern:String):Boolean = {
      if(in.isEmpty){
        pattern.isEmpty
      }
      else{
        val head = in.head
        head match {
          case '(' => doCheck(in.tail,pattern + head)
          case ')' => {
            if(pattern.isEmpty){
              false
            }
            else{
              doCheck(in.tail,pattern.dropRight(1))
            }
          }
        }
      }
    }
    doCheck(expr,"")
  }

}