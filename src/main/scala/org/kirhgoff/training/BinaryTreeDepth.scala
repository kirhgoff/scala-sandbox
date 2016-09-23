package org.kirhgoff.training

import org.kirhgoff.training.TraverseOrder.TraverseOrder

/**
  * @author <a href="mailto:kirill.lastovirya@moex.com">Kirill Lastovirya</a>
  */

object TraverseOrder extends Enumeration{
  type TraverseOrder = Value
  val PreOrder, InOrder, PostOrder = Value
}

class Node (val value:Long, val left:Node, val right:Node) {
  def traverse(order: TraverseOrder, visitor: NodeVisitor):Unit = order match {
    case TraverseOrder.PreOrder =>
      visitor.visit(this)
      if (left != null) left.traverse(order, visitor)
      if (right != null) right.traverse(order, visitor)

    case TraverseOrder.InOrder =>
      if (left != null) left.traverse(order, visitor)
      visitor.visit(this)
      if (right != null) right.traverse(order, visitor)

    case TraverseOrder.PostOrder =>
      if (left != null) left.traverse(order, visitor)
      if (right != null) right.traverse(order, visitor)
      visitor.visit(this)
  }
}

object Node {
  def apply(value:Long, left:Node, right:Node) = new Node(value, left, right)
  def apply(value:Long) = new Node(value, null, null)
}

trait NodeVisitor {
  def visit(node:Node):Unit
}

object BinaryTreeDepth {
  val tree = Node(1, Node(2, Node(3), Node(4)), Node(5, Node(6, Node(7), Node(8)), Node(9)))

  tree.traverse(TraverseOrder.PreOrder, new NodeVisitor {
    override def visit(node: Node): Unit = {}
  })
}
