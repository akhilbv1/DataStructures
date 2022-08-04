import kotlin.math.max

fun main() {
    //val s = "ABAB"
    //val k = 2
    //val s = "ABAA"
    //val k = 0
    val s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF"
    val k = 4
   // println(characterReplacement(s, k))
    testP()
    println("testp out ")
}

fun testP(){
    for (i in 0..100){
        println("testP$i")
    }
}

fun characterReplacement(s: String, k: Int): Int{
    var left = 0
    val maxCharCountInWindow = hashMapOf<Char,Int>()
    var result = 0

    for (right in s.indices){
        maxCharCountInWindow[s[right]]?.let {
            maxCharCountInWindow[s[right]] = it+1
        }?: run {
            maxCharCountInWindow[s[right]] = 1
        }
        var windowLength = (right-left)+1
        while ((windowLength - maxCharCountInWindow.maxBy { it.value }!!.value) > k){
            maxCharCountInWindow[s[left]]?.let {
                if(it>0){
                    maxCharCountInWindow[s[left]] = it-1
                }
            }
            left+=1
            windowLength = (right-left)+1
        }
        result = max(result,windowLength)
    }

    return result
}