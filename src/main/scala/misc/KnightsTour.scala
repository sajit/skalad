package misc

import org.scalactic.Snapshot

/**
 * Created by sajit on 12/22/14.
 */
class KnightsTour (val size:Int) {

  val board = Array.ofDim[Boolean](size,size)

  def isComplete(snapshot:Array[Array[Boolean]]):Boolean = {
    snapshot.flatten.filter{ el => !el}.isEmpty
  }

  def getValidNexts(xPos: Int, yPos: Int, snapshot: Array[Array[Boolean]]) : List[(Int,Int)] = {
    var result:List[(Int,Int)] = List()
    //topLeft
    if(xPos-1>=0 && yPos-2>=0 && !board(xPos-1)(yPos-2)){
      result = (xPos-1,yPos-2) :: result
    }
    if(xPos-2>=0 && yPos-1>=0 && !board(xPos-2)(yPos-1)){
      result = (xPos-2,yPos-1) :: result
    }

    //topRight
    if(xPos-1>=0 && yPos+2<size && !board(xPos-1)(yPos+2)){
      result = (xPos-1,yPos+2) :: result
    }
    if(xPos-2>=0 && yPos+1<size && !board(xPos-2)(yPos+1)){
      result = (xPos-2,yPos+1) :: result
    }

    //bottom right
    if(xPos+1<size && yPos+2<size && !board(xPos+1)(yPos+2)){
      result = (xPos+1,yPos+2) :: result
    }
    if(xPos+2<size && yPos+1<size && !board(xPos+2)(yPos+1)){
      result = (xPos+2,yPos+1) :: result
    }

    //bottomLeft
    if(xPos+1<size && yPos-2>=0 && !board(xPos+1)(yPos-2)){
      
    }

    result
  }

  def knightsTour(xPos:Int,yPos:Int):Unit = {
    board(xPos)(yPos) = true
    if(isComplete(board)){
      println("Completed a tour")
      return
    }
    else{
      val nextPositions:List[(Int,Int)] = getValidNexts(xPos,yPos,board)
      nextPositions.foreach{tuple => {
        knightsTour(tuple._1,tuple._2)
        board(tuple._1)(tuple._2) = false
      }}

    }
  }

}
