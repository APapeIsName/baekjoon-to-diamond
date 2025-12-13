import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

    }

    // 420ms
    // 평균 280ms, 최고점 204ms 에 비해 터무니없이 느리므로 최적화 필요
    private static void first() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            stringList.add(br.readLine());
        }

        String res = new HashSet<>(stringList)
                .stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(String::stripTrailing))
                .collect(Collectors.joining("\n"));

        System.out.print(res);
    }
}
