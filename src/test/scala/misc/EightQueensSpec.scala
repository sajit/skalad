package misc


import org.scalatest.{Matchers, FlatSpec}
class EightQueensSpec extends FlatSpec with Matchers{

  it should "check Cols" in {
    val eightQueens = new EightQueens(5)

    eightQueens.checkCol(4,2) should be (true)
    eightQueens.modifyQueenPosition(3,2,true)

    eightQueens.checkCol(4,2) should be (false)
  }

  it should "check Cols Init " in {
    val eightQueens = new EightQueens(5)

    eightQueens.checkCol(4, 2) should be(true)
  }

  it should "check fwd diagonals" in {
    val eightQueens = new EightQueens(5)
    eightQueens.checkFwdDiagonal(4,2) should be (true)
    eightQueens.modifyQueenPosition(2,0,true)
    eightQueens.checkFwdDiagonal(4,2) should be (false)

  }

  it should "check backward diagonals" in {
    val eightQueens = new EightQueens(5)
    eightQueens.checkBwdDiagonal(4,2) should be (true)
    eightQueens.modifyQueenPosition(2,4,true)
    eightQueens.checkBwdDiagonal(4,2) should be (false)

  }

  it should "place the queens" in {
    val eightQueens = new EightQueens(5)
    eightQueens.placeQueenOnBoard(0)
  }

}