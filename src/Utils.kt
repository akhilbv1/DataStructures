import com.sun.source.tree.Tree

fun printIntArray(ip: IntArray?) {
    ip?.let {
        if (it.isEmpty()) print("[]")
        else {
            print("[")
            val lastElement = it.last()
            it.forEach { item: Int ->
                print(item)
                if (item != lastElement) {
                    print(",")
                }
            }
            println("]")
        }
    } ?: print(null)
}

fun getLinkedList(intArray: IntArray): ListNode? {
    if (intArray.isEmpty()) return null
    val head = ListNode(intArray[0])
    var current = head
    for (index in 1..intArray.lastIndex) {
        val newNode = ListNode(intArray[index])
        current.next = newNode
        current = newNode
    }
    return head
}

fun printLinkedList(head: ListNode?) {
    var currentNode = head
    while (currentNode?.`val` != null) {
        if (currentNode?.next == null) {
            print("${currentNode.`val`}->null")
        } else {
            print("${currentNode.`val`}->")
        }
        currentNode = currentNode?.next
    }
}

fun printTree(root: TreeNode?) {
    var current: TreeNode? = root
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
}
