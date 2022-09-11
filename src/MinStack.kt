import kotlin.math.min
/*["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
[    [],      [-10],  [14],   [],        []    [-20],   [],      [],     [],    [],     [],  [10],  [-7],   [],     [-7],   [],  [],    [],      []]*/

fun main() {
    val minStack = MinStack()
    minStack.push(-10)
    minStack.push(14)
    minStack.getMin()
    minStack.getMin()
    minStack.push(-20) // return -3
    minStack.getMin()
    minStack.getMin()
    minStack.top()
    minStack.getMin()
    minStack.pop()
    minStack.push(10)
    minStack.push(-7)
    minStack.getMin()
    minStack.push(-7)
    minStack.pop()
    minStack.top()
    minStack.getMin()
    minStack.pop()
}


class MinStack {
    private var currentTopIndex: Int = 0
    private var stackHashMap: HashMap<Int, Pair<Int,Int>> = hashMapOf()
    private var isDebug = true

    fun push(`val`: Int) {
        val minValue = stackHashMap[currentTopIndex - 1]?.second ?: Int.MAX_VALUE
        stackHashMap[currentTopIndex] = Pair(`val`, min(minValue,`val`))//1
        currentTopIndex += 1
        if(isDebug) println("Push$`val`:- $stackHashMap")
    }

    fun pop() {
        stackHashMap.remove(currentTopIndex - 1)//1
        if (currentTopIndex > 0) {
            currentTopIndex -= 1
        } else {
            currentTopIndex = 0
        }
        if(isDebug) println("Pop:$stackHashMap")
    }

    fun top(): Int {
        if(isDebug) println("Top: ${stackHashMap[currentTopIndex - 1]?.first ?: -1}")//1
        return stackHashMap[currentTopIndex - 1]?.first ?: -1
    }

    fun getMin(): Int {
        if(isDebug) println("Min:- $stackHashMap ${stackHashMap[currentTopIndex - 1]?.second ?: -1}")//1
        return stackHashMap[currentTopIndex - 1]?.second ?: -1
    }
}