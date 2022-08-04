import java.io.File
import java.util.*

fun main() {
    val scanner = Scanner(File("src/data"))
    val s = "A man, a plan, a canal: Panama"
    //val s = "race a car"
    //val s = scanner.nextLine()
   // val s = " "

    print(isPalindrome(s))
    print(isPalindromeFaster(s))
}

//T:-n S:n
fun isPalindromeFaster(s: String): Boolean {
    //val timeStarted = System.currentTimeMillis()
    var palindromeString = s
    s.forEach {
        if (it.isLetter() || it.isDigit()) {
            //palindromeString += it.toLowerCase()
        }else {
            val index = s.indexOf(it)
            palindromeString = s.replace(s[index].toString(),"")
        }
    }
    println(palindromeString)
    /*var p1 = 0
    var p2 = palindromeString.lastIndex
    if(palindromeString.isEmpty()) return true
    while (p1 != p2) {
        if (palindromeString[p1] != palindromeString[p2]) {
            return false
        } else {
            p1 += 1
            p2 -= 1
            if (p1 > palindromeString.lastIndex || p2 < 0)
                break
        }
    }*/
    return true
}

//T:-n S:n
fun isPalindrome(s: String): Boolean {
    //val timeStarted = System.currentTimeMillis()
    var palindromeString = ""
    s.forEach {
        if (it.isLetter() || it.isDigit()) {
            palindromeString += it.toLowerCase()
        }
    }
    var p1 = 0
    var p2 = palindromeString.lastIndex
    if(palindromeString.isEmpty()) return true
    while (p1 != p2) {
        if (palindromeString[p1] != palindromeString[p2]) {
            return false
        } else {
            p1 += 1
            p2 -= 1
            if (p1 > palindromeString.lastIndex || p2 < 0)
                break
        }
    }
    return true
}
