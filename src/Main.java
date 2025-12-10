import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        second();
    }

    // 172ms
    // 고쳐야 할 점 : 1.Scanner 는 느림. 정규식 검사 과정을 거치기 때문. BufferedReader 를 쓰자
    // 2.지금은 계산식보다도 모양만 보는 알고리즘인데 int 를 사용하지 말고 String 으로 처리했어도 됐다.
    public static void first() throws IOException {
        // 1~99999 정수
        Scanner sc = new Scanner(System.in);
        StringBuilder res = new StringBuilder();

        int n;
        List<Integer> numList = new ArrayList<>();

        while ((n = sc.nextInt()) != 0) {
            while (n != 0) {
                numList.add(n % 10);
                n /= 10;
            }

            boolean isEqual = true;
            int listSize = numList.size();
            for (int i = 0; i < listSize / 2; i++) {
                isEqual = numList.get(i) == numList.get(listSize - 1 - i);
                if (!isEqual) {
                    break;
                }
            }

            if (isEqual) {
                res.append("yes\n");
            } else {
                res.append("no\n");
            }

            numList.clear();
        }

        System.out.print(res);
        sc.close();
    }

    // 100ms
    public static void second() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder res = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s.equals("0")) break;

            int len = s.length();

            boolean isEqual = true;

            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - 1 - i)) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) {
                res.append("yes\n");
            } else {
                res.append("no\n");
            }
        }

        System.out.print(res);

    }
}
