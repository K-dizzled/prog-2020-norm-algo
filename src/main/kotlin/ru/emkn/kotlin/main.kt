package ru.emkn.kotlin
import java.util.*

val scan = Scanner(System.`in`)
fun main(args: Array<String>) {
    input()
    //println("Hello with args: " + args.joinToString(", ", "[", "]"))
}
fun input() {
    var inpString = scan.nextLine() //Изменяемое слово
    val amountStrings = scan.nextInt() //Количество правил
    val rules = Array(amountStrings) {""} //Массив строк - правил

    for (i in 0 until amountStrings) {  //
        rules[i] = scan.nextLine()          //  Считывание словаря правил
    }                                      //

    print("$inpString ->  ") //Вывод для отслеживания процесса выполнения алгоритма

    var endAlgo = false //Индикатор, нужно ли завершать алгоритм
    while (!endAlgo) {
        inpString = goThroughRules(inpString, rules).first //Обновляем слово
        endAlgo = goThroughRules(inpString, rules).second
        if (endAlgo)
            print(inpString)
        else
            print("$inpString ->  ")
    }
}
fun goThroughRules (inpString: String, rules: Array<String>) : Pair<String, Boolean> {
    var endAlgo = true
    for (rule in rules) {
        val line = rule.split(" ")
        if(inpString.contains(line[0])){
            inpString.replaceFirst(line[0], line[2])
            if (!line[1].contains("."))
                endAlgo = false
            return Pair(inpString, endAlgo)
        }
    }
    return Pair("Алгоритм завершает выполнение", true)
}
