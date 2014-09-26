package data.structures.trees

/**
 * Created by sajit on 9/25/14.
 */
object MTreeUtils {

  def buildTree(str:String):MTree[Char] = {
    def buildChildren(rem:String,soFar:List[MTree[Char]]):List[MTree[Char]] = {
      if(rem.isEmpty){
        soFar
      }
      else{
        val head = rem.head
        if(head == '^'){
          soFar
        }
        else{
          val currentNode = MTree(head,buildChildren(rem.tail,List[MTree[Char]]()))
          currentNode :: soFar
        }
      }
    }
    MTree(str.head,buildChildren(str.tail,List[MTree[Char]]()))
  }

}
