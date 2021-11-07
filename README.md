# В pom.xml добавлены поддержка junit-jupiter и подходящий ему maven-surefire-plugin

```xml
<dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
            </plugin>
        </plugins>
    </build>
```

# Код Java находящийся в этом репозитории

```Java
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
```
```Java
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
```