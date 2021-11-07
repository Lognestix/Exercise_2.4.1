package ru.netology.sqr;

public class SQRService {
    //Инициализация метода сравнения квадратов двухзначных чисел:
    public int comparisonOfSquaresOfTwoDigitNumbers(int minValue, int maxValue) {
        int totalMatchingNumbers = 0;                   //Начальное количество совпадений
        for (int cycle = 10; cycle < 99; cycle++) {     //Инициализация границ перебора
            int squareNumber = cycle * cycle;           //Возведение в квадрат
            if (squareNumber >= minValue) {             //Сравнение с заданным минимальным числом
                if (squareNumber <= maxValue) {         //Сравнение с заданным максимальным числом
                    totalMatchingNumbers++;             //Увеличение на 1 за каждую пройденную сумму сравнений
                }
            }
        }
        return (totalMatchingNumbers);                  //Возврат результата
    }
}