package misc.sudoku

/**
 * Created by sajit on 1/1/15.
 */
class Board(cells:Array[Array[Int]]) {

//  def solve(boardState:Array[Array[Int]]):Array[Array[Int]] = {
//
//    if(SudokuHelperUtils.isSolved(boardState)){
//         boardState
//    }
//    else{
//      boardState.zipWithIndex.map{
//        case(row,rowIdx) => row.zipWithIndex.map{
//          case(element,colIdx) => {
//
//         val rowPossiblities = SudokuHelperUtils.getPossibleNums(row.toList)
//          if(rowPossiblities.length==1){
//            val clone = boardState.clone()
//            clone(rowIdx)(colIdx) = rowPossiblities(0)
//            return solve(clone)
//          }
//          else{
//            return solve(boardState.clone())
//          }
//          //val transposed = boardState.transpose
//          //val colPossiblities = SudokuHelperUtils.getPossibleNums(transposed(colIdx).toList)
//          //val groupPossibles = SudokuHelperUtils.getGroupPossibleNums(boardState,rowIdx,colIdx)
//
//
//      }
//      }
//      }
//    }
//  }

}
