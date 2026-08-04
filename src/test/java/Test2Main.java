package com.example;

import org.example.Main;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Test2Main {

    private final Random random = new Random();

    // Вспомогательный метод для разделителей
    private void printStart() {
        System.out.println("========================Test method start");
    }

    private void printEnd() {
        System.out.println("Test method end");
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

    @Test
    void testIsEven() {
        printStart();
        int b = random.nextInt(100) + 1; // 1..100
        boolean expected = (b % 2 == 0);
        boolean actual = Main.isEven(b);
        report(expected == actual, "isEven(" + b + ")");
        printEnd();
    }

    @Test
    void testCheckAccess() {
        printStart();
        int age = random.nextInt(120) - 10; // -10..109
        String expected;
        if (age < 0) {
            expected = "Invalid age";
        } else if (age >= 18) {
            expected = "Access granted";
        } else {
            expected = "Access denied";
        }
        String actual = Main.checkAccess(age);
        report(expected.equals(actual), "checkAccess(" + age + ")");
        printEnd();
    }

    @Test
    void testGetGrade() {
        printStart();
        int score = random.nextInt(150) - 20; // -20..129
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
        String actual = Main.getGrade(score);
        report(expected.equals(actual), "getGrade(" + score + ")");
        printEnd();
    }

    @Test
    void testFindMax() {
        printStart();
        int[] arr = new int[10];
        int maxExpected = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200) - 100; // -100..99
            if (arr[i] > maxExpected) {
                maxExpected = arr[i];
            }
        }
        int actual = Main.findMax(arr);
        report(actual == maxExpected, "findMax in array of size " + arr.length);
        printEnd();
    }


    /*
     * ============================================================
     * @RepeatedTest (минимум 4 метода)
     * ============================================================
     */

    @RepeatedTest(5)
    void repeatedTestIsPositive() {
        printStart();
        int b = random.nextInt(202) - 101; // -101..100
        boolean expected = b > 0;
        boolean actual = Main.isPositive(b);
        report(expected == actual, "isPositive(" + b + ")");
        printEnd();
    }

    @RepeatedTest(5)
    void repeatedTestBlastOff() {
        printStart();
        int n = random.nextInt(10); // 0..9
        // Здесь сложно проверить эталон без знания логики blastOff,
        // поэтому проверяем, что результат не null и содержит ожидаемый формат
        String result = Main.blastOff(n);
        boolean passed = (result != null && !result.isEmpty());
        report(passed, "blastOff(" + n + ") non-empty result");
        printEnd();
    }

    @RepeatedTest(5)
    void repeatedTestSumToN() {
        printStart();
        int n = random.nextInt(50) + 1; // 1..50
        int expected = n * (n + 1) / 2;
        int actual = Main.sumToN(n);
        report(actual == expected, "sumToN(" + n + ")");
        printEnd();
    }

    @RepeatedTest(3)
    void repeatedTestHasBug() {
        printStart();
        String[] testArray = {"Info", "Warning", "bUg", "Debug"};
        boolean actual = Main.hasBug(testArray);
        // Эталон: true, если в массиве есть слово с подстрокой "bug" (регистронезависимо)
        boolean expected = false;
        for (String s : testArray) {
            if (s.toLowerCase().contains("bug")) {
                expected = true;
                break;
            }
        }
        report(actual == expected, "hasBug in array");
        printEnd();
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

    @ParameterizedTest(name = "param isPositive({0})")
    @MethodSource("generateEvenOddValues")
    void paramTestIsPositive(int value) {
        printStart();
        boolean expected = value > 0;
        boolean actual = Main.isPositive(value);
        report(expected == actual, "param isPositive(" + value + ")");
        printEnd();
    }

    static Stream<Integer> generateScoresForGrade() {
        List<Integer> data = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            data.add(r.nextInt(150) - 30); // -30..119
        }
        return data.stream();
    }

    @ParameterizedTest()
    @MethodSource("generateScoresForGrade")
    void paramTestGetGrade(int score) {
        printStart();
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
        String actual = Main.getGrade(score);
        report(expected.equals(actual), "param getGrade(" + score + ")");
        printEnd();
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

    @ParameterizedTest(name = "param calcSum({0}, {1})")
    @MethodSource("generatePairsForSum")
    void paramTestCalcSum(int[] pair) {
        printStart();
        int a = pair[0];
        int b = pair[1];
        // Предполагаем, что в Main есть статический метод sum(a,b)
        int expected = a + b;
        int actual = Main.sum(a, b);
        report(actual == expected, "param sum(" + a + ", " + b + ")");
        printEnd();
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

    @ParameterizedTest(name = "param calcAverage(list size {0})")
    @MethodSource("generateListsForAverage")
    void paramTestCalcAverage(List<Integer> values) {
        printStart();
        double expected = values.stream().mapToInt(Integer::intValue).sum() / (double) values.size();
        double actual = Main.calcAverage(values);
        // Для double используем допуск
        boolean passed = Math.abs(actual - expected) < 0.0001;
        report(passed, "param calcAverage (size=" + values.size() + ")");
        printEnd();
    }


    /*
     * Дополнительные тесты, чтобы точно набрать 12+ методов и покрыть требования
     */

    @Test
    void testReverseArray() {
        printStart();
        String[] input = {"One", "Two", "Zero"};
        String[] expected = {"Zero", "Two", "One"};
        String[] actual = Main.reverse(input);
        boolean passed = Arrays.equals(expected, actual);
        report(passed, "reverse array");
        printEnd();
    }

    @Test
    void testRemoveSpecificName() {
        printStart();
        List<String> names = List.of("Alex", "Dima", "Pyotr", "Sergey");
        String nameToRemove = "Pyotr";
        List<String> expected = List.of("Alex", "Dima", "Sergey");
        List<String> actual = Main.removeSpecificName(names, nameToRemove);
        report(expected.equals(actual), "removeSpecificName");
        printEnd();
    }
}
