package org.kirhgoff.hackerrank

/*
class Treap (val x:Int, val y:Int, var left:Treap, var right:Treap) {

  def split(x:Int) : (Treap, Treap) = {
    var resultLeft:Treap = this.left
    var resultRight:Treap = this.right

//    if (this.x <= x) {
//      if (this.right == null) resultRight = null
//      else (resultLeft, resultRight) = this.right.split(x)
//
//      resultLeft = new Treap(this.x, this.y, this.left, resultLeft)
//    } else {
//      if (this.left == null) resultLeft = null
//      else (resultLeft, resultRight) = this.left.split(x)
//      resultRight = new Treap(this.x, this.y, resultLeft, this.right)
//    }
    (resultLeft, resultRight)
  }
}

//TODO make tail recursion
object Treap {
  def merge(left:Treap, right:Treap): Treap = {
    if (left == null) return right
    if (right == null) return left

    if (left.y > right.y) new Treap(left.x, left.y, left.left, merge(left.right, right))
    else new Treap(right.x, right.y, merge(left, right.left), right.right)
  }

}

*/

/**
 * https://www.hackerrank.com/challenges/array-and-simple-queries
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
object ArrayAndSimpleQueries {
  def main(args: Array[String]) {

    val pf: PartialFunction[Int, Int] = {
      case i: Int ⇒ i + 1
    }
    println (pf)
    println ({case i: Int ⇒ i + 1})

    val result = List(41, "cat") collect { case i: Int ⇒ i + 1 }
    println (result)
    println "fsdf"
  }
}
