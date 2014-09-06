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
    BumbleBee.toBinary(7).mkString should be("111")
  }

  it should "convert binary to dec" in {
    //BumbleBee.binaryToDec(List('1','0','1')) should be (5)
    BumbleBee.binaryToDec(List('1','0','0','0')) should be (8)
  }

  it should "convert dec to hex" in {
    val dec = 556
    BumbleBee.dec2Hex(dec).mkString should be ("22C")
  }

  it should "convert hex to dec" in {
    BumbleBee.hex2Dec(List('2','2','C')) should be (556)
  }
}
