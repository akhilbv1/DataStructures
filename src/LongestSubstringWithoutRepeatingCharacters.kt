import kotlin.math.max

fun main() {
    val s = "abcabcbb"
    //val s = "bbbbb"
    //val s = "asu"
    //val s = "dvdf"
    //val s = "qrsvbspk"
    //val s = "bpfbhmipx"
    println(lengthOfLongestSubstring(s))
}

fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    if (s.length == 1) return 1
    val charSet = HashSet<Char>()
    var left = 0
    var result = 0
    for (right in s.indices){
        while (charSet.contains(s[right])){
            charSet.remove(s[left])
            left+=1
        }
        charSet.add(s[right])
        result = max(result,(right - left)+1)
    }
    return result
}
