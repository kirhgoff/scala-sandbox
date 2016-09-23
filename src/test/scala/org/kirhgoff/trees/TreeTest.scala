package org.kirhgoff.trees

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by kirilllastovirya on 23/04/2016.
  */
class TreeTest extends FlatSpec with Matchers {

    "InOrderTraversal" should "work on simple trees" in {
      val a: TreeNode = TreeNode("a")
      val c: TreeNode = TreeNode("c")
      val b = TreeNode(a, c, "b")

      a.next(InOrderTraversal) should equal(b)
      b.next(InOrderTraversal) should equal(c)
      b.next(InOrderTraversal) should equal(null)
    }

}
