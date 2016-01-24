package org.kirhgoff.numbers

/**
 * Created by Kirill Lastovirya (kirill.lastovirya@gmail.com) aka kirhgoff on 24/01/16.
 */
object Arrays {
  def reverse(array:Array[Byte], from:Int, to:Int):Unit = {
    if (from == to) return
    var i = from
    var j = to

    var temp:Byte = 0
    while(j >= i) {
      temp = array(i)
      array(i) = array(j)
      array(j) = temp
      i += 1
      j -= 1
    }
  }

  def reverse(array:Array[Byte], from:Int):Unit = reverse(array, from, array.length - 1)

  def swap(array:Array[Byte], from:Int, to:Int) = {
    val temp = array(from)
    array(from) = array(to)
    array(to) = temp
  }

  //https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order

  def permutate(index:Long, array:Array[Byte]):Unit = permutate(-1, index, array)

  def permutate(cutIndex:Long, index:Long, array:Array[Byte]):Unit = {
    //if (index % 1000 == 0)
    //println(s"index=$index array=${array.mkString("")}")

    var largest = -1
    var k = 0
    //Step 1: find largest k that a[k]<a[k+1]
    while(k < array.length - 1) {
      if (array(k) < array(k+1)) {
        largest = k
      }
      k += 1
    }
    k = largest

    //End of the story?
    if (k == -1) return

    //Step 2: find l
    largest = -1
    var l = k+1
    while(l < array.length) {
      if (array(k) < array(l)) {
        largest = l
      }
      l += 1
    }
    l = largest

    //Step 3: swap a[k], a[l]
    swap(array, k, l)

    //Step 4: reverse the sequence from a[k+1]
    reverse(array, k+1)

    if (index != cutIndex) permutate(cutIndex, index + 1, array)
  }

}
