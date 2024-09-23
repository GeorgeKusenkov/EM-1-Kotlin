/*
Задача 4
    Написать шейкерную сортировку для List<Int?>. Учесть кейсы, когда переданный массив = null,
    некоторые эл-ты массива = null - пушить такие эл-ты в конец сортированного списка.
 */


fun main() {
    val list = mutableListOf(5, null, 4, 8,  2, null, 1, null, 100, 777)
    println("RESULT: ${sortIt(list)}")
}

fun sortIt(list: MutableList<Int?>): String {
    var start = 0
    var end = list.size - 1

    //Раз уж мы и сортировку вручную пишем, то и перестановку решил реализовать сам. 
    // Можно было использовать Collection.swap()
    fun swap(i: Int, j: Int) {
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }

    //При первой итерации закидываем все null  конец списка 
    while (start < end) {
        if (list[start] == null) {
            swap(start, end)
            end--
        } else {
            start++
        }
    }

    start = 0
    end--

    while (start < end) {
        var swapped = false
        for (i in start until end) {
            if (list[i]!! > list[i + 1]!!) {
                swap(i, i + 1)
                swapped = true
            }
        }

        if (!swapped) break
        end--

        for (i in end downTo start + 1) {
            if (list[i]!! < list[i - 1]!!) {
                swap(i, i - 1)
            }
        }
        start++
    }
    return list.toString()
}
