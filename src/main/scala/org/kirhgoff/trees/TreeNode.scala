package org.kirhgoff.trees

/**
  * Created by kirilllastovirya on 23/04/2016.
  */
class TreeNode (var parent:TreeNode, var left:TreeNode, var right:TreeNode, var value:Any) {
  def addLeft (left:TreeNode): Unit = {
    this.left = left
    this.left.parent = this
  }

  def addRight (right:TreeNode): Unit = {
    this.right = right
    this.right.parent = this
  }

  def next(traversal: BinaryTreeTraversal) = traversal.next (this)

  override def toString:String = if (value != null) value.toString else "null"
}

object TreeNode {
  def apply (parent:TreeNode, left:TreeNode, right:TreeNode, value:Any) = {
    new TreeNode(parent, left, right, value)
  }

  def apply(value:Any) : TreeNode = apply(null, null, null, value)
  def apply(left:TreeNode, right:TreeNode, value:Any) : TreeNode = apply(null, left, right, value)
}

trait BinaryTreeTraversal {
  def next (node:TreeNode):TreeNode
  def leftMost (node: TreeNode) : TreeNode = node.left match {
    case null => node
    case _ => leftMost(node.left)
  }
  def isLeft(node: TreeNode) = node.parent != null && node.parent.left == node
}

/** In-order: first left, then parent, then right **/
object InOrderTraversal extends BinaryTreeTraversal {
  override def next(node: TreeNode): TreeNode = {
    if (node.right != null) leftMost (node.right)
    else if (isLeft(node)) node.parent
    //TODO quick fix
    node
  }
}

object BstBuilder {
  def add(tree:TreeNode, node:TreeNode):TreeNode = {
    tree //TODO
  }
}

object SampleTrees {
  def balancedTree1 = {
    TreeNode(
      TreeNode(
        TreeNode("d"),
        TreeNode(TreeNode("i"), TreeNode("h"), "e"),
        "b"
      ),
      TreeNode(TreeNode("f"), TreeNode("g"), "c"),
      "a"
    )
  }

}




