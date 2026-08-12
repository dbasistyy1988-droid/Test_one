import org.example.Main;
import org.junit.jupiter.api.*;
import org.w3c.dom.ls.LSOutput;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import static org.assertj.core.api.Assertions.assertThat;
import static org.example.Main.findMax;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;



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


    @RepeatedTest(10)
    @Tag("testTag")
    void isEven() {
        int b = random.nextInt(0, 101);
        boolean expectedResult = (b % 2 == 0);
        boolean actualResult = Main.isEven(b);


        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");

    }

    //Задача 2


    @RepeatedTest(10)
    @Tag("testTag")
    void accessChecker() {

        for (int i = 0; i < 20; i++) {
            int b = random.nextInt(99) + 1;
            String actualResult = Main.checkAccess(b);

            assertThat(actualResult)
                    .as("The test failed, the values are not equal")
                    .isEqualToIgnoringCase("Allowed");
            System.out.println("The test was successful, the values matched");

        }

    }

    //Задача 3

    @RepeatedTest(10)
    @Tag("testTag")
    void positive() {

        int b = random.nextInt(-101, 101);
        boolean actualResult = Main.isPositive(b);
        boolean expectedResult = false;

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");

    }

    //Задача 4


    @RepeatedTest(10)
    @Tag("testTag")
    void grade() {

        int b = random.nextInt(0, 100);
        String actualResult = Main.getGrade(b);
        String expectedResult = "A";

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");


    }

    //Задача 5

    @RepeatedTest(10)
    @Tag("testTag")
    void blastOff() {

        int b = random.nextInt(0, 10);
        String actualResult = Main.blastOff(b);
        String expectedResult = "9 8 7 6 5 4 3 2 1 Поехали!";

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");


    }


    //Задача 6

    @RepeatedTest(10)
    @Tag("testTag")
    void MathUtils() {

        int b = random.nextInt(99) + 1;
        int actualResult = Main.sumToN(b);
        int expectedResult = 4950;

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");


        //System.out.println("TEST PASSED для " + b + ": " + result);


    }

    //Задача 7

    @RepeatedTest(10)
    @Tag("testTag")
    void hash() {

        String[] testArray1 = {"Info", "Warning", "bUg", "Debug"};
        boolean actualResult = Main.hasBug(testArray1);
        boolean expectedResult = false;

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");


    }


    //Задача 8

    static final int RANDOM_MIN = -100;
    static final int RANDOM_MAX = 100;


    @RepeatedTest(10)
    @Tag("testTag")
    void EvenInRange() {

        System.out.println("=== Запуск тестов со случайными диапазонами ===");
        for (int i = 1; i <= 10; i++) {
            // ThreadLocalRandom.current() - потокобезопасный генератор
            int a = ThreadLocalRandom.current().nextInt(RANDOM_MIN, RANDOM_MAX + 1);
            int b = ThreadLocalRandom.current().nextInt(RANDOM_MIN, RANDOM_MAX + 1);

            String actualResult = Main.NumberUtils.getEvenInRange(a, b);
            String expectedResult = "-36 -34 -32 -30 -28 -26 -24 -22 -20 -18 -16 -14 -12 -10 -8 -6 -4 -2 0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54";


            assertThat(actualResult)
                    .as("The test failed, the values are not equal")
                    .isEqualTo(expectedResult);
           System.out.println("The test was successful, the values matched");

        }

    }


    //Задача 9

    @RepeatedTest(10)
    @Tag("testTag")
    void find() {

        int[] test1 = {3, 1, 8, 4, 2, 120};
        int actualResult = Main.findMax(test1);
        int expectedResult = 120;


        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");

    }

    //Задача 10

    @RepeatedTest(10)
    @Tag("testTag")
    void testReverse() {

        String[] actualResult = {"One", "Two", "Zero"};
        String[] expectedResult = {"Zero", "Two", "One"};

        assertArrayEquals(expectedResult, Main.reverse(actualResult));

        assertThat(Arrays.asList(Main.reverse(actualResult)))
                .as("The test failed, the values are not equal")
                .containsExactlyElementsOf(Arrays.asList(expectedResult));
        System.out.println("The test was successful, the values matched");

    }


    //Задача 11

    @RepeatedTest(10)
    @Tag("testTag")
    void testCalcAverage() {

        List<Integer> test1 = Arrays.asList(10, 20, 30, 40);
        double actualResult = Main.calcAverage(test1);
        double expectedResult = 25.0d;

        //assertThat(Main.hasBug(testArray1)).isEqualTo(expectedResult);
        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");

    }


    //Задача 12

    @RepeatedTest(10)
    @Tag("testTag")
    void shouldRemoveSpecificName() {

        // Arrange: Подготовка данных
        List<String> names = List.of("Alex", "Dima", "Pyotr", "Sergey");
        String nameToRemove = "Pyotr";

        // Act: Выполнение действия
        List<String> actualResult = Main.removeSpecificName(names, nameToRemove);

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .containsExactly("Alex", "Dima", "Sergey");
        System.out.println("The test was successful, the values matched");

    }


}


