fun main(){
    //shiftLeft()
    //shiftRight()
    //bitOr()
    //bitInv()
    println(2.or(1))
}

private fun bitInv() {
    val x = 78
    println(x.inv())
    println(x-256)
}

private fun bitOr() {
    val x = 78
    val y = 118
    println(x.or(y))
}

private fun shiftRight() {
    val x = 84
    var a = x
    for ( i in 1..4){
        println(x.shr(i))
        a /= 2
        println(a)
    }
}

private fun shiftLeft() {
    val x = 84
    for (i in 1..4){
        println(x.shl(i))
        println(x*Math.pow(2.toDouble(),i.toDouble()))
    }
}