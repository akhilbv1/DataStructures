import java.util.*
import java.util.function.BinaryOperator
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue

fun main() {
    val ip = "11111111111111111111111111111101"
    //hammingWeight(11)
    println(hammingWeight(11))
    println(hammingWeightFast(11))
}
//4294967293

private fun convertIntToBinary(n: Int): String {
    var result = ""
    var mask = 1
    for (i in 0 until 32) {
        val value = n and mask
        result+="${if(value>0) 1 else 0}"
        mask = mask.shl(1)
    }
    return result
}

private fun hammingWeightFast(n:Int): Int {
    var result = 0
    var ip = n
    while (ip>0) {
        ip = ip and (ip-1)
        result+=1
    }
    return result
}

//T:- O(32)
private fun hammingWeight(n:Int): Int {
    var result = 0
    var mask = 1
    for (i in 0 until 32) {
        if(n and mask!=0) result+=1
        mask = mask.shl(1)
    }//32
    return result
}