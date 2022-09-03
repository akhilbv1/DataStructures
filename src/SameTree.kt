fun main() {
    println(isSameTree(getSameDummyTree1(),getSameDummyTree2()))
}


fun getSameDummyTree1(): TreeNode{
    val root = TreeNode(10)

    val l1 = TreeNode(5)

    val l2 = TreeNode(15)


    root.left = l1
    root.right = l2
    return root
}

fun getSameDummyTree2(): TreeNode{
    val root = TreeNode(10)

    val l1 = TreeNode(5)
    l1.right = TreeNode(15)

    root.left = l1
    root.right = null
    return root
}


fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    var currentPNode = p
    var currentQNode = q
    val pQueue: ArrayList<TreeNode?> = arrayListOf()
    val qQueue: ArrayList<TreeNode?> = arrayListOf()
    qQueue.add(currentQNode)
    pQueue.add(currentPNode)

    while (pQueue.size > 0 && qQueue.size > 0) {
        currentPNode = pQueue.removeAt(0)
        currentQNode = qQueue.removeAt(0)


        if(currentPNode?.`val`!= currentQNode?.`val`) {
            return false
        }

        if(currentPNode?.left!=null && currentQNode?.left==null) return false
        if(currentPNode?.left==null && currentQNode?.left!=null) return false
        if(currentPNode?.right==null && currentQNode?.right!=null) return false
        if(currentPNode?.right!=null && currentQNode?.right==null) return false

        if (currentPNode?.left!=null && currentQNode?.left!=null){
            pQueue.add(currentPNode.left)
            qQueue.add(currentQNode.left)
        } 


        if (currentPNode?.right!=null && currentQNode?.right!=null){
            pQueue.add(currentPNode.right)
            qQueue.add(currentQNode.right)
        }

    }

    if(pQueue.size > 0) return false

    if(qQueue.size > 0) return false

    return true
}