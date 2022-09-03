import com.sun.source.tree.Tree

/**
 *  if a node has left and right then we will invert the two and proceed to next left node.
 */
fun main(){
    printTree(invertTree(getDummyTree()))
}



fun invertTree(treeNode: TreeNode?): TreeNode?{
    return invertTreeR(treeNode)
}

//O(n)
fun invertTreeR(root: TreeNode?): TreeNode?{

    val temp = root?.left
    root?.left = root?.right
    root?.right = temp

    root?.left?.let {
        invertTreeR(it)
    }

    root?.right?.let {
        invertTreeR(it)
    }

    return root
}

//[4,7,2,9,6,3,1]