class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addNode(node: ListNode, head: ListNode?): ListNode? {
    var currentNode: ListNode? = head
    if (head == null) {
        return node
    }
    while (currentNode?.`val` != null) {
        val temp = currentNode.next
        if (currentNode?.next == null) {
            currentNode?.next = node
        }
        currentNode = temp
    }
    return head
}

fun addNodeAndReturnLast(node: ListNode?, head: ListNode?): ListNode? {
    var currentNode: ListNode? = head
    if (head == null) {
        return node
    }
    while (currentNode?.`val` != null) {
        val temp = currentNode.next
        if (currentNode?.next == null) {
            currentNode?.next = node
        }
        currentNode = temp
    }
    return node
}