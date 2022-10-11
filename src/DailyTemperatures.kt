import java.util.*

fun main() {
    val temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    println(dailyTemperatures(temperatures).toList())
}


private fun dailyTemperatures(temperatures: IntArray): IntArray {
    val tempStack: Stack<Pair<Int, Int>> = Stack()
    val outputArray = IntArray(temperatures.size) { 0 }
    temperatures.forEachIndexed { index, i ->
        if (tempStack.isEmpty()) {
            tempStack.push(Pair(i, index))
        } else {
            if(tempStack.peek().first > i) {
                tempStack.push(Pair(i,index))
            } else {
                while (tempStack.isNotEmpty() && tempStack.peek().first < i) {
                    val poppedTempValue = tempStack.pop()
                    outputArray[poppedTempValue.second] = index -  poppedTempValue.second
                }
                tempStack.push(Pair(i,index))
            }
        }
    }
    return outputArray
}