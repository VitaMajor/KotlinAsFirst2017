@file:Suppress("UNUSED_PARAMETER")
package lesson5.task1

import javax.lang.model.type.NullType

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main(args: Array<String>) {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        }
        else {
            println("Прошло секунд с начала суток: $seconds")
        }
    }
    else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateStrToDigit(str: String): String {
    val month = listOf("января","февраля","марта","апреля","мая","июня",
            "июля","августа","сентября","октября","ноября","декабря")
    val number = listOf(1,2,3,4,5,6,7,8,9,10,11,12)
    val part = str.split(" ")
    if (part.size == 3) {
        for (i in 0 until month.size) {
            if (part[1] == month[i]) {
                return String.format("%02d.%02d.%d", part[0].toInt(), number[i], part[2].toInt())
            }
        }
    }
    return ""
}
/**
 * Средняя
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateDigitToStr(digital: String): String {
    val month = listOf("января","февраля","марта","апреля","мая","июня","июля",
            "августа","сентября","октября","ноября","декабря")
    val number = listOf("01","02","03","04","05","06","07","08","09","10","11","12")
    val part = digital.split(".")
    if ((part.size == 3)) {
        for (i in 0 until month.size) {
            if (part[1] == number[i]) {
                return String.format("%d %s %d", part[0].toInt(), month[i], part[2].toInt())
            }
        }
    }
    return ""
}
/**
 * Средняя
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -98 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку
 */
fun flattenPhoneNumber(phone: String): String {
    var result = ""
    if (phone == ""){
        return result
    }
    val part = phone.split("-","(",")")
    try {
        if (phone.first() == '+') {
            result += part[0].trim()
            for (i in 1 until part.size) {
                if (part[i] == "") {
                    continue
                }
                if (part[i].trim().toInt() >= 0) {
                    result += part[i].trim().toInt()
                }
            }
        } else {
            for (i in 0 until part.size) {
                if (part[i] == "") {
                    continue
                }
                if (part[i].trim().toInt() >= 0) {
                    result += part[i].trim().toInt()
                }
            }
        }
        return result
    }
    catch (e: NumberFormatException) {
        return ""
    }

}

/**
 * Средняя
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int {
    val part = jumps.split("-","%"," ")
    var result = -1
    try {
        for (i in 0 until part.size) {
            if (part[i].trim() == "") {
                continue
            }
            if (part[i].trim().toInt() >= 0) {
                if (part[i].trim().toInt() >= result) {
                    result = part[i].trim().toInt()
                }
            }
        }
            return result
    }
    catch (e: NumberFormatException) {
        return -1
    }

}

/**
 * Сложная
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки вернуть -1.
 */
fun bestHighJump(jumps: String): Int {
    val part = jumps.split(" ")
    var result = -1
    try {
        for (i in 0 until part.size) {
            if (part[i].trim() == "-") {
                continue
            }
            if (part[i].trim() == "") {
                continue
            }
            if (part[i].trim() == "+") {
                continue
            }
            if (part[i].trim().first() == '%') {
                continue
            }
            if((part[i].trim().toInt() >= 0 ) && (part[i+1].trim().last() == '+')) {
                if (part[i].trim().toInt() >= result) {
                    result = part[i].trim().toInt()
                }
            }
        }
        return result
    }
    catch (e: NumberFormatException) {
        return -1
    }

}

/**
 * Сложная
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int {
    val part = expression.split(" ")
    var result: Int
    try {
        if (part.size == 1) {
            return part[0].toInt()
        }
        result = part[0].toInt()
        for (i in 2 until part.size) {
            if ((part[i].trim() == "+") || (part[i].trim() == "-")) {
                continue
            }
            when {
                (part[i].trim().toInt() >= 0 ) && (part[i-1].trim() == "+") -> result += part[i].trim().toInt()
                (part[i].trim().toInt() >= 0 ) && (part[i-1].trim() == "-") -> result -= part[i].trim().toInt()
            }
        }
        return result
    }
    catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}

/**
 * Сложная
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int {
    val parts = str.split(" ")
    var index = parts[0].length
    var result = -1
    for (i in 1 until parts.size) {
        if (parts[i].trim().toLowerCase() == parts[i-1].trim().toLowerCase()) {
            result = index - parts[i].length
            break
        }
        index += parts[i].length + 1
    }
    return result
}

/**
 * Сложная
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть положительными
 */
fun mostExpensive(description: String): String {
    val parts = description.split(";")
    var result = ""
    var resultPrice = 0.0
    try {
        for (i in 0 until parts.size) {
            val numPr = parts[i].trim().split(" ")
            if (numPr[1].toDouble() >= resultPrice) {
                resultPrice = numPr[1].toDouble()
                result = numPr[0].trim()
            }
        }
        return result
    }
    catch (e: IndexOutOfBoundsException) {
        return ""
    }
}

/**
 * Сложная
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int {
    val numbers:List<Int> = listOf(1000,900,500,400,100,90,50,40,10,9,5,4,1)
    val rimNum:List<String> = listOf("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I")
    val parts = roman.split("")
    var result = 0
    for (i in 0 until parts.size){
        if (parts[i].trim() in rimNum.toString()) {
            for (n in 0 until rimNum.size) {
                if (parts[i].trim() == rimNum[n]) {
                    if (parts[i] == "C" || parts[i] == "X" || parts[i] == "I") {
                        when {
                            parts[i] + parts[i + 1] == rimNum[n - 1] -> result += numbers[n - 1] - numbers[n - 2]
                            parts[i] + parts[i + 1] == rimNum[n - 3] -> result += numbers[n - 3] - numbers[n - 4]
                            else -> result += numbers[n]
                        }
                    } else {
                        result += numbers[n]
                    }
                }

            }
        } else {
            return -1
        }
    }
    if (result == 0){
        return -1
    }
    return result
}

/**
 * Очень сложная
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной с троки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> {
    val command = commands.split("")
    val test = listOf("+","-","[","]", " ", ">", "<")
    val main = mutableListOf<Int>()
    val bracketsInt = mutableListOf<Int>()
    val bracketsString = mutableListOf<String>()
    var part1 = 0
    var part2 = 0
    for (i in 1..cells) {
        main.add(0)
    }
    for (i in 0 until command.size) {
        if (command[i] in test.toString()) {
            continue
        }
        else {
            throw IllegalArgumentException()
        }
    }
    for (i in 0 until command.size) {
        if (command[i] == "[") {
            bracketsInt.add(i)
            bracketsString.add("[")
            part1++
        }
        if (command[i] == "]") {
            bracketsInt.add(i)
            bracketsString.add("]")
            part2++
        }
    }
    if (part1 != part2){
        throw IllegalArgumentException()
    }
    for (i in 1 until bracketsString.size) {
        if (bracketsString[i] == "[" && bracketsString[i - 1] == "[")
            for (j in i until bracketsString.size) {
                if (bracketsString[j] == "]" && bracketsString[j - 1] == "]") {
                    bracketsString.add(i,bracketsString[j])
                    bracketsInt.add(i,bracketsInt[j])
                }
            }
    }
    var count = 0
    var count2 = 0
    var status = cells / 2
    while (count < (command.size)) {
        when {
            command[count] == "+" -> main[status] += 1
            command[count] == "-" -> main[status] -= 1
            command[count] == ">" -> status += 1
            command[count] == "<" -> status -= 1
        }
        if (command[count] == "[" && main[status] == 0) {
            for (i in 0 until bracketsString.size) {
                if (count == bracketsInt[i] && bracketsString[i] == "[") {
                    count = bracketsInt[i + 1]
                }
            }
        }
        if (command[count] == "]" && main[status] != 0) {
            for (i in 0 until bracketsString.size) {
                if (count == bracketsInt[i] && bracketsString[i] == "]") {
                    count = bracketsInt[i - 1]
                }
            }
        }
        count++
        count2++
        if (count2 == limit + 1) {
            break
        }
        if (status < 0 || status > cells) {
            throw IllegalStateException()
        }
    }
    return main
}

