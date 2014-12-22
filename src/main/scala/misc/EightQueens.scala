package misc
class EightQueens(val size:Int){

  val board = Array.ofDim[Boolean](size,size)
  def printBoard() = {
    val cArr = board.map{ y  => y.map{x => {if(!x) {" "}else{"Q "}}}}
    cArr.map{row => {
      //print row
      row.map{el => System.out.print(el)}
      System.out.println()
    }}
  }

  def placeQueen(row:Int,col:Int) = {
    board(row)(col) = true
  }

  def checkCol(row:Int,col:Int):Boolean = {
      if(row<0){
        true
      }
      else{
        !board(row)(col) && checkCol(row-1,col)
      }


  }
  def checkFwdDiagonal(row:Int,col:Int):Boolean = {
    if(row<0 || col<0){
      true
    }
    else{
      !board(row)(col) && checkFwdDiagonal(row-1,col-1)
    }
  }

  def checkBwdDiagonal(row:Int,col:Int):Boolean = {
    println("Row " + row + "Col " + col)
    if(row<0 || col>=size){
      true
    }
    else{
      !board(row)(col) && checkBwdDiagonal(row-1,col+1)
    }

  }

//  def getPossibleCols(currentRow:Int):List[Int] = {
//    def doGetPossibleCols(currentCol:Int,soFar:List[Int]):List[Int] = {
//      if(currentCol >= size){
//        soFar
//      }
//      else{
//        if(checkCol(currentCol) && checkFwdDiagonal(currentCol) && checkBwdDiagonal(currentCol)){
//          doGetPossibleCols(currentCol+1,currentCol :: soFar)
//        }
//        else{
//          doGetPossibleCols(currentCol+1,soFar)
//        }
//      }
//    }
//    doGetPossibleCols(0,List[Int]())
//  }
//  def placeQueen(row:Int):Unit = {
//    if(row >= size){
//      printBoard()
//      return
//    }
//    val possiblities:List[Int] = getPossibileCols(row)
//
//  }

}