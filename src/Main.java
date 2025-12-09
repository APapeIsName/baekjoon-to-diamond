import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        first();
    }

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
}
