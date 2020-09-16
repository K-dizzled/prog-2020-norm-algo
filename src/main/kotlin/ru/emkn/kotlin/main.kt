package ru.emkn.kotlin
import java.io.File
import java.util.*

//val scan = Scanner(System.`in`)
fun main(args: Array<String>) {
    var rules = readFileAsLinesUsingUseLines("input.txt") //Считываем набор строк из файла
    var inpString = rules[0] //Отделяем строку, с которой будем работать
    rules = rules.drop(1) //Удаляем ее из List

    print("$inpString ->  ") //Вывод для отслеживания процесса выполнения алгоритма

    var endAlgo = false //Индикатор, нужно ли завершать алгоритм

    while (!endAlgo) {
        endAlgo = goThroughRules(inpString, rules).second
        inpString = goThroughRules(inpString, rules).first //Обновляем слово
        if (endAlgo)
            print(inpString)
        else
            print("$inpString ->  ")
    }
}
fun goThroughRules (inpString: String, rules: List<String>) : Pair<String, Boolean> {
    var endAlgo = true
    for (rule in rules) {
        val line = rule.split(" ")
        if(inpString.contains(line[0])){
            if (!line[1].contains("."))
                endAlgo = false
            return Pair(inpString.replaceFirst(line[0], line[2]), endAlgo)
        }
    }
    return Pair("Алгоритм завершает выполнение", true)
}
fun readFileAsLinesUsingUseLines(fileName: String): List<String>
        = File(fileName).useLines { it.toList() }