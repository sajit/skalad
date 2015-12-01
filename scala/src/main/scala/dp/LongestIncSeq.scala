package dp

import scala.collection.mutable.MutableList

/**
 * Created by sajit on 10/26/14.
 */
class LongestIncSeq(val in:List[Int]) {

  def lndsLen():Int = {
    val l:MutableList[Int]  = MutableList.fill(in.length){1}

    for(i <- 1 to in.length-1){
      for(j <- 0 to i){
        val lij = if(in(j) < in(i)){
          l(j) + 1
        }else{0}
        l(i) = Math.max(l(i),lij)
      }
    }
    l.max


  }

}
