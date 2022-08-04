class RandomizedSet {
    val randomizeSet = mutableSetOf<Int>()
    val randomizeList = HashMap<Int,Int>()
    /*fun insert(`val`: Int): Boolean {
        randomizeList[`val`]?.let {
            return false
        }?: kotlin.run {
            randomizeList[`val`] = `val`
        }
    }

    fun remove(`val`: Int): Boolean {
        *//*val isRemoved = randomizeSet.remove(`val`)
        if(isRemoved) randomizeList.remove(`val`)
        return isRemoved*//*
       return randomizeList.remove(`val`) != null
    }

    fun getRandom(): Int {
        val min = 0
        val max = randomizeSet.size-1
        val randomIndex = Math.random() * (max - min) + min
        //return randomizeSet.elementAt(randomIndex)
        return 1
    }*/
}