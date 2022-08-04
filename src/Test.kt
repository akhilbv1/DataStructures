fun main(){
    val list = mutableMapOf<String,String>("test" to "1")
    val list1 = mutableMapOf<String,String>()
    list1["test"] = "1"
    val list2 = mutableMapOf<String,String>()
    list2.put("test","1")
    val list3 = mutableMapOf<String,String>(Pair("test","1"))
    println(list.toString())
    println(list1.toString())
    println(list2.toString())
    println(list3.toString())
}