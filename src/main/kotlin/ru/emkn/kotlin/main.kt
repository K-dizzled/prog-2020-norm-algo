package ru.emkn.kotlin
import java.io.File

//val scan = Scanner(System.`in`)
fun main(args: Array<String>) {
    var rules = readFileAsLinesUsingUseLines("input.txt") //Считываем набор строк из файла
    var inpString = rules[0] //Отделяем строку, с которой будем работать
    rules = rules.drop(1) //Удаляем ее из List

    if(!checkInput(inpString, rules)) {
        println("Входные данные некорректны. Прочитайте документацию в файле DOC.md")
        return
    }

    print("$inpString ->  ") //Вывод для отслеживания процесса выполнения алгоритма

    var endAlgo = false //Индикатор, нужно ли завершать алгоритм

    val start = System.currentTimeMillis() //Начнем отсчет времени работы алгоритма

    while (!endAlgo) {
        if(System.currentTimeMillis() - start > 5000) {
            println("Алгоритм работает свыше 5 секунд")
            return
        }
        endAlgo = goThroughRules(inpString, rules).second
        inpString = goThroughRules(inpString, rules).first //Обновляем слово
        if (endAlgo) {
            print(inpString)
            println("")
        }
        else
            print("$inpString ->  ")
    }
}

fun test(args: String) : String {
    var rules = readFileAsLinesUsingUseLines(args) //Считываем набор строк из файла
    var inpString = rules[0] //Отделяем строку, с которой будем работать
    rules = rules.drop(1) //Удаляем ее из List

    if(!checkInput(inpString, rules)) {
        return "Входные данные некорректны. Прочитайте документацию в файле DOC.md"
    }

    print("$inpString ->  ") //Вывод для отслеживания процесса выполнения алгоритма

    var endAlgo = false //Индикатор, нужно ли завершать алгоритм

    val start = System.currentTimeMillis() //Начнем отсчет времени работы алгоритма

    while (!endAlgo) {
        if(System.currentTimeMillis() - start > 5000)
            return "Алгоритм работает свыше 5 секунд"
        endAlgo = goThroughRules(inpString, rules).second
        inpString = goThroughRules(inpString, rules).first //Обновляем слово
        if (endAlgo) {
            print(inpString)
            println("")
        }
        else
            print("$inpString ->  ")
    }
    return inpString
}

fun goThroughRules (inpString: String, rules: List<String>) : Pair<String, Boolean> {
    var endAlgo = true
    for (rule in rules) {
        val line = rule.trim().split(" ") //Разбиваем очередное правило на три части
        if(inpString.contains(line[0])){ //Проверяем, есть ли в нашем слове нужная подстрока
            if (!line[1].contains(".")) //Проверяем конечность операции
                endAlgo = false
            return Pair(inpString.replaceFirst(line[0], line[2]), endAlgo) //Возвращаем пару элементов:
                                                                          //Измененное слово и флажок, указывающий
                                                                         //на то, нужно ли заканчивать алгоритм
        }
    }
    return Pair(inpString, true)
}
fun readFileAsLinesUsingUseLines(fileName: String): List<String>
        = File(fileName).useLines { it.toList() }

fun checkInput(inpString: String, rules: List<String>) : Boolean {
    var inputCorrect = true
    if(!inpString.all { it.isLetter() || it.isDigit() }) { inputCorrect = false } //Проверяем на соответствие алфавиту

    for (rule in rules) {
        val temp = rule.trim().split(" ")
        if(temp.size != 3)
            inputCorrect = false //Проверяем, все ли у нас 3 части операции (Что менять, на что менять и как менять)
        else{
            if(!temp[0].all { it.isLetter() || it.isDigit() }) { inputCorrect = false }
            if(temp[1] == "") { inputCorrect = false }
            if(!temp[2].all { it.isLetter() || it.isDigit() }) { inputCorrect = false }
            //Проверяем на соответствие алфавиту
        }
    }
    return(inputCorrect)
}