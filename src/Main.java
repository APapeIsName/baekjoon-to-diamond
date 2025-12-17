import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    // 144ms
    // 조합 같은 기본적인 수학 공식은 알아둘 필요가 있을 듯
    // 정수론 : 최대공약수, 최소공배수 -> 유클리드 호제법, 소수 : 에라토스테네스의 체, 나머지 연산 : (A+B)(mod M) = ((A(mod M)) + (B (mod M))) (mod M) => 결과값이 너무 커서 나머지 구하기 어려울 때
    // 순열과 조합 : 조합 nCr(순서 상관x), 순열 nPr(순서 상관 o), 중복 순열/조합 : 같은 걸 다시 뽑을 수 있는 경우, 파스칼의 삼각형 : 조합의 성질(3C1 + 3C2 = 4C2)을 이용해 DP로 풀기
    // 기하 : 피타고라스 정리(점 - 점 사이 거리), CCW(세 점의 방향 관계, 시계/반시계/일직선 파악) - 선분 교차 판정 문제. 신발끈 공식 : 여러 좌표가 주어졌을 때 다각형 넓이
    // 등차/등비 수열과 시그마 : 1~n까지 합 = n(n+1) / 2, 등비수열의 합 Sn = a(r^n -1)/(r-1)
    // 행렬 : 행렬의 거듭제곱 - 피보나치 수열을 O(logN) 속도로 구할 수 있음.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            String[] read = br.readLine().split(" ");
            int first = Integer.parseInt(read[0]);
            int second = Integer.parseInt(read[1]);
            int diff = second - first;

            BigInteger mPac = BigInteger.valueOf(1);
            BigInteger mMinusNPac = BigInteger.valueOf(1);

            // m C n 조합 = m! / (n!(m-n)!)
            for (int m = second; m > first; m--) {
                mPac = mPac.multiply(BigInteger.valueOf(m));
            }
            for (int k = diff; k > 1; k--) {
                mMinusNPac = mMinusNPac.multiply(BigInteger.valueOf(k));
            }

            sb.append(mPac.divide(mMinusNPac)).append("\n");
        }

        System.out.print(sb);
    }

    // AI 해결책 - DP
    // 120ms
    // 파스칼의 삼각형 : 이항계수를 삼각형 모양으로 배열한 것. 2C2 + 2C1 = 3C2
    // 조합은 기본적으로 이런 성질을 갖고 있어, 단순 더하기만으로도 계산이 가능하므로 아래와 같은 방법으로 최적화할 수 있음.
    public static void second(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 조합 테이블 미리 만들기 (Pascal's Triangle)
        int[][] dp = new int[31][31];

        for (int i = 0; i <= 30; i++) {
            dp[i][0] = 1; // n개 중 0개를 뽑는 경우의 수는 1
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 미리 계산된 테이블에서 M C N 출력
            sb.append(dp[M][N]).append("\n");
        }
        System.out.print(sb);
    }
}
