package org.kirhgoff.euler

import java.io.InputStream

/**
 * Using names.txt (right click and 'Save Link/Target As...'),
 * a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position
 * in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order,
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
 * is the 938th name in the list. So, COLIN would
 * obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
object Euler22 {
  val asStream: InputStream = getClass.getResourceAsStream("/euler22/p022_names.txt")
  val text = io.Source.fromInputStream(asStream).mkString
  val namesList = text.trim.split(",").map(name => name.replace("\"", "")).toList.sorted

  def score(name: String) = name.toList.map(ch => ch.getNumericValue - 9).sum

  val scoreList = namesList.zipWithIndex.map(pair => (pair._1, pair._2 + 1, score(pair._1)))
  val result = scoreList.map(sc => sc._2 * sc._3).sum

  println (scoreList.filter(p => p._1.equals("COLIN")).mkString("\n"))
  println ("Result: " + result)
}
