@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    val abs: Double
    var sqrt = 0.0
    for (element in v) {
        sqrt += Math.pow(element,2.0)
    }
    abs = Math.sqrt(sqrt)
    return abs
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    if (list.isEmpty()) {
        return 0.0
    }
    return (list.sum() / list.size)

}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    if (list.isEmpty()){
        return list
    }
    val Middle = (list.sum() / list.size)
    for (i in 0 until list.size){
        list[i] -= Middle
    }
    return list
}


/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var C = 0.0
    for (i in 0 until a.size){
        C += (a[i] * b[i])
    }
    return C
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var P = 0.0
    for (i in 0 until p.size){
        P += p[i] * Math.pow(x,i.toDouble())
    }
    return P
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    if (list.isEmpty()){
        return list
    }
    for (i in 1 until list.size){
        list[i] += list[i-1]
    }
    return list

}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */

fun factorize(n: Int): List<Int> {
    var Num = n
    val result = mutableListOf<Int>()
    while (Num > 1) {
        for (i in 2..n) {
            while (Num % i == 0) {
                Num /= i
                result.add(i)
            }
        }
    }
    return result.sorted()
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String {
    var Num = n
    val result = mutableListOf<Int>()
    if (n == Int.MAX_VALUE){
        return Int.MAX_VALUE.toString()
    }
    while (Num > 1) {
        for (i in 2..n) {
            while (Num % i == 0) {
                Num /= i
                result.add(i)
            }
        }
    }
    return result.sorted().joinToString (separator = "*" )
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val result = mutableListOf<Int>()
    var Num = n
    do {
        result.add (Num % base)
        Num /= base

    } while (Num > 0)
    return result.reversed()
}
/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    val Numbers:List<Int> = listOf(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36)
    val SysNum:List<String> = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
    val result = mutableListOf<String>()
    var Num = n
    do {
        if (Num % base > 9) {
            for (i in 0..25){
                if ((Num % base) == Numbers[i]) {
                    result.add(SysNum[i])
                }
            }
        }
        if (Num % base < 10){
            result.add((Num % base).toString())
        }
        Num /= base
    } while (Num > 0)
    return result.reversed().joinToString( separator = "" )

}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var result = 0
    val Numbers = digits.reversed()
    for (i in (digits.size - 1) downTo 0) {
            result += Numbers[i] * Math.pow(base.toDouble(), i.toDouble()).toInt()
    }
    return result
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    val Numbers:List<Int> = listOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35)
    val SysNum:List<String> = listOf("0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
    var result = 0
    val Num = mutableListOf<Int>()
    for (element in str){
        for (i in 0..35) {
            if (element.toString() == SysNum [i]) {
                Num.add(Numbers[i])
            }
        }
    }
    val Num2 = Num.reversed()
    for (i in (Num2.size - 1) downTo 0) {
        result += Num2[i] * Math.pow(base.toDouble(), i.toDouble()).toInt()
    }
    return result


}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val Numbers:List<Int> = listOf(1000,900,500,400,100,90,50,40,10,9,5,4,1)
    val RimNum:List<String> = listOf("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I")
    var Num = n
    var count = 0
    val Result = mutableListOf<String>()
    while (Num > 0) {
        while (Numbers[count] <= Num) {
            Num -= Numbers[count]
            Result.add(RimNum[count])
        }
        count++
    }
    return Result.joinToString (separator = "")
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val Numbers:List<Int> = listOf(900,800,700,600,500,400,300,200,100,90,80,70,60,50,40,30,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1)
    val RusNum:List<String> = listOf("девятьсот","восемьсот","семьсот","шестсот","пятьсот","четыреста","триста","двести","сто","девяносто","восемьдесят","семьдесят","шестьдесят","пятьдесят","сорок","тридцать","двадцать","девятнадцать","восемнадцать","семнадцать","шестнадцать","пятнадцать","четырнадцать","тринадцать","двенадцать","одиннадцать","десять","девять","восемь","семь","шесть","пять","четыре","три","два","один")
    var NumBig = n/1000
    var NumSmall = n%1000
    var count = 0
    val Result = mutableListOf<String>()
    if (n >= 2000) {
        while (NumBig > 0) {
            while (Numbers[count] <= NumBig) {
                NumBig -= Numbers[count]
                if (Numbers[count] == 2){
                    Result.add ("две")
                }
                if (Numbers[count] == 1){
                    Result.add ("одна")
                }
                else {
                    Result.add(RusNum[count])
                }
            }
            count++
        }
        NumBig = n/1000
        if (((NumBig % 100) < 10) || ((NumBig % 100) > 20)) {
            if (NumBig % 10 in 2..4) {
                Result.add("тысячи")
            }
            if ((NumBig % 10 in 5..9) || ((NumBig % 10 == 0))) {
                Result.add("тысяч")
            }
            if (NumBig % 10 == 1){
                Result.add("тысяча")
            }
        } else {
            Result.add("тысяч")
        }
    }
    if (n in 1000..1999) {
        Result.add("тысяча")
    }
    count = 0
    while (NumSmall > 0) {
        while (Numbers[count] <= NumSmall) {
            NumSmall -= Numbers[count]
            Result.add(RusNum[count])
        }
        count++
    }
    return Result.joinToString (separator = " ")
}