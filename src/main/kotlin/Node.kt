data class Node(
    var value: Int,
    var next: Node? = null
) {
    fun print() {
        var temp: Node? = this
        while(temp != null) {
            print("${temp.value} -> ")
            temp = temp.next
        }
        println()
    }
}
