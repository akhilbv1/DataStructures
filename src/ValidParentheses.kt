import java.util.*
import kotlin.collections.HashMap

fun main() {
   // val s = "()[]{}"
    val s = "{({)}}"
    println(isValid(s))
}

fun isValid(s: String): Boolean {
    val charStack: Stack<Char> = Stack()
    val countHashMap: HashMap<Char, Char> = hashMapOf()
    countHashMap[')'] = '('
    countHashMap['}'] = '{'
    countHashMap[']'] = '['

    s.forEach {
        countHashMap[it]?.let { openChar: Char ->
            if(charStack.isNotEmpty() && charStack.peek()==openChar){
                charStack.pop()
            }else {
                return false
            }
        }?: run {
            charStack.push(it)
        }
    }
    return charStack.isEmpty()
}