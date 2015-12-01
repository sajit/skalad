package misc.sudoku

/**
 * Created by sajit on 1/1/15.
 */
trait Cell {

}
case class EmptyCell(possible:List[Int]) extends Cell
case class ValueCell(value:Int) extends Cell

