package org.kirhgoff.rosalind

class Nucleotids(val a:Int, val c:Int, val g:Int, val t:Int) {
  def apply(a:Int, c:Int, g:Int, t:Int):Nucleotids = new Nucleotids(a, c, g, t)
  def addA():Nucleotids = apply(a+1, c, g, t)
  def addC():Nucleotids = apply(a, c+1, g, t)
  def addG():Nucleotids = apply(a, c, g+1, t)
  def addT():Nucleotids = apply(a, c, g, t+1)

  override def toString = s"A=$a, C=$c, G=$g, T=$t"
}


/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
object CountingDNANucleotides {
  val stream = getClass.getResourceAsStream("/rosalind1/rosalind_dna.txt")
  val line = scala.io.Source.fromInputStream(stream).getLines().next()

  println(line.toList.foldLeft(new Nucleotids(0,0,0,0))((result, current) => current match {
    case 'A' => result.addA()
    case 'C' => result.addC()
    case 'G' => result.addG()
    case 'T' => result.addT()
  }))
}
