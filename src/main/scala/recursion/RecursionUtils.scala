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



  def maxVal[T <: Number](aList:List[T]):T = {
    val myMax = new MyMax[T]
    aList match {
      case Nil => throw new RuntimeException("Empty list maxValue not defined")
      case a :: Nil => a
      case a::tail =>  myMax.max(a, maxVal(tail))
    }
  }

  def takeN(n:Int,aList:List[Int]):List[Int] = {
    def doTakeN(n:Int,rem:List[Int],soFar:List[Int]):List[Int] = {
      if(n<=0){
        soFar
      }
      else{
        rem match {
          case Nil => throw new RuntimeException("Empty list cannot be taken")
          case a::tail => doTakeN(n-1,tail,a::soFar)
        }
      }
    }
   doTakeN(n,aList,List())
  }




}

/**
 * This is not the ideal claass but what I wanted to test is whether i could inject this into maxVal
 * @tparam T
 */
class MyMax[T <:Number]{

  def max[T](a:T,b:T):T = {
    if (a.isInstanceOf[Integer]) {
      val intA = a.asInstanceOf[Integer]
      val intB = b.asInstanceOf[Integer]

      if(intA > intB) {a} else {b}

    }
    else {
      //assuming double
      val doubA = a.asInstanceOf[Double]
      val doubB = b.asInstanceOf[Double]
      if (doubA < doubB) {
        b
      } else {
        a
      }
    }

  }

}
