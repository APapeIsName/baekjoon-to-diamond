import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
