package recursion

import java.lang.reflect.Array


/**
 * Created by sajit on 12/5/14.
 */
object RecursionUtils {

  def printParam(opc:Int,cpc:Int,mpc:Int,sb:String):Unit = {
    //println("OPC " + opc + " CPC " + cpc + " sb " + sb)
    if(opc>=mpc){
      if(cpc>= mpc){
        println("A valid string " + sb)
        return
      }
      else{ // no more opening brackets left but closing brackets count < max bracket count
        printParam(opc,cpc+1,mpc,sb +")")
      }

    }
    else{ //opening brackets < max brackets
       if(opc<= cpc){ //opening bracket count == close bracket count. has to be opening bracket
         printParam(opc+1,cpc,mpc,sb+"(")
       }
       else{ // two options.. either do an opening bracket or a closing bracket
         printParam(opc+1,cpc,mpc,sb+"(")
         printParam(opc,cpc+1,mpc,sb+")")
       }
    }



  }


  def maxVal(aList:List[Int]):Int = aList match {
    case Nil => throw new RuntimeException("Empty list maxValue not defined")
    case a::Nil => a
    case a::tail => math.max(a,maxVal(tail))
  }



}
