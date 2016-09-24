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
  def traverse(order: TraverseOrder, visitor: NodeVisitor):Unit = {
    visitor.enter(this)
    order match {
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
    visitor.exit(this)
  }
}

object Node {
  def apply(value:Long, left:Node, right:Node) = new Node(value, left, right)
  def apply(value:Long) = new Node(value, null, null)
}

trait NodeVisitor {
  def enter(node:Node):Unit
  def visit(node:Node):Unit
  def exit(node:Node):Unit
}

object BinaryTreeDepth {
  def main(args: Array[String]): Unit = {
    val tree = Node(1, Node(2, Node(3), Node(4)), Node(5, Node(6, Node(7), Node(8)), Node(9)))

    val visitor = new  NodeVisitor {
      var level = 0

      override def enter(node: Node): Unit = {
        level = level + 1
      }

      override def visit(node: Node): Unit = {
        println("\t" * level + node.value)
      }

      override def exit(node: Node): Unit = {
        level = level - 1
      }
    }

    println ("---------- PreOrder ---------------------")
    tree.traverse(TraverseOrder.PreOrder, visitor)
    println ("---------- InOrder ---------------------")
    tree.traverse(TraverseOrder.InOrder, visitor)
    println ("---------- PostOrder ---------------------")
    tree.traverse(TraverseOrder.PostOrder, visitor)

  }
}
