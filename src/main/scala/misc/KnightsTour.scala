package misc

import org.scalactic.Snapshot

/**
 * Created by sajit on 12/22/14.
 */
class KnightsTour (val size:Int) {

  val board = Array.ofDim[Boolean](size,size)
  val tourStep = Array.fill[Int](size,size)(-1)


  def isComplete(snapshot:Array[Array[Boolean]]):Boolean = {
    snapshot.flatten.filter{ el => !el}.isEmpty
  }

  var count = 0

  //TODO refactor this
  def getValidNexts(xPos: Int, yPos: Int, snapshot: Array[Array[Boolean]]) : List[(Int,Int)] = {
    var result:List[(Int,Int)] = List()
    //topLeft
    result = if(xPos-1>=0 && yPos-2>=0 && !snapshot(xPos-1)(yPos-2)){
      (xPos-1,yPos-2) :: result
      }
     else{
      result
    }
    if(xPos-2>=0 && yPos-1>=0 && !snapshot(xPos-2)(yPos-1)){
      result ::= (xPos-2,yPos-1)
    }

    //topRight
    if(xPos-1>=0 && yPos+2<size && !snapshot(xPos-1)(yPos+2)){
      result ::= (xPos-1,yPos+2)
    }
    if(xPos-2>=0 && yPos+1<size && !snapshot(xPos-2)(yPos+1)){
      result ::= (xPos-2,yPos+1)
    }

    //bottom right
    if(xPos+1<size && yPos+2<size && !snapshot(xPos+1)(yPos+2)){
      result ::= (xPos+1,yPos+2)
    }
    if(xPos+2<size && yPos+1<size && !snapshot(xPos+2)(yPos+1)){
      result ::= (xPos+2,yPos+1)
    }

    //bottomLeft
    if(xPos+1<size && yPos-2>=0 && !snapshot(xPos+1)(yPos-2)){
     result ::= (xPos+1,yPos-2)
    }
    if(xPos+2<size && yPos-1>=0 && !snapshot(xPos+2)(yPos-1)){
      (xPos+2,yPos-1) :: result
    }else{result}


  }

  def knightsTour(xPos:Int,yPos:Int,step:Int = 0):Unit = {
    board(xPos)(yPos) = true
    tourStep(xPos)(yPos) = step
    if(isComplete(board)){
      count +=1
      return
    }
    val nextPositions:List[(Int,Int)] = getValidNexts(xPos,yPos,board)
    nextPositions.foreach{tuple => {
        knightsTour(tuple._1,tuple._2,step+1)
    }}
   board(xPos)(yPos) = false
   tourStep(xPos)(yPos) = -1
  }

  def doWholeBoardTour() = {
    board.zipWithIndex.foreach{
      case(row,rowIdx) => row.zipWithIndex.foreach{case(col,colIdx) =>
       knightsTour(rowIdx,colIdx,0)
      }
    }
  }

  def getTotalCount() = count

  def printTourBoard = {
    tourStep.foreach{ row => row.foreach{el => System.out.print(" " + el)}
     System.out.println()
    }
  }


}
