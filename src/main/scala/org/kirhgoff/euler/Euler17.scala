package org.kirhgoff.euler

import org.kirhgoff.words.Words


object Euler17 {
  val wordsLength = (1 to 1000).map(x => Words(x).replace(" ", "").length).sum
  println(wordsLength)
}

