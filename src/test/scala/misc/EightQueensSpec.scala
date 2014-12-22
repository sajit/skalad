package misc


import org.scalatest.{Matchers, FlatSpec}
class EightQueensSpec extends FlatSpec with Matchers{

  it should "check Cols" in {
    val eightQueens = new EightQueens(5)

    eightQueens.checkCol(4,2) should be (true)
    eightQueens.placeQueen(3,2)

    eightQueens.checkCol(4,2) should be (false)
  }

  it should "check Cols Init " in {
    val eightQueens = new EightQueens(5)

    eightQueens.checkCol(4, 2) should be(true)
  }

  it should "check fwd diagonals" in {
    val eightQueens = new EightQueens(5)
    eightQueens.checkFwdDiagonal(4,2) should be (true)
    eightQueens.placeQueen(2,0)
    eightQueens.checkFwdDiagonal(4,2) should be (false)

  }

  it should "check backward diagonals" in {
    val eightQueens = new EightQueens(5)
    eightQueens.checkBwdDiagonal(4,2) should be (true)
    eightQueens.placeQueen(2,4)
    eightQueens.checkBwdDiagonal(4,2) should be (false)

  }

}