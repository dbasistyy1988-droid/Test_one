package com.example;

import org.example.Main;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Test2Main {

    private final Random random = new Random();


    @BeforeEach
    void start() {
        System.out.println("========================Test method start");
    }
    @AfterEach
    void finish() {
        System.out.println("Test method end========================");
    }

    // Вспомогательный отчёт без assert
    private void report(boolean passed, String message) {
        if (passed) {
            System.out.println("TEST PASSED: " + message);
        } else {
            System.out.println("TEST FAILED: " + message);
        }
    }

    /*
     * ============================================================
     * @Test (минимум 4 метода)
     * ============================================================
     */

    @RepeatedTest(10)
    @Tag("testTag")
    void testIsEven() {
        int b = random.nextInt(100) + 1; // 1..100
        boolean expectedResult = (b % 2 == 0);
        boolean actualResult = Main.isEven(b);
        //report(expectedResult == actualResult, "isEven(" + b + ")");
        //printEnd();
        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");
    }

    @RepeatedTest(10)
    @Tag("testTag")
    void testCheckAccess() {
        int actualResult = random.nextInt(120) - 10; // -10..109
        String expectedResult;
        if (actualResult < 0) {
            expectedResult = "Invalid age";
        } else if (actualResult >= 18) {
            expectedResult = "Access granted";
        } else {
            expectedResult= "Access denied";
        }
        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(100);
        System.out.println("The test was successful, the values matched");

    }

    @RepeatedTest(10)
    @Tag("testTag")
    void testGetGrade() {
        int score = random.nextInt(150) - 20; // -20..129
        String expectedResult;
        if (score < 0 || score > 100) {
            expectedResult = "Invalid score";
        } else if (score >= 90) {
            expectedResult = "A";
        } else if (score >= 80) {
            expectedResult = "B";
        } else if (score >= 70) {
            expectedResult = "C";
        } else if (score >= 60) {
            expectedResult = "D";
        } else {
            expectedResult = "F";
        }
        String actualResult = Main.getGrade(score);

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo("D");
        System.out.println("The test was successful, the values matched");
    }

    @RepeatedTest(10)
    @Tag("testTag")
    void testFindMax() {
        int[] arr = new int[10];
        int maxExpected = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200) - 100; // -100..99
            if (arr[i] > maxExpected) {
                maxExpected = arr[i];
            }
        }
        int actualResult = Main.findMax(arr);
        //report(actual == maxExpected, "findMax in array of size " + arr.length);
        //printEnd();
        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(94);
        System.out.println("The test was successful, the values matched");
    }


    /*
     * ============================================================
     * @RepeatedTest (минимум 4 метода)
     * ============================================================
     */

    @RepeatedTest(10)
    @Tag("testTag")
    void repeatedTestIsPositive() {
        int b = random.nextInt(202) - 101; // -101..100
        boolean expectedResult = b > 0;
        boolean actualResult = Main.isPositive(b);

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(true);
        System.out.println("The test was successful, the values matched");
    }

    @RepeatedTest(10)
    @Tag("testTag")
    void repeatedTestBlastOff() {
        int n = random.nextInt(10); // 0..9
        // Здесь сложно проверить эталон без знания логики blastOff,
        // поэтому проверяем, что результат не null и содержит ожидаемый формат
        String actualResult = Main.blastOff(n);
        boolean passed = (actualResult!= null && !actualResult.isEmpty());

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo("9 8 7 6 5 4 3 2 1 Поехали");
        System.out.println("The test was successful, the values matched");
    }

    @RepeatedTest(10)
    @Tag("testTag")
    void repeatedTestSumToN() {
        int n = random.nextInt(50) + 1; // 1..50
        int expected = n * (n + 1) / 2;
        int actualResult = Main.sumToN(n);
        //report(actual == expected, "sumToN(" + n + ")");
        //printEnd();
        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(40);
        System.out.println("The test was successful, the values matched");
    }

    @RepeatedTest(10)
    @Tag("testTag")
    void repeatedTestHasBug() {
        String[] testArray = {"Info", "Warning", "bUg", "Debug"};
        boolean actualResult = Main.hasBug(testArray);
        // Эталон: true, если в массиве есть слово с подстрокой "bug" (регистронезависимо)
        boolean expected = false;
        for (String s : testArray) {
            if (s.toLowerCase().contains("bug")) {
                expected = true;
                break;
            }
        }

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(false);
        System.out.println("The test was successful, the values matched");
    }


    /*
     * ============================================================
     * @ParameterizedTest (минимум 4 метода)
     * ============================================================
     */

    static Stream<Integer> generateEvenOddValues() {
        List<Integer> data = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            data.add(r.nextInt(200) - 100); // -100..99
        }
        return data.stream();
    }

    @RepeatedTest(10)
    @Tag("testTag")
    @ParameterizedTest(name = "param isPositive({0})")
    @MethodSource("generateEvenOddValues")
    void paramTestIsPositive(int value) {
        boolean expectedResult = value > 0;
        boolean actualResulte = Main.isPositive(value);
        //report(expected == actual, "param isPositive(" + value + ")");
        //printEnd();
        assertThat(actualResulte)
                .as("The test failed, the values are not equal")
                .isEqualTo(false);
        System.out.println("The test was successful, the values matched");
    }

    static Stream<Integer> generateScoresForGrade() {
        List<Integer> data = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            data.add(r.nextInt(150) - 30); // -30..119
        }
        return data.stream();
    }

    @RepeatedTest(10)
    @Tag("testTag")
    @ParameterizedTest()
    @MethodSource("generateScoresForGrade")
    void paramTestGetGrade(int score) {
        String expected;
        if (score < 0 || score > 100) {
            expected = "Invalid score";
        } else if (score >= 90) {
            expected = "A";
        } else if (score >= 80) {
            expected = "B";
        } else if (score >= 70) {
            expected = "C";
        } else if (score >= 60) {
            expected = "D";
        } else {
            expected = "F";
        }
        String actualResult = Main.getGrade(score);
        //report(expected.equals(actual), "param getGrade(" + score + ")");
        //printEnd();
        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo("D");
        System.out.println("The test was successful, the values matched");
    }

    static Stream<int[]> generatePairsForSum() {
        List<int[]> data = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            int a = r.nextInt(200) - 100;
            int b = r.nextInt(200) - 100;
            data.add(new int[]{a, b});
        }
        return data.stream();
    }

    @RepeatedTest(10)
    @Tag("testTag")
    @ParameterizedTest(name = "param calcSum({0}, {1})")
    @MethodSource("generatePairsForSum")
    void paramTestCalcSum(int[] pair) {
        int a = pair[0];
        int b = pair[1];
        // Предполагаем, что в Main есть статический метод sum(a,b)
        int expectedResult = a + b;
        int actualResult = Main.sum(a, b);
        //report(actual == expected, "param sum(" + a + ", " + b + ")");
        //printEnd();
        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(33);
        System.out.println("The test was successful, the values matched");
    }

    static Stream<List<Integer>> generateListsForAverage() {
        List<List<Integer>> data = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            List<Integer> list = new ArrayList<>();
            int count = r.nextInt(9) + 2; // 2..10 элементов
            int sum = 0;
            for (int j = 0; j < count; j++) {
                int val = r.nextInt(100);
                list.add(val);
                sum += val;
            }
            // Сохраняем список + ожидаемое среднее (как комментарий логики)
            // Мы не можем передать double в List<Integer>, поэтому считаем среднее в тесте
            data.add(list);
        }
        return data.stream();
    }

    @RepeatedTest(10)
    @Tag("testTag")
    @ParameterizedTest(name = "param calcAverage(list size {0})")
    @MethodSource("generateListsForAverage")
    void paramTestCalcAverage(List<Integer> values) {
        double expectedResult = values.stream().mapToInt(Integer::intValue).sum() / (double) values.size();
        double actualResult = Main.calcAverage(values);
        // Для double используем допуск
        boolean passed = Math.abs(actualResult - expectedResult) < 0.0001;
        //report(passed, "param calcAverage (size=" + values.size() + ")");
        //printEnd();
        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(45.4);
        System.out.println("The test was successful, the values matched");
    }


    /*
     * Дополнительные тесты, чтобы точно набрать 12+ методов и покрыть требования
     */


    @RepeatedTest(10)
    @Tag("testTag")
    void testReverseArray() {
        String[] input = {"One", "Two", "Zero"};
        String[] expectedResult = {"Zero", "Two", "One"};
        String[] actualResult = Main.reverse(input);
        boolean passed = Arrays.equals(expectedResult, actualResult);

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .containsExactlyElementsOf(Arrays.asList(expectedResult));
        System.out.println("The test was successful, the values matched");
    }

    @RepeatedTest(10)
    @Tag("testTag")
    void testRemoveSpecificName() {
        List<String> names = List.of("Alex", "Dima", "Pyotr", "Sergey");
        String nameToRemove = "Pyotr";
        List<String> expected = List.of("Alex", "Dima", "Sergey");
        List<String> actualResult = Main.removeSpecificName(names, nameToRemove);

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .containsExactly("Alex", "Dima", "Sergey");
        System.out.println("The test was successful, the values matched");
    }
}
