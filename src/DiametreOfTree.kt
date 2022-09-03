fun main() {
    println(diameterOfBinaryTree(getDummyDiameterTree()))
}

private fun getDummyDiameterTree(): TreeNode {
    val root = TreeNode(9)

    val l1 = TreeNode(4)
    l1.left = TreeNode(1)
    l1.right = TreeNode(6)

    val l2 = TreeNode(20)
    l2.left = TreeNode(15)
    l2.right = TreeNode(100)

    root.left = l1
    root.right = l2
    return root
}

fun diameterOfBinaryTree(root: TreeNode?): Int {
    val leftCount = getLeftMostCount(root, arrayListOf())
    val rightCount = getRightMostCount(root, arrayListOf())
    return (leftCount+rightCount)
}


fun getLeftMostCount(treeNode: TreeNode?, leftMostNodesList: ArrayList<Int>): Int{
    treeNode?.left?.let {
        leftMostNodesList.add(it.`val`)
        getLeftMostCount(it, leftMostNodesList)
    }

    return leftMostNodesList.size
}

fun getRightMostCount(treeNode: TreeNode?, rightMostNodesList: ArrayList<Int>): Int{
    treeNode?.right?.let {
        rightMostNodesList.add(it.`val`)
        getRightMostCount(it, rightMostNodesList)
    }

    return rightMostNodesList.size
}