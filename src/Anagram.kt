fun main() {
    print(isAnagramSlow("aacc", "ccac"))
    print(isAnagramFaster("aacc", "ccac"))
    print(isAnagramFastest("aacc", "ccac"))
}


//T:- O(nlogn + aloga) or O(nlogn)
//S:- O(n) or O(s+t)
fun isAnagramSlow(s: String, t: String): Boolean {
    if (t.length != s.length) return false
    val sortedT = t.toCharArray()//n
    val sortedS = s.toCharArray()//a
    sortedT.sort()//nlogn
    sortedS.sort()//alogn
    sortedT.forEachIndexed { index, c ->
        val q = sortedS[index]
        if (c != q) {
            return false
        }
    }//n
    return true
}

//T:-O(s+t) or O(n)
//S:-O(s+t) or O(n)
fun isAnagramFaster(s: String, t: String): Boolean {
    if (t.length != s.length) return false
    val sHash = hashMapOf<Char, Int>()
    val tHash = hashMapOf<Char, Int>()
    s.forEach {
        sHash[it]?.let { count: Int ->
            sHash[it] = count + 1
        } ?: run {
            sHash[it] = 1
        }
    }//n

    t.forEach {
        tHash[it]?.let { count: Int ->
            tHash[it] = count + 1
        } ?: run {
            tHash[it] = 1
        }
    }//a
    sHash.forEach {
        tHash[it.key]?.let { tvalue: Int ->
            if (tvalue != it.value) {
                return false
            }
        } ?: run {
            return false
        }
    }//n
    return true
}

//O(s+t) or O(n)
private fun isAnagramFastest(s: String, t: String): Boolean {
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