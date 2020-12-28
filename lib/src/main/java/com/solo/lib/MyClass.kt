package com.solo.lib

public class MyClass {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            /*
            /*
            Question 1: Find the median of two sorted arrays: For example: arr1 = [1, 3, 5], arr2 = [2, 4, 6]
            median(arr1, arr2) = 3.5*/

            val arr1 = arrayOf(1, 3, 5)
            val arr2 = arrayOf(2, 4, 6)
            val arr3 = arrayOf<Int>()

            val result: Double = getMedian(arr1, arr2)
            println("The median is $result")

            /* Question 3: Given a matrix, find the path from top left to bottom right with the greatest
            product by moving only down and right  */
            val matrix1 = arrayOf(
                intArrayOf(1, 2, 6, 5, 6),
                intArrayOf(5, 3, 9, 1, 3),
                intArrayOf(7, 4, 1, 3, 1)
            )
            findGreatestProductPath(matrix1)


            /* Question 4: Given an array of integers where each value 1 <= x <= len(array), write a
            function that finds all the duplicates in the array.*/

            val array1 = arrayOf(5, 8, 7, 5, 6, 8, 2)
            val resultsArray = getDuplicates_secondVersion(array1)
            println("Duplicates are : ")
            for (item in resultsArray) {
                println(" $item ,")
            }


            /* Test indices*/
            testIndices(arrayOf(12,14,16,18,20))

            /* Basic sort */
            val theUnsortedArray = arrayOf(16,11,17,13,20,12,19)
            val resultArray = basicSort(theUnsortedArray)
            println("Sorted array: ")
            for(item in resultArray){
                println(item)
            }



            /*
            Question 5. Consecutive Array Question : Given an unsorted array,
            find the length of the longest sequence of consecutive numbers in the array  */

            val unsortedArray = arrayOf(4, 2, 1, 6, 5)
            val unsortedArray2 = arrayOf(4, 2, 9, 1, 6, 5, 8)
            consecutive(unsortedArray)
            //val consecutives = consecutive(unsortedArray)
            //println("The number of consecutives are $consecutives")

            */

            /*Question 7: Given a boolean matrix, update it so that if any cell is true, all the cells in that
            row and column are true.*/

/*            val array1 = arrayOf(true, false, false)
            val array2 = arrayOf(false, false, false)
            val array3 = arrayOf(false, false, false)
            val sampleMtrx = arrayOf(array1, array2, array3)
            //val resultMtrx = updateMatrix(sampleMtrx)
            updateMatrix(sampleMtrx)*/

           /* Question 8: Given k sorted arrays, merge them into a single sorted array.
           * e.g. merge({{ 1 , 4 , 7 },{ 2 , 5 , 8 },{ 3 , 6 , 9 }}) = { 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 }*/

            val array1 = arrayOf(1, 4, 7)
            val array2 = arrayOf(2 ,5, 8)
            val array3 = arrayOf(3, 6, 9)
            merge(array1, array2, array3)

        }

        private fun merge(array1 : Array<Int>, array2 : Array<Int>, array3 : Array<Int>){
            //first add them all to one array
            var currentIndex : Int = 0
            val sizeOfUnsortedArray = array1.size + array2.size + array3.size
            val unSortedArray : Array<Int> = Array(sizeOfUnsortedArray){0}
            for((index,value) in array1.withIndex()){
                unSortedArray.set(index,value)
                if(index==array1.size-1)
                    currentIndex = index
            }

            currentIndex++
            for((index,value) in array2.withIndex()){
                unSortedArray.set(currentIndex, value)
                if(index!=array2.size-1)
                    currentIndex++
            }

            currentIndex++
            for((index,value) in array3.withIndex()){
                unSortedArray.set(currentIndex, value)
                if(index!=array3.size-1)
                    currentIndex++
            }

            for(item in unSortedArray){
                println(item)
            }

            //unSortedArray.forEach { println(it) }
        }


        //private fun updateMatrix(mtrx1 : Array<Array<Boolean>>) : Array<Array<Boolean>> {
        private fun updateMatrix(mtrx1 : Array<Array<Boolean>>) {
            //WRITE TO ANOTHER MATRIX INSTEAD OF OVERWRITING THIS ONE, IT WILL LESSEN CONFUSION
            var indexOfTrue : Int = -1
            var loopCount = 0
            for(array in mtrx1){
                for((index,value) in array.withIndex()){
                    if(value==true){
                        indexOfTrue=index
                        //set the entire array to true values (that will handle row)
                        for((index,value) in array.withIndex()){
                            array[index]=true
                        }
                        break
                        //for column, get which element in the array it is, go to every other array, get that nth element and set it true
                    }
                }
                if(loopCount>0) {
                    if (indexOfTrue != -1) {
                        array[indexOfTrue] = true
                    }
                }
                loopCount++
            }
            //print array
            for(array in mtrx1) {
                for (item in array) {
                    if(item==true)
                        print("true, ")
                    else
                        print("false, ")
                }
                println()
            }
        }

        private fun basicSort(myArrray: Array<Int>) : Array<Int> {
            var counter = 0

            while (counter < myArrray.size) {
              for((index,value) in myArrray.withIndex()){
                  var indexStore = index
                  val incrementedIndex = indexStore++
                  if(myArrray[index] > myArrray[incrementedIndex]){
                      val temp = myArrray[index]
                      myArrray[index] = myArrray[incrementedIndex]
                      myArrray[incrementedIndex] = temp
                  }
                  if(incrementedIndex==myArrray.size-1)
                      break;
              }
                counter++
          }
            return myArrray
        }

        private fun testIndices(array1 : Array<Int>){

            for((index,value) in array1.withIndex()){
                //println("The index is $index")
                //println("The value is $value")
            }
        }

        //private fun consecutive(array1: Array<Int>): Pair<Int,Array<Int>> {
            private fun consecutive(array1: Array<Int>) {
            //arrayOf(4, 2, 1, 6, 5) - > (1,2,4,5,6)
            var temp : Int = 0
            var theConsecutivesArrayList : ArrayList<Int> = arrayListOf()
            var theAggregateList : ArrayList<ArrayList<Int>> = arrayListOf()
            var theConsecutivesArray : IntArray
            var ongoingRun = false
            //var namingString = ""

            array1.sort()
            for((index,value) in array1.withIndex()){
                if (index==0) {
                    temp = value
                }
                else
                {
                    if(value==temp+1){
                        if(!ongoingRun)//new run
                        {
                            //val consecutivesArrayList = ArrayList<Int>()
                            //theConsecutivesArrayList = consecutivesArrayList
                            theConsecutivesArrayList.clear()
                            theConsecutivesArrayList.add(temp)
                            theConsecutivesArrayList.add(value)
                            ongoingRun=true
                        }
                        else //ongoingRun
                        {
                            theConsecutivesArrayList.add(value)
                        }
                    }
                    else //consecutive not found
                    {
                        if(ongoingRun){
                            //we have returned from a consecutive run, store those values in the aggregate list
                            theAggregateList.add(theConsecutivesArrayList)
                            ongoingRun=false
                        }
                    }
                    temp=value
                }
                //if we are at the end, add this boundary list condition
                if(index==array1.size-1){
                    theAggregateList.add(theConsecutivesArrayList)
                }
            }

            var longestList : ArrayList<Int> = arrayListOf()

            for(thisList in theAggregateList){

/*                if((thisList.size) > longestList.size) {
                    longestList = thisList
                }*/

              println("Size of list is ${thisList.size}")
                println("The items in the list are:")
                for (item in thisList){
                    println(item)
                }
                println()
            }
        }

        private fun getMedian(array1: Array<Int>, array2: Array<Int>): Double {
            val median: Double

            //Step 1 - List them all out (put them in one combined array)
            //Step 2 - Count them
            //Step 3 - If odd number, select middle one. If even, find the average of the middle two numbers

            val combinedArray = IntArray(array1.size + array2.size)

            //populate combined array with first incoming array
            for ((index, value) in array1.withIndex()) {
                combinedArray[index] = array1[index] //combinedArray.set(index, array1.get(index))
            }

            //populate combined array with second incoming array
            var currentIndex = array1.size
            for ((index, value) in array2.withIndex()) {
                combinedArray[currentIndex] = array2[index]
                currentIndex++
            }

            //Sort the array in ascending order
            combinedArray.sort()

            //print out the combined array
            for (item in combinedArray) {
                //println("$item , ")
            }

            if ((combinedArray.size % 2) == 1) { //arraysize is odd number, median is middle
                val medianIndex = (combinedArray.size / 2).toInt() + 1
                median = combinedArray[medianIndex].toDouble()
            } else {
                val firstIndex = (combinedArray.size / 2)
                val secondIndex = firstIndex + 1
                median = ((combinedArray[firstIndex] + combinedArray[secondIndex]) / 2).toDouble()
            }

            return median
        }

        private fun findGreatestProductPath(matrix: Array<IntArray>): Int {
            //first find the size of the matrix
            //println("The size of the matrix is ${matrix.size} and ${matrix[0].size}")

            val numRows = matrix.size
            val numColumns = matrix[0].size

            return 1
        }


        private fun getDuplicates(array1: Array<Int>): IntArray {
            val resultsArrayList = ArrayList<Int>()
            var counter = 0
            //val array1 = arrayOf(5, 8, 7, 5, 6)
            for (item in array1) {

                for ((index, value) in array1.withIndex()) {
                    if (item == array1[index + 1]) {
                        //duplicate found
                        resultsArrayList.add(item)
                    }
                    if (index == (array1.size - 2))
                        break
                }

            }

            val resultsArray = IntArray(resultsArrayList.size)
            for ((index, value) in resultsArray.withIndex()) {
                resultsArray[index] = resultsArrayList.get(index)
            }
            return resultsArray
        }

        private fun getDuplicates_secondVersion(array1: Array<Int>): IntArray {
            //val array1 = arrayOf(5, 8, 7, 5, 6)
            val duplicatesArrayList = ArrayList<Int>()
            var counter = 0
            var alreadyInDuplicatesList = false

            for (itemA in array1) {
                for (itemD in duplicatesArrayList) {
                    if (itemA == itemD) {
                        alreadyInDuplicatesList = true
                    }
                }
                if (!alreadyInDuplicatesList) {
                    for (itemB in array1) {
                        if (itemA == itemB) {
                            counter++
                            if (counter == 2) {
                                //duplicate found
                                duplicatesArrayList.add(itemA)
                            }
                        }
                    }
                }
                counter=0
            }

            val resultsArray = IntArray(duplicatesArrayList.size)
            for ((index, value) in resultsArray.withIndex()) {
                resultsArray[index] = duplicatesArrayList.get(index)
            }
            return resultsArray
        }
    }
}


