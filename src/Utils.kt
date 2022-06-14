
fun printIntArray(ip:IntArray?){
    ip?.let {
        if(it.isEmpty()) print("[]")
        else {
            print("[")
            val lastElement = it.last()
            it.forEach {item:Int->
                print(item)
                if(item!=lastElement){
                    print(",")
                }
            }
            println("]")
        }
    }?: print(null)
}