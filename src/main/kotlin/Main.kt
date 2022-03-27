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

    head = Node(1)
    head.next = Node(2)
    head.next?.next = Node(3)
    head.next?.next?.next = Node(4)
    head.next?.next?.next?.next = Node(5)
    println("#1 Reverse a subset linked list")
    head.print()
    val reverseSubset = reverseSubset(head, 1, 4)
    reverseSubset.print()
}

/*
    Given the head of a LinkedList and two positions ‘p’ and ‘q’,
    reverse the LinkedList from position ‘p’ to ‘q’.
 */
fun reverseSubset(head: Node, p: Int, q: Int): Node {
    // traverse p-1 times
    var result = head
    var count = 1
    var current: Node? = head
    var previous: Node? = null
    while(count < p) {
            if(current?.next != null) {
                previous = current
                current = current.next!!
            } else return head // p is out of bounds
            count++
    }
    val start = previous
    val pNode = current
    previous = current
    if(current?.next != null) current = current.next!!
    else return head // p is last element

    while(count < q && current != null) {
        val temp = current.next
        current.next = previous
        pNode?.next = temp
        previous = current
        current = temp
        count++
    }
    if(start!= null) start.next = previous
    else result = previous ?: head
    return result
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