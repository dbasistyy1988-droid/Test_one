import org.example.Main;
import org.junit.jupiter.api.*;
import org.w3c.dom.ls.LSOutput;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMain {
    @BeforeEach
    void start() {
        System.out.println("========================Test method start");
    }
    @AfterEach
    void finish() {
        System.out.println("Test method end========================");
    }

    java.util.Random random = new java.util.Random();
    private Main Utils;

    //Задача 1
    @Test
    @Tag("Anather")

    void isEven() {
        int b = random.nextInt(1, 101);
        boolean expectedResult = (b % 2 == 0);
        boolean actualResult = Main.isEven(b);

        if (expectedResult == actualResult) {
            System.out.println("Test passed! Для числа " + b);
        } else {
            System.out.println("Test failed! Для числа " + b);

        }

    }

    //Задача 2
    @Test
    @Tag("Anather")
    void accessChecker() {

        for (int i = 0; i < 20; i++) {
            int b = random.nextInt(99) + 1;
            String result = Main.checkAccess(b);

            if (b > 18 && "Allowed".equals(result)) {
                System.out.println("TEST PASSED: Для возраста " + b + " корректно получено Allowed");
            } else if (b <= 18 && "Denied".equals(result)) {
                System.out.println("TEST PASSED: Для возраста " + b + " корректно получено Denied");
            } else {
                System.out.println("TEST FAILED: Для возраста " + b + ". Ожидалось (" +
                        (b > 18 ? "Allowed" : "Denied") + "), но получили: " + result);
            }
        }

    }

    //Задача 3
    @Test
    void positive() {

        int b = random.nextInt(-101, 101);
        boolean result = Main.isPositive(b);
        boolean expected = b > 0;
        if (result == expected) {
            System.out.println("TEST PASSED: Для числа " + b + " получено " + result);
        } else {
            System.out.println("TEST FAILED: Для числа " + b + ". Ожидалось " + expected + ", но получили " + result);
        }

    }

    //Задача 4
    @Test
    @Tag("Anather")
    void grade() {

        int b = random.nextInt(0, 100);
        String result = Main.getGrade(b);

        System.out.println("TEST PASSED для " + b + ": получена оценка " + result);

    }

    //Задача 5
    @Test
    void blastOff() {

        int b = random.nextInt(0, 10);
        String result = Main.blastOff(b);

        System.out.println("TEST PASSED для " + b + ": " + result);

    }


    //Задача 6
    @Test
    void MathUtils() {

        int b = random.nextInt(99) + 1;
        int result = Main.sumToN(b);

        System.out.println("TEST PASSED для " + b + ": " + result);


    }

    //Задача 7
    @Test
    void hash() {

        String[] testArray1 = {"Info", "Warning", "bUg", "Debug"};
        System.out.println(Main.hasBug(testArray1));
        if (Main.hasBug(testArray1) == true) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

    }


    //Задача 8

    private static final int RANDOM_MIN = -100;
    private static final int RANDOM_MAX = 100;

    @Test
    void EvenInRange() {

        System.out.println("=== Запуск тестов со случайными диапазонами ===");
        for (int i = 1; i <= 10; i++) {
            // ThreadLocalRandom.current() - потокобезопасный генератор
            int a = ThreadLocalRandom.current().nextInt(RANDOM_MIN, RANDOM_MAX + 1);
            int b = ThreadLocalRandom.current().nextInt(RANDOM_MIN, RANDOM_MAX + 1);

            String result = Main.NumberUtils.getEvenInRange(a, b);

            System.out.printf("Тест %d: Range(%d, %d) -> \"%s\"%n", i, a, b, result);
        }

        System.out.println("=== Проверка граничных случаев ===");
        System.out.printf("Одиночный нечетный (5, 5): \"%s\"%n", Main.NumberUtils.getEvenInRange(5, 5));
        System.out.printf("Отрицательный (-10, -2): \"%s\"%n", Main.NumberUtils.getEvenInRange(-10, -2));

    }


    //Задача 9
    @Test
    void find() {

        int[] test1 = {3, 1, 8, 4, 2, 120};
        System.out.print("Массив [3, 1, 8, 4, 2, 120]: ");
        System.out.println(Main.findMax(test1));

        if (Main.findMax(test1) == 120) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

    }

    //Задача 10
    @Test
    void testReverse() {

        String[] input = {"One", "Two", "Zero"};
        String[] expected = {"Zero", "Two", "One"};
        assertArrayEquals(expected, Utils.reverse(input));
        System.out.println("TEST PASSED");

    }


    //Задача 11
    @Test
    void testCalcAverage() {

        List<Integer> test1 = Arrays.asList(10, 20, 30, 40);
        double result1 = Main.calcAverage(test1);
        assertEquals(25.0, result1);
        if (Main.calcAverage(test1) == 25) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

    }


    //Задача 12
    @Test
    void shouldRemoveSpecificName() {

        // Arrange: Подготовка данных
        List<String> names = List.of("Alex", "Dima", "Pyotr", "Sergey");
        String nameToRemove = "Pyotr";

        // Act: Выполнение действия
        List<String> result = Main.removeSpecificName(names, nameToRemove);

        // Assert: Проверка результата
        assertEquals(List.of("Alex", "Dima", "Sergey"), result,
                "Метод должен удалить 'Pyotr' и вернуть оставшиеся имена");
        System.out.println("TEST PASSED: Имя '" + nameToRemove + "' успешно удалено.");

    }


}


