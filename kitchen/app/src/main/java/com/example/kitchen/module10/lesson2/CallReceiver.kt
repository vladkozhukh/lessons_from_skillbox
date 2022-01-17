package com.example.kitchen.module10.lesson2

interface CallReceiver: Callable {
    fun receiver(number: String){
        println("$vendor receiver call from $number")
    }
}

/** см. MobilePhone() RadioPhone() DiskPhone()
 *
 * так как идет наслдеование от Callable, можно в этих классах произвести замену на
 * Callable -> CallReceiver
 *
 * **/