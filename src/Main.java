import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // 284~320ms
    // 고칠 점 1. HashSet 은 많은 시간 복잡도를 잡아먹으니 사용하지 않기, 중복 제거는 마지막 반복문으로 2. sort, String.compareTo(String) 으로 비교해서 문자열 정렬시키기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String[] strArr = new String[count];

        for (int i = 0; i < count; i++) {
            strArr[i] = br.readLine();
        }

        Arrays.sort(strArr, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        });

        StringBuilder sb = new StringBuilder();

        sb.append(strArr[0]).append('\n');

        for (int i = 1; i < count; i++) {
            if (!strArr[i].equals(strArr[i-1])) {
                sb.append(strArr[i]).append('\n');
            }
        }

        System.out.print(sb);
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
