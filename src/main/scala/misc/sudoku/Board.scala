package misc.sudoku

/**
 * Created by sajit on 1/1/15.
 */
class Board(cells:Array[Array[Int]]) {

  def solve(boardState:Array[Array[Int]]):Array[Array[Int]] = {

    if(SudokuHelperUtils.isSolved(boardState)){
         boardState
    }
    else{
      boardState.foreach{ row => row.foreach{element => {
        if(element==0){
          SudokuHelperUtils.checkRow()
        }
      }}}
    }
  }

}
