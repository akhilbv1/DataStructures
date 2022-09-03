import kotlin.collections.ArrayList

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val tree = getDummyTree()
    //breadthFirstSearchRecursive(tree)
    dfsInOrderR(tree)
    dfsPreOrder(tree)
    dfsPostOrder(tree)
}


fun getDummyTree(): TreeNode {
    val root = TreeNode(4)

    val l1 = TreeNode(2)
    l1.left = TreeNode(1)
    l1.right = TreeNode(3)

    val l2 = TreeNode(7)
    l2.left = TreeNode(6)
    l2.right = TreeNode(9)

    root.left = l1
    root.right = l2
    return root
}

fun breadthFirstSearch(treeNode: TreeNode?): TreeNode? {
    var current: TreeNode? = treeNode
    val treeList: ArrayList<Int?> = arrayListOf()
    val queue = arrayListOf<TreeNode?>()
    queue.add(current)
    while (queue.size > 0) {
        current = queue.removeAt(0)
        print("${current?.`val`} ")
        treeList.add(current?.`val`)
        current?.left?.let {
            queue.add(it)
        }
        current?.right?.let {
            queue.add(it)
        }
    }
    return current
}


fun breadthFirstSearchRecursive(treeNode: TreeNode?) {
    bfsRecursive(arrayListOf<TreeNode?>(treeNode), arrayListOf())
}

fun bfsRecursive(queue: ArrayList<TreeNode?>, treeList: ArrayList<Int?>): ArrayList<Int?> {
    if (queue.isEmpty()) {
        return treeList
    }

    val current: TreeNode? = queue.removeAt(0)
    print("${current?.`val`} ")
    treeList.add(current?.`val`)
    current?.left?.let {
        queue.add(it)
    }
    current?.right?.let {
        queue.add(it)
    }

    return bfsRecursive(queue, treeList)
}

fun dfsInOrderR(treeNode: TreeNode?) {
    println("In:- ${traverseInOrder(treeNode, arrayListOf())}")
}

fun dfsPreOrder(treeNode: TreeNode) {
    println("Pre:- ${traversePreOrder(treeNode, arrayListOf())}")
}

fun dfsPostOrder(treeNode: TreeNode?) {
    println("Post:- ${traversePostOrder(treeNode, arrayListOf())}")
}

fun traverseInOrder(treeNode: TreeNode?, treeList: ArrayList<Int?>): ArrayList<Int?> {
    //print("${treeNode?.`val`} ${treeList.toList()}  ")
    treeNode?.left?.let {
        traverseInOrder(it, treeList)
    }
    treeList.add(treeNode?.`val`)
    treeNode?.right?.let {
        traverseInOrder(it, treeList)
    }
    return treeList
}

fun traversePostOrder(treeNode: TreeNode?, treeList: ArrayList<Int?>): ArrayList<Int?> {
    //print("${treeNode?.`val`}  ")
    treeNode?.left?.let {
        traversePostOrder(it, treeList)
    }
    treeNode?.right?.let {
        traversePostOrder(it, treeList)
    }
   // print("add(${treeNode?.`val`})")
    treeList.add(treeNode?.`val`)
    return treeList
}

fun traversePreOrder(treeNode: TreeNode, treeList: ArrayList<Int?>): ArrayList<Int?> {
    /*print("${treeNode?.`val`}  ")
    print("add(${treeNode?.`val`})")*/
    treeList.add(treeNode.`val`)
    treeNode.left?.let {
        traversePreOrder(it, treeList)
    }
    treeNode.right?.let {
        traversePreOrder(it, treeList)
    }
    return treeList
}
