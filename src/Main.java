import java.io.*;

public class Main {
    // 104ms
    // 고쳐야 할 점 : 1.StringTokenizer 를 사용해보기
    // 2.만약 범위가 늘어나면 안 좋은 코드가 될 수 있음. 이럴 땐 메모리를 써서 시간 복잡도를 해결해보기. -> 지금 거는 2번 for문을 돌게 됨 -> 범위가 늘어나면 안 좋아짐 -> 미리 마지막까지 돈 다음 거기서 배열 자르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        String[] arr = br.readLine().split(" ");
        int first = Integer.parseInt(arr[0]);
        int last = Integer.parseInt(arr[1]);

        int count = 0;
        int num = 1;
        int firstSum = 0;

        for (int i = 1; i < first; i++) {
            if (count == num) {
                count = 0;
                num++;
            }
            firstSum += num;
            count++;
        }

        count = 0;
        num = 1;
        int lastSum = 0;

        for (int i = 1; i <= last; i++) {
            if (count == num) {
                count = 0;
                num++;
            }
            lastSum += num;
            count++;
        }

        System.out.print(lastSum - firstSum);
    }
}
