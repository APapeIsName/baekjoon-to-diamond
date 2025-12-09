import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        first();
    }

    // 256ms -> 최적화 필요
    public static void first() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chArr = br.readLine().toUpperCase().toCharArray();
        int[] countArr = new int[26];

        int index;
        for (char ch : chArr) {
            index = ch - 65;
            countArr[index]++;
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < 13; i++) {
            int left = countArr[12 - i];
            int right = countArr[13 + i];
            if (left > max) {
                max = left;
                maxIndex = 12 - i;
            }
            if (right > max) {
                max = right;
                maxIndex = 13 + i;
            }
        }

        for (int i = 0; i < 13; i++) {
            int left = countArr[12 - i];
            int right = countArr[13 + i];
            if ((left == max && maxIndex != 12 - i) || (right == max && maxIndex != 13 + i)) {
                System.out.print('?');
                return;
            }
        }

        System.out.print((char) (maxIndex + 65));
    }


    // 최적화 -> 132ms
    public static void second() throws IOException {
        int[] countArr = new int[26];

        int c;
        while((c = System.in.read()) > 64) {
            if (c < 91) {
                countArr[c - 65]++;
            } else {
                countArr[c - 97]++;
            }
        }

        int max = 0;
        int ch = -2;
        for (int i = 0; i < 26; i++) {
            if (countArr[i] > max) {
                max = countArr[i];
                ch = i;
            }  else if (countArr[i] == max) {
                ch = -2;
            }
        }

        if (ch == -2) {
            System.out.print('?');
        } else {
            System.out.print((char) (ch + 65));
        }
    }
}
