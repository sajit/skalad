package simple.transformations

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by sajit on 8/27/14.
 */
class MooSpec extends FlatSpec with Matchers {

  it should "decode to same value" in {
    val url = "https://meetup.com"
    val encoded = BumbleBee.encode(url)
    BumbleBee.decode(encoded) should be(url)
  }

  it should "convert dec to binary" in {
    BumbleBee.toBinary(4).mkString should be ("100")
  }

}
