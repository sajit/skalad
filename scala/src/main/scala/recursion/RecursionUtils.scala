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

  def myFlatten(al:List[Any]):List[Any] =  al match {

    case(head::tail) => {
      head match {
        case xl:List[Any] => myFlatten(xl) ++ myFlatten(tail)
        case _ => head :: myFlatten(tail)
      }
    }
    case Nil => List()
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


  def packUp(al:List[Int]):List[List[Int]] = {
      def doPackUp(prev:Int,rem:List[Int],score:Int,acc:List[List[Int]]):List[List[Int]] = {
        rem match {
          case  Nil => {
            List.fill(score)(prev)::acc
          }
          case x:: xs => {
            prev == x match {
              case true => doPackUp(x,xs,score+1,acc)
              case false => doPackUp(x,xs,1,List.fill(score)(prev) :: acc)
            }
          }
        }
      }
    doPackUp(Int.box(-1),al,1,Nil).reverse.tail
    
  }


  def myCount(n:Char,acc:Int,str:String):Int = {
    if(str.isEmpty()){
       acc
    }
    else {
      val head = str.head
      val count = if(head == n){ 1} else {0} ;
      myCount(n,count+acc,str.tail)
    }
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
