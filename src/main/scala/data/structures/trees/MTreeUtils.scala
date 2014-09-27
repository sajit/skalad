package data.structures.trees
import scala.collection.mutable.MutableList

/**
 * Created by sajit on 9/25/14.
 */
object MTreeUtils {

  def buildTree(str:String):MTree[Char] = {
      def foo(aStr:String,current:MTree[Char]):(String,MTree[Char]) = {
        if(aStr.isEmpty){
          (aStr,current)
        }
        if(aStr.head == '^'){
          (aStr.tail,current)
        }
        else{
          foo(aStr.tail,MTree(aStr.head))
        }
      }
      var rem = str
      var children = MutableList[MTree[Char]]()
      while(!rem.isEmpty){
        val (rx,child) = foo(rem.tail,MTree(rem.head))
        rem = rx
        children += child
      }
      MTree(rem.head,children.toList)



  }

}
