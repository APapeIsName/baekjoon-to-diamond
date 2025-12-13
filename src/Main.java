import java.io.*;

public class Main {

    // 108ms, 약수의 공식을 이용한 풀이 방법.
    // 참고할 점 : StringTokenizer 를 쓸 땐 데이터가 많을 때
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int nCount = Integer.parseInt(br.readLine());

        String[] numbersArr = br.readLine().split(" ");

        int min = 9999999;
        int max = -1;

        for (int i = 0; i < nCount; i++) {
            int now = Integer.parseInt(numbersArr[i]);
            if (now > max) max = now;
            if (now < min) min = now;
        }

        System.out.print(max * min);
    }
}
