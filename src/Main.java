import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        second();
    }

    // 120ms -> 최적화 필요
    public static void first() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String read = reader.readLine();
        StringBuilder readSb = new StringBuilder(read);
        int cycleCount = 0;
        boolean isFirst = true;

        while (isFirst || !read.equals(readSb.toString())) {
            if (readSb.length() < 2) {
                readSb.insert(0, "0");
            }

            int leftLastNum = readSb.charAt(1) - 48;
            int sum = readSb.charAt(0) + leftLastNum - 48;

            int res = (leftLastNum * 10) + (sum % 10);

            readSb.delete(0, 2);
            readSb.append(res);

            cycleCount++;

            isFirst = false;
        }

        System.out.print(cycleCount);
    }

    // 102ms
    public static void second() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int copy = n;
        int count = 0;

        do {
            n = ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10);
            count++;
        } while(copy != n);

        System.out.print(count);
    }
}
