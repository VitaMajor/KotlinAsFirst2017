@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1


/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {

    var result1 = 1
    var num = Math.abs(n)

    while (num >= 10){
        num /= 10
        result1++
    }
    return result1
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fibFirst = 1
    var fibSecond = 1
    var result = 1
    var i = 2
    while (i < n) {
        result = fibFirst + fibSecond
        fibFirst = fibSecond
        fibSecond = result
        i++
    }
    return result
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    val prod = m * n
    var number1 = m
    var number2 = n

    while(number1 != number2) {
        if (number1 > number2){
            number1 -= number2
        } else {
            number2 -= number1
        }
    }
    return (prod / number1)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (k in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % k == 0) {
            return k
        }
    }
    return n
}


/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    for (k in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % (n / k) == 0) {
            return (n / k)
        }
    }
    return 1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = lcm(m , n) == m * n

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (k in m..n) {
        if ((Math.sqrt(k.toDouble()) % 1.0) == 0.0 ){
            return true
        }
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var number = n
    var result = 0
    while(number > 0) {
        result = result * 10 + (number % 10)
        number /= 10
    }
    return result
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    var number = n
    var result = 0
    while(number > 0) {
        result = result * 10 + (number % 10)
        number /= 10
    }
    return n == result
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var number = n
    var results = 0
    val sum = n % 10
    while(number > 0) {
        results = results * 10 + sum
        number /= 10
    }
    return n != results
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    val number1: Int = n
    var number2 = 0
    var count = 0
    var result = 1
    var sum: Int
    while (number2 < number1){
        count++
        result = count * count
        sum = 0
        while(result > 0) {
            result /= 10
            sum++
        }
        result = count * count
        number2 += sum
    }
    while (number2 > number1){
        result /= 10
        number2--
    }
    if (number2 == number1) {
        result %= 10
    }
    return result
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    val number1: Int = n
    var number2 = 0
    var count = 0
    var result = 1
    var sum: Int
    while (number2 < number1){
        count++
        result = fib(count)
        sum = 0
        while(result > 0) {
            result /= 10
            sum++
        }
        result = fib(count)
        number2 += sum
    }
    while (number2 > number1){
        result /= 10
        number2--
    }
    if (number2 == number1) {
        result %= 10
    }
    return result
}
