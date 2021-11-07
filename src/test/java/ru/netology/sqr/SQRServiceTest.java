package ru.netology.sqr;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SQRServiceTest {

    @ParameterizedTest
    @CsvSource (value = {"range 0 - 99, 0, 99, 0",              //Диапазон 0 - 100, итоговое число совпадений 0
            "range 100 - 10000, 100, 10000, 89",                //Диапазон 100 - 10_000, итоговое число совпадений 89
            "range 200 - 300, 200, 300, 3"})                    //Диапазон 200 - 300, итоговое число совпадений 3

    void shouldComparisonOfSquaresOfTwoDigitNumbers(String testName, int minValue, int maxValue, int expected) {
        SQRService service = new SQRService();
        int actual = service.comparisonOfSquaresOfTwoDigitNumbers(minValue, maxValue);      //Вызов метода
        assertEquals(expected, actual);                                                     //Выполняется проверка
    }
}