fun main(){
    println("Product Viewed Test".getStandardEventName())
}

private fun String.getStandardEventName() = replace(" ","_").toLowerCase()
