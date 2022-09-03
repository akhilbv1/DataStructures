import kotlin.math.max

fun main(){
    println(maxDepth(getDummyDepthTree()))
    val count = Faster().maxDepth(getDummyDepthTree())
    print(count)
}

private fun getDummyDepthTree():TreeNode {
    val root = TreeNode(3)

    val l1 = TreeNode(9)

    val l2 = TreeNode(20)
    l2.left = TreeNode(15)
    l2.right = TreeNode(7)

    root.left = l1
    root.right = l2
    return root
}

class Faster {
     fun maxDepth(root: TreeNode?): Int {
        if (root==null) return 0

        return 1 + max(maxDepth(root.left),maxDepth(root.right))
    }
}


private fun maxDepth(treeNode: TreeNode?): Int {
    if (treeNode==null) return 0
    val list = traverseMaxDepth(treeNode, arrayListOf(),1)
    return list.maxBy { it }?.toInt() ?: 1
}


fun traverseMaxDepth(treeNode: TreeNode?, maxNodes:ArrayList<Int>,currentCount:Int): ArrayList<Int> {
    treeNode?.left?.let {
        traverseMaxDepth(it,maxNodes,currentCount+1)
    } ?: run {
        maxNodes.add(currentCount)
    }

    treeNode?.right?.let {
        traverseMaxDepth(it,maxNodes,currentCount+1)
    }?: run {
        maxNodes.add(currentCount)
    }

    return maxNodes
}