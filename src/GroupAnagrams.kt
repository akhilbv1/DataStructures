import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

fun main() {
    val str = arrayOf("eat","tea","tan","ate","nat","bat")

    println(groupAnagrams(str))
    println(groupAnagramsFaster(str))
}


fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val skipIndexesHashMap: HashMap<Int, Int> = hashMapOf()
    val groupAnagramsList: MutableList<List<String>> = mutableListOf()

    strs.forEachIndexed { indexI, s ->
        if(skipIndexesHashMap[indexI]==null){
            val anagramsList = mutableListOf<String>()
            anagramsList.add(s)
            strs.forEachIndexed { index, t ->
                if (index != indexI) {
                    if (skipIndexesHashMap[index]==null){
                        val isAnagram = isAnagram(s,t)
                        if(isAnagram){
                            anagramsList.add(t)
                            skipIndexesHashMap[index] = index
                        }
                    }
                }
            }
            groupAnagramsList.add(anagramsList)
        }
    }
    return groupAnagramsList
}

//T:- O(n(sLogs+a));n:-size of strs, s:-size of each string in strs, a:- number of anagrams exist for each string in strs
//S:- O(n+a); n:- number of strings in str, a:- number of group anagrams found in strs.
fun groupAnagramsFaster(strs: Array<String>): List<List<String>> {
    val stringsListHashmap: HashMap<String,MutableList<String>> = hashMapOf()//S:-n
    val groupAnagramsList: MutableList<List<String>> = mutableListOf()//a

    strs.forEachIndexed { _, str ->
        val sortedString = str.toCharArray().sorted().toString() //sLogs
        stringsListHashmap[sortedString]?.let {
            val existingAnagramsList = it
            existingAnagramsList.add(str)//a
            stringsListHashmap[sortedString] = existingAnagramsList
        }?: run {
            stringsListHashmap[sortedString] = mutableListOf(str)
        }
    }//n

    stringsListHashmap.forEach {
        groupAnagramsList.add(it.value)
    }//n

    return groupAnagramsList
}


/*//T:- O(n(sLogs+a));n:-size of strs, s:-size of each string in strs, a:- number of anagrams exist for each string in strs
//S:- O(n+a); n:- number of strings in str, a:- number of group anagrams found in strs.
fun groupAnagramsFastest(strs: Array<String>): List<List<String>> {
    val stringsListHashmap: HashMap<String,MutableList<String>> = hashMapOf()//S:-n
    val groupAnagramsList: MutableList<List<String>> = mutableListOf()//a

    strs.forEachIndexed { _, str ->
        val sortedString = CharArray(26)
        str.forEach {
            val int:Int = it.code-'a'.code
            sortedString[int]+=1
        }
        val newString = sortedString.toString()

        stringsListHashmap[newString]?.let {
            it.add(str)
        }?: run {
            stringsListHashmap[newString] = mutableListOf()
        }
    }//n


    stringsListHashmap.forEach {
        groupAnagramsList.add(it.value)
    }//n

    return groupAnagramsList
}*/


//T:-O(n)
//S:-O(n)
fun isAnagram(s: String, t: String): Boolean {
    if (t.length != s.length) return false
    val sHash = hashMapOf<Char, Int>()
    s.forEach {
        sHash[it]?.let { count: Int ->
            sHash[it] = count + 1
        } ?: run {
            sHash[it] = 1
        }
    }//s
    t.forEach {
        sHash[it]?.let { count: Int ->
            sHash[it] = count - 1
        } ?: run {
            return false
        }
    }
    sHash.forEach {
        if (it.value != 0) return false
    }//t
    return true
}