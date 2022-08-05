fun main() {
    val ip = intArrayOf(1, 2, 3, 4)
    val ip1 = intArrayOf(1, 2, 3, 4, 5, 6)
    printLinkedList(mergeTwoLists(getLinkedList(ip), getLinkedList(ip1)))
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var l1 = list1
    var l2 = list2
    val dummy = ListNode(0)
    var tail: ListNode? = dummy
    while (l1?.`val` != null && l2?.`val` != null) {
        if (l1.`val` < l2.`val`) {
            tail?.next = l1
            l1 = l1.next
        } else {
            tail?.next = l2
            l2 = l2.next
        }
        tail = tail?.next
    }

    if (l1?.`val` != null) {
        tail?.next = l1
    } else if (l2?.`val` != null) {
        tail?.next = l2
    }

    return dummy.next
}

