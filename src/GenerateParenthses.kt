import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val n = 3
    val op = generateParenthesis(n)
    println(op.toList())
}


/**
 *  open == close == n
 *  to add close :- closeCount < openCount
 *  to add open:- open == close and open < n
 *  base :- open = close == n
 */
fun generateParenthesis(n: Int): List<String> {
    return backTrackParenthesis(Stack<String>(), arrayListOf(), 0, 0, n)
}

fun backTrackParenthesis(
    parenStack: Stack<String>,
    result: ArrayList<String>,
    openCount: Int,
    closeCount: Int,
    n: Int
): List<String> {
    if (closeCount == n && openCount == n) {
        var res = ""
        parenStack.forEach {
            res += it
        }
        result.add(res)
        return result
    }

    if (openCount < n) {
        parenStack.push("(")
        backTrackParenthesis(parenStack, result, openCount + 1, closeCount, n)
        parenStack.pop()
    }

    if (closeCount < openCount) {
        parenStack.push(")")
        backTrackParenthesis(parenStack, result, openCount, closeCount + 1, n)
        parenStack.pop()
    }

    return result
}