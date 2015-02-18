package misc.sudoku

/**
 * Created by sajit on 1/6/15.
 */
object SudokuHelperUtils {


  def getPossibleNums(in:List[Int]):List[Int] = {
    val fullList = List(1,2,3,4,5,6,7,8,9)
    fullList diff in
  }

  def isSolved(in:Array[Array[Int]]):Boolean = {
    in.flatten.filter{ x => x != 0}.length == 0
  }

  def getGroupPossibleNums(board:Array[Array[Int]],xPos:Int,yPos:Int):List[Int] = {
    def getYGroup(xTopLeft:Int,xBottomRight:Int):List[Int] = {
      if(yPos<3){
        //group1
        //extract(board,xTopLeft,yTopLeft,xbottomRight,yBottomRight
        getPossibleNums(extract(xTopLeft,0,xBottomRight,2,board))

      }
      else if(yPos < 6){
        getPossibleNums(extract(xTopLeft,3,xBottomRight,5,board))
      }
      else{
        getPossibleNums(extract(xTopLeft,6,xBottomRight,8,board))
      }
    }
    def extract(xTopLeft:Int,yTopLeft:Int,xBottomRight:Int,yBottomRight:Int,boardState:Array[Array[Int]]):List[Int] = {
      (for{x <- xTopLeft to xBottomRight;
          y <- xTopLeft to yBottomRight} yield boardState(x)(y)).toList
    }
    if(xPos < 3){
       getYGroup(0,2)
    }
    else if(xPos <6) {
      getYGroup(3,5)
    }
    else{
      getYGroup(6,8)
    }
  }






}
