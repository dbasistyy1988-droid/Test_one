package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Resulte ");
    }


    public static boolean isEven(int n) {
        return n % 2 == 0;
    }


    public static String checkAccess(int age) {
        if (age > 18) {
            return "Allowed";
        } else {
            return "Denied";
        }
    }


    public static boolean isPositive(int n) {
        return n >= 0 ? true : false;
    }

    public static String getGrade(int score) {
        if (score >= 0 && score <= 20) {
            return "E";
        } else if (score >= 21 && score <= 40) {
            return "D";
        } else if (score >= 41 && score <= 60) {
            return "C";
        } else if (score >= 61 && score <= 80) {
            return "B";
        } else if (score >= 81 && score <= 100) {
            return "A";
        } else {
            return "Error";
        }

    }

    public static String blastOff(int start) {
        if (start < 1) {
            return "Error";
        }
        String result = "";
        for (int i = start; i >= 1; i--) {
            result += i + " ";
        }
        result += "Поехали!";
        return result;
    }

    public static int sumToN(int n) {
        if (n < 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static String getEvenInRange(int start, int end) {
        int min = Math.min(start, end);
        int max = Math.max(start, end);

        return IntStream.iterate(min % 2 == 0 ? min : min + 1, n -> n + 2)
                .limit((max - min) / 2 + 1)
                .filter(n -> n <= max)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public static boolean hasBug(String[] messages) {
        if (messages == null) {
            return false;
        }

        for (String message : messages) {
            if (message != null) {
                String lowerMessage = message.toLowerCase();

                if ("bug".equals(lowerMessage)) {
                    return true;
                } else if ("TEST FAILED".equals(lowerMessage)) {
                    return true;
                } else if ("TEST PASSED".equals(lowerMessage)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int sum(int a, int b) {
        return a;
    }

    public class NumberUtils {

        public static String getEvenInRange(int start, int end) {
            int min = Math.min(start, end);
            int max = Math.max(start, end);

            return IntStream.rangeClosed(min, max)
                    .filter(n -> n % 2 == 0)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
        }
    }

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static String[] reverse(String[] arr) {
        if (arr == null || arr.length == 0) {
            return new String[0];
        }
        int length = arr.length;
        String[] reversedArr = new String[length];
        for (int i = 0; i < length; i++) {
            reversedArr[i] = arr[length - 1 - i];
        }
        return reversedArr;
    }

    public static double calcAverage(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return (double) sum / list.size();
    }

    public static List<String> removeSpecificName(List<String> list, String nameToRemove) {
        if (list == null || nameToRemove == null) {
            return new ArrayList<>();
        }

        List<String> filteredList = new ArrayList<>();
        for (String item : list) {
            if (!nameToRemove.equalsIgnoreCase(item)) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

}