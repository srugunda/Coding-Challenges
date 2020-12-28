package com.solo.a50codinginterviewquestions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Question 1: Find the median of two sorted arrays: For example: arr1 = [1, 3, 5], arr2 = [2, 4, 6]
        median(arr1, arr2) = 3.5*/

        val arr1 = arrayOf(1,3,5)
        val arr2 = arrayOf(2,4,6)
        val arr3 = arrayOf<Int>()

        val result = median(arr1,arr2)
        //println("The median is $result")
    }

    private fun median(array1 : Array<Int>, array2 : Array<Int>) : Double{
        val median : Double

        //Step 1 - List them all out (put them in one combined array)
        //Step 2 - Count them
        //Step 3 - If odd number, select middle one. If even, find the average of the middle two numbers

        val combinedArray = IntArray(array1.size + array2.size)

       //populate combined array with first incoming array
        for((index, value) in array1.withIndex()){
            combinedArray[index] = array1[index] //combinedArray.set(index, array1.get(index))
        }

        //populate combined array with second incoming array
        var currentIndex = array1.size
        for((index, value) in array2.withIndex()){
            combinedArray[currentIndex] = array2[index]
            currentIndex++
        }

        //print out the combined array
        for(item in combinedArray) {
            Log.d("MAIN ACTIVITY TAG", "$item , ")
        }

        //Sort the array in ascending order
        combinedArray.sort()

        if((combinedArray.size % 2)==1){ //arraysize is odd number, median is middle
            val medianIndex = (combinedArray.size / 2).toInt() + 1
            median = combinedArray[medianIndex].toDouble()
        }
        else{
            val firstIndex = (combinedArray.size / 2)
            val secondIndex = firstIndex + 1
            median = ((combinedArray[firstIndex] + combinedArray[secondIndex])/2).toDouble()
        }

        return median
    }
}
