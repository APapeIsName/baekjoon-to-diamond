import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        testStringBuilder();
//        testString();
        testCharArray();
    }

    // time = 14
    // memory = 1607344
    private static void testStringBuilder() {
        Runtime.getRuntime().gc();
        LocalDateTime start = LocalDateTime.now();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("Hello World");
        }
        System.out.print("stringBuilder = " + stringBuilder);
        LocalDateTime end = LocalDateTime.now();
        System.out.print("\ntime = " + Duration.between(start, end).toMillis());
        System.out.println("\nmemory = " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

    // time = 54
    // memory = 37826496
    private static void testString() {
        Runtime.getRuntime().gc();
        LocalDateTime start = LocalDateTime.now();
        String string = "";
        for (int i = 0; i < 10000; i++) {
            string += "Hello World";
        }
        System.out.print("string = " + string);
        LocalDateTime end = LocalDateTime.now();
        System.out.print("\ntime = " + Duration.between(start, end).toMillis());
        System.out.println("\nmemory = " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

    // time = 90
    // memory = 1636448
    private static void testCharArray() {
        Runtime.getRuntime().gc();
        LocalDateTime start = LocalDateTime.now();
        char[] charArray = new char[110000];
        for (int i = 0; i < 10000; i = i + 11) {
            charArray[i] = 'H';
            charArray[i+1] = 'e';
            charArray[i+2] = 'l';
            charArray[i+3] = 'l';
            charArray[i+4] = 'o';
            charArray[i+5] = ' ';
            charArray[i+6] = 'w';
            charArray[i+7] = 'o';
            charArray[i+8] = 'r';
            charArray[i+9] = 'l';
            charArray[i+10] = 'd';
        }
//        System.out.print("charArray = " + charArray.length);
        for (int i = 0; i < 110000; i = i + 1) {
            System.out.print(charArray[i]);
        }
//        for (char c : charArray) {
//            System.out.print(c);
//        }
        LocalDateTime end = LocalDateTime.now();
        System.out.print("\ntime = " + Duration.between(start, end).toMillis());
        System.out.println("\nmemory = " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = new ArrayList<>();
        boolean isInputFirst = false;
        byte inputNumber = 0;
        while (!isInputFirst || inputNumber != 0) {
            inputNumber--;
            String inputString = scanner.nextLine();
            if (!isInputFirst) {
                inputNumber = Byte.parseByte(inputString);
                isInputFirst = true;
            } else {
                inputList.add(inputString);
            }
        }
        char[] result = inputList.get(0).toCharArray();
        for (int i = 0; i < inputList.size() - 1; i++) {
            for (int j = 0; j < result.length; j++) {
                char[] first = inputList.get(i).toCharArray();
                char[] second = inputList.get(i + 1).toCharArray();

                if (first[j] == second[j]) {
                    if (result[j] != first[j]
                            && result[j] != '?') result[j] = first[j];
                } else {
                    if (result[j] != '?') result[j] = '?';
                }
            }
        }

        System.out.println(result);
    }
}
