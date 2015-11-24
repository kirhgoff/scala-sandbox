package org.kirhgoff.euler

import java.time.{DayOfWeek, LocalDate}

/**
 * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
 */
object Euler19 {
  val end = LocalDate.parse("2000-12-31")
  val daysSeq = Iterator.iterate(LocalDate.parse("1901-01-01"))(_ plusDays 1) takeWhile(_.isBefore(end))
  val sundaysOnFirst = daysSeq.toList.filter(d => d.getDayOfWeek == DayOfWeek.SUNDAY && d.getDayOfMonth == 1)
  println(sundaysOnFirst.size)
}
