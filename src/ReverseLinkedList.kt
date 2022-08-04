fun main() {
    printLinkedList(reverseList(getLinkedList()))
}

private fun getLinkedList(): ListNode? {
    val head = ListNode(10)
    val one = ListNode(11)
    val two = ListNode(12)
    val three = ListNode(13)

    head.next = one
    one.next = two
    two.next = three

    return head
}

fun reverseList(head: ListNode?): ListNode? {
    var currentNode: ListNode? = head
    var tempNode:ListNode? = currentNode
    var prevNode: ListNode? = null
    while (tempNode?.`val` != null) {
        tempNode = currentNode?.next
        currentNode?.next = prevNode
        prevNode = currentNode
        currentNode = tempNode
    }
    return prevNode
}