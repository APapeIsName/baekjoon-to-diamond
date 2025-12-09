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

    // 부족했던 점 : 1. System.in 사용 안 했던 거. 2. 단순히 26개 배열로 처리 가능했던 걸 놓쳤던 점
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

    // AI 피드백 확인
    // + new 키워드 공부하기
    public static void secondFixed() throws IOException {
        int[] countArr = new int[26];

        int c;
        // isAlpha(c) 처럼 체크해도 되지만, 문제 조건상 알파벳만 들어오므로
        // 개행문자(10) 전까지 읽는 것으로 처리해도 무방
        while ((c = System.in.read()) >= 'A') {
            // 1. 대소문자 구분 없이 소문자로 통일하여 카운팅 (비트 연산 활용)
            // 'A' | 32 => 'a', 'a' | 32 => 'a'
            countArr[(c | 32) - 'a']++;
        }

        int max = -1;
        int maxIdx = -2; // ? 출력용 플래그

        for (int i = 0; i < 26; i++) {
            if (countArr[i] > max) {
                max = countArr[i];
                maxIdx = i;
            } else if (countArr[i] == max) {
                maxIdx = -2; // 중복 발생
            }
        }

        // 삼항 연산자로 깔끔하게 출력
        System.out.print(maxIdx == -2 ? '?' : (char) (maxIdx + 'A'));
    }
}
