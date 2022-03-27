fun main() {
    // make a linked list
    var head = Node(2)
    head.next = Node(4)
    head.next?.next = Node(6)
    head.next?.next?.next = Node(8)
    head.next?.next?.next?.next = Node(10)

    println("#1 Reverse a linked list")
    head.print()
    val reverse = reverse(head)
    reverse?.print()
}

fun reverse(head: Node): Node? {
    var current: Node? = head
    var previous: Node? = null
    while(current != null) {
        val temp = current.next
        current.next = previous
        previous = current
        current = temp
    }
    return previous
}

// []->[]->[]
// ^c  ^n
// []<-[]->[]

// []<-[]<-[]