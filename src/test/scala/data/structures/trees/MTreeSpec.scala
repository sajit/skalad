package data.structures.trees

import org.scalatest._

/**
 * Created by sajit on 9/25/14.
 */
class MTreeSpec extends FlatSpec with Matchers{

  it should "create have two constructors" in {
    val mt1 = MTree("d")
    val mt2 = MTree("d",List())

    mt1 should be eq(mt2)
  }

}
