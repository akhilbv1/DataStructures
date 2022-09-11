import java.util.*
import kotlin.math.abs

fun main() {
    val ip = arrayOf("3","11","5","+","-")
    println(evalRPN(ip))
}

fun evalRPN(tokens: Array<String>): Int {
    val tokenStack: Stack<Int> = Stack()
    tokens.forEach {  s ->//n
        s.toIntOrNull()?.let {
            tokenStack.push(it)
        } ?: run {
            val charAtIndex = s[0]
            val v1 = tokenStack.pop()
            val v2 = tokenStack.pop()
            tokenStack.push(performOperation(v2, v1, charAtIndex))
        }
    }
    return tokenStack.peek()
}

fun performOperation(a: Int, b: Int, operation: Char): Int {
   return when(operation) {
        '+' -> a+b
        '-' -> a-b
        '*' -> a*b
        '/' -> a/b
       else -> Int.MAX_VALUE
    }
}