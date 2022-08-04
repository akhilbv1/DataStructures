fun main() {
    val ip = listOf("we", "say", ":", "yes")
    val encodedString = encode(ip)
    print(encodedString)
    println()
    print(decode(encodedString).toList())
}

//T:-n S:-1
fun encode(strs: List<String>): String {
    var finalString = ""
    strs.forEach {
        val length = it.length
        val deLimiter = "$length#"
        finalString += "$deLimiter$it"
    }
    return finalString
}

//T:- n + (t(total number of words) * s(length of each word))
fun decode(str: String): List<String> {
    val finalList = mutableListOf<String>()
    val indexHashMap = mutableMapOf<Int,Int>()
    str.forEachIndexed { index, c ->//n
        if (c == '#' && str[index - 1].isDigit()) {
            indexHashMap[index+1] = str[index - 1].toString().toInt()
        }
    }
    indexHashMap.forEach {//t * s(length of each string)
        var finalString = ""
        var startingIndex = it.key
        for (i in 0 until it.value){
            finalString+=str[startingIndex]
            startingIndex+=1
        }
        finalList.add(finalString)
    }
    return finalList
}