import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val target = 12
    val position = intArrayOf(10,8,0,5,3)
    val speed = intArrayOf(2,4,1,1,3)
    print(carFleet(target, position, speed))
}

private fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    if (position.size == 1) return  1
    val carFleetStack: Stack<Double> = Stack()
    val carFleetPair: ArrayList<Pair<Int, Int>> = arrayListOf<Pair<Int, Int>>().also {
        position.forEachIndexed { index, i ->
            it.add(Pair(i, speed[index]))
        }
    }
    println(3/2)
    carFleetPair.sortBy { it.first }
    for (i in carFleetPair.lastIndex downTo 0) {
        val currentTime: Double =( target.toDouble() - carFleetPair[i].first.toDouble() )/ carFleetPair[i].second.toDouble()
        if (!(carFleetStack.isNotEmpty() && currentTime <= carFleetStack.peek())) {
            carFleetStack.push(currentTime)
        }
    }
    return carFleetStack.size
}
