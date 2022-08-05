fun main() {
    val ip = intArrayOf(10, 11, 12, 13, 13)
    printLinkedList(reverseList(getLinkedList(ip)))
}

fun reverseList(head: ListNode?): ListNode? {
    var currentNode: ListNode? = head
    var tempNode: ListNode? = currentNode
    var prevNode: ListNode? = null
    while (tempNode?.`val` != null) {
        tempNode = currentNode?.next
        currentNode?.next = prevNode
        prevNode = currentNode
        currentNode = tempNode
    }
    return prevNode
}