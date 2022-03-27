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
    println("#2 Reverse a subset linked list")
    head.print()
    val reverseSubset = reverseSubset(head, 2, 4)
    reverseSubset.print()

    head.next?.next?.next?.next?.next = Node(6)
    head.next?.next?.next?.next?.next?.next = Node(7)
    head.next?.next?.next?.next?.next?.next?.next = Node(8)
    println("#3 Reverse every k-element subset linked list")
    head.print()
    val reverseKSubList = reverseKSubset(head, 3)
    reverseKSubList?.print()
}
/*
    Given the head of a LinkedList and a number ‘k’,
    reverse every ‘k’ sized sub-list starting from the head.
 */
fun reverseKSubset(head: Node, k: Int): Node? {
    if(head.next == null) return head

    var current: Node? = head
    var previous: Node? = null
    var resultHead: Node? = head
    while(true) {
        val start = previous
        val last = current
        var count = 0
        while(current != null && count < k) {
            val temp = current.next
            current.next = previous
            previous = current
            current = temp
            count++
        }

        // connect to previous part
        if(start != null) {
            start.next = previous
        } else resultHead = previous

        last?.next = current

        if(current == null) break
        previous = last
    }
    return resultHead
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