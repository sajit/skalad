package misc
class EightQueens(val size:Int){

  val board = Array.ofDim[Boolean](size,size)
  //val solutions  = List[Array[Array[String]]]
  def printBoard(snapshot:Array[Array[Boolean]]) = {
    val cArr = snapshot.map{ y  => y.map{x => {if(!x) {" "}else{"Q"}}}}
    cArr.foreach{row => {
      //print row
      row.foreach{el => System.out.print(el+ "|")}
      System.out.println()
    }}
  }

  def modifyQueenPosition(row:Int,col:Int,state:Boolean) = {
    board(row)(col) = state
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
    //println("Row " + row + "Col " + col)
    if(row<0 || col>=size){
      true
    }
    else{
      !board(row)(col) && checkBwdDiagonal(row-1,col+1)
    }

  }

  def getPossibleCols(currentRow:Int):List[Int] = {
    def doGetPossibleCols(currentCol:Int,soFar:List[Int]):List[Int] = {
      if(currentCol >= size){
        soFar
      }
      else{
        if(checkCol(currentRow,currentCol) && checkFwdDiagonal(currentRow,currentCol) && checkBwdDiagonal(currentRow,currentCol)){
          doGetPossibleCols(currentCol+1,currentCol :: soFar)
        }
        else{
          doGetPossibleCols(currentCol+1,soFar)
        }
      }
    }
    doGetPossibleCols(0,List[Int]())
  }
  def placeQueenOnBoard(row:Int):Unit = {
    if(row >= size){
      printBoard(board)
      System.out.println("---------------------------")
      return
    }
    val possiblities:List[Int] = getPossibleCols(row)
    possiblities.foreach{col => {
      modifyQueenPosition(row,col,true)
      placeQueenOnBoard(row+1)
      modifyQueenPosition(row,col,false)
    }}

  }

}