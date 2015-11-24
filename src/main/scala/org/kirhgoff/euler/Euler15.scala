package org.kirhgoff.euler

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 19/11/15.
 */
object Euler15 {
  class Node(val x:Int, val y:Int, var paths:Long) {
    override def toString = paths.toString()
  }

  def createMatrix(size:Int) = {
    (for (x <- 0 to size) yield
      (for(y <- 0 to size) yield (x, y) match {
        case (a, b) if a == 0 && b == 0 => new Node(a, b, 0)
        case (a, b) if a == 0 || b ==0 => new Node(x, y, 1)
        case (a, b) => new Node(a, b, 0)
      }).toList).toList
  }

  def proceed(matrix:List[List[Node]]) = {
    val size = matrix.length
    for (x <- 1 to size-1; y <- 1 to size-1) {
      val nodeAbove = matrix(x)(y-1)
      val nodeLeft = matrix(x-1)(y)
      val node = matrix(x)(y)
      node.paths = nodeAbove.paths + nodeLeft.paths
    }
    matrix(size-1)(size-1)
  }

  println(proceed(createMatrix(20)))
}
