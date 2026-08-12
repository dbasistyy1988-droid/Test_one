import org.example.Main;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeWork3 {
    @BeforeEach
    void start() {
        System.out.println("========================Test method start");
    }

    @AfterEach
    void finish() {
        System.out.println("Test method end========================");
    }


    @Test
    @Tag("testTag")
    public void test() {

        Random random = new Random(42L);
        String actualResult = "";

        for (int i = 0; i < 3; i++) {
            actualResult = actualResult + random.nextInt(1, 4);
        }


        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualToIgnoringCase("312");
        System.out.println("The test was successful, the values matched");


    }

    @Test
    @Tag("testTag")
    public void test1() {
        Random random = new Random();
        boolean actualResult = random.nextBoolean();
        boolean expectedResult = true;

        //assertEquals(actualResult,expectedResult);

        assertThat(actualResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");
    }

    public class Number {

        public static String getEvenInRange(int start, int end) {
            int min = Math.min(start, end);
            int max = Math.max(start, end);

            return IntStream.rangeClosed(min, max)
                    .filter(n -> n % 2 ==0)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
        }
    }

    @Test
    @Tag("testTag")
    void test2() {
        System.out.println("=== Запуск тестов со случайными диапазонами ===");
        for (int i = 1; i <= 2; i++) {
            int a = ThreadLocalRandom.current().nextInt(TestMain.RANDOM_MIN, TestMain.RANDOM_MAX + 1);
            int b = ThreadLocalRandom.current().nextInt(TestMain.RANDOM_MIN, TestMain.RANDOM_MAX + 1);

            String actualResult = HomeWork3.Number.getEvenInRange(a, b);
            String expectedResult = "Тест должен упасть";

            assertThat(actualResult)
                    .as("Тест упал исходя из требований домашнего задания")
                    .isEqualTo(expectedResult);


        }
    }

       private List<Integer> reduce(List<Integer> list, int size){
        List<Integer> result = new ArrayList<>();
           for (int i = 0; i < size ; i++) {
               result.add(list.get(i));
           }
           return result;
       }
    @Test
    @Tag("testTag")
    void test3(){
        List<Integer> sourseList = List.of(10,20,30,40,50,60,70);
        List<Integer> expectedResult = List.of(10,20,30,40);
        List<Integer> actualdResult = reduce(sourseList,3);

        assertThat(actualdResult)
                .as("The test failed, the values are not equal")
                .isEqualTo(expectedResult);
        System.out.println("The test was successful, the values matched");

    }

}
