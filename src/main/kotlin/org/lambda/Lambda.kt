package org.lambda

import org.example.data.Post

public fun main(){
    val arr:Array<Int> = arrayOf(1,2,3,4,5,-4,-5,-8,-6);
    var list:MutableList<Int> = mutableListOf();
    list = arr.filter { int:Int -> int > 0 } as MutableList<Int>
    println(list.toString());
    var short = ::positiveValue;
    val f = short(arr);

    for(int:Int in f)
        print("${int} ");
}

fun positiveValue(arr:Array<Int>): Array<Int> {
    var list:MutableList<Int> = mutableListOf();
    list = arr.filter{its:Int -> its > 0} as MutableList<Int>;
    println(list.toString())
    val s = list.size - 1
    val arr2 = Array(5,{5});
    for(i in 0..s)
        arr2[i] = list[i];
    return arr2;
}


