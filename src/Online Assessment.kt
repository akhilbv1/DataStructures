//0110010
fun main(){
    val ip = "0110010"
    println(minSwaps(ip))
    val ip1 = intArrayOf(3,1,2)
    ip1.copyOf()
    printIntArray(test(ip1))
    test1(ip1)
}

fun test1(ip: IntArray){
    printIntArray(ip)
}

fun test(ip: IntArray): IntArray{
    ip[0] = 1
    val ip2 = ip
    return ip2
}

fun minSwaps(s: String): Int{
    val zero = '0'
    val one = '1'
    var p1 = 0
    var p2 = 1
    var result = 0
    while (p2<=s.lastIndex){
        if(s[p1]==zero){
            p1+=1
            p2+=1
        }else if(s[p1]==one){
            if(s[p2]==one){
                result+=p2-p1
            }
            p2+=1
        }
    }
    return result
}