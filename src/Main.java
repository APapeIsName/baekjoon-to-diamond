import java.io.*;

public class Main {

    // 104ms, 수학적인 공식에 대해 더 생각해볼 필요가 있음.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int count = Integer.parseInt(br.readLine());
        int[] numbers = new int[count];
        int max = 0;

        String[] numberSplit = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(numberSplit[i]);
            if (numbers[i] > max) max = numbers[i];
        }

        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += ((double) numbers[i] / max);
        }

        System.out.print((total / count) * 100);
    }
}
