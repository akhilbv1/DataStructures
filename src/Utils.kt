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