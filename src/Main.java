import java.io.*;

public class Main {

    // 132ms.
    // 수학적으로 대각선의 길이를 구하는 공식을 사용하면 더 빠르게 구할 수 있음(표를 보면 1/1 -> 2/2 -> 3/3 이렇게 쭉 대각선으로 이어지니까).
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // x = 1, y = 1 -> x = 1, y = 2 / 1 - 2 - 3 - 4
        // 홀수 -> x 가 큰 쪽이 첫 번째, 짝수 -> y가 큰 쪽이 첫 번째
        // x + y = 사이클 + 1
        int x = 1;
        int y = 1;
        int cycle = 0;
        int nowCount = 0;

        int count = Integer.parseInt(br.readLine());

        while(true) {
            cycle++;
            nowCount += cycle;
            if (nowCount >= count) {
                nowCount -= cycle;
                break;
            }
        }

//        nowCount count cycle 합 : 5
//        6        8     4
//        count - nowCount = 2 번째 => 4사이클의 2번째 => 합이 5인데 2번째 1/4 합 - 번째 => 큰 수로 가서 +, 번째 = 작은 수

        int sequence = count - nowCount;

        if (cycle % 2 == 0) {
            y += cycle - sequence;
            x = sequence;
        } else {
            x += cycle - sequence;
            y = sequence;
        }

        System.out.print(x+"/"+y);
    }

    // AI 최적화 코드 제시된 내용 - 빼기로 진행하면서 찾아나가면 더 효율적이다. 124ms
    public static void second() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int cycle = 1; // 대각선 칸의 개수 (1, 2, 3...)

        // X가 cycle보다 크면, 해당 cycle만큼 빼고 다음 대각선으로 이동
        // 예: X=5.
        // 1번 대각선(1개): 5 > 1 -> X=4, cycle=2
        // 2번 대각선(2개): 4 > 2 -> X=2, cycle=3
        // 3번 대각선(3개): 2 <= 3 -> 루프 종료. 현재 3번째 대각선의 2번째 칸임.
        while (X > cycle) {
            X -= cycle;
            cycle++;
        }

        // 반복문이 끝나면:
        // cycle: 몇 번째 대각선인지 (홀수/짝수 판별용)
        // X: 그 대각선에서 몇 번째 순서인지

        if (cycle % 2 == 0) {
            // 짝수 대각선: 분자가 오름차순 (1/2 -> 2/1 : 위에서 아래로)
            // 아, 문제의 예시는 지그재그 방향이네요.
            // 짝수번(2번째): 1/2 -> 2/1 (분자 증가, 분모 감소)
            System.out.print(X + "/" + (cycle - X + 1));
        } else {
            // 홀수 대각선: 분모가 오름차순
            System.out.print((cycle - X + 1) + "/" + X);
        }
    }
}
