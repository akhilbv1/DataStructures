import kotlin.math.min

fun main() {
    val timeMap = TimeMap()
    timeMap.set("foo", "bar", 1) // store the key "foo" and value "bar" along with timestamp = 1.

    println(timeMap.get("foo", 1)) // return "bar"

    println(timeMap.get("foo", 3))

    timeMap.set("foo", "bar2", 4) // store the key "foo" and value "bar2" along with timestamp = 4.

    println(timeMap.get("foo", 4)) // return "bar2"

    println(timeMap.get("foo", 5) ) // return "bar2"

}


class TimeMap() {
    private val timeHashMap: HashMap<String, ArrayList<Pair<String, Int>>> = hashMapOf()

    fun set(key: String, value: String, timestamp: Int) {
        timeHashMap[key]?.let {
            val list = it
            list.add(Pair(value, timestamp))
            timeHashMap[key] = list
        } ?: kotlin.run {
            timeHashMap[key] = arrayListOf(Pair(value, timestamp))
        }
    }

    fun get(key: String, timestamp: Int): String {
        val mapListKey = timeHashMap[key]
        var result = ""
        mapListKey?.let {
            var left = 0
            var right = it.lastIndex
            while (left <= right) {
                val mid = (left + right) / 2
                if (it[mid].second <= timestamp) {
                    result = it[mid].first
                    left = mid + 1
                } else right = mid - 1
            }
        }
        return result
    }
}