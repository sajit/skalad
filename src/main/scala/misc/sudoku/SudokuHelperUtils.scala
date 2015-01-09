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



}
