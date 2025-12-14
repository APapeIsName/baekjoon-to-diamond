import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // 108ms. 크기가 클 경우엔 boolean 배열로 바꿔야 한다는 생각을 갖고 있어야 함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        int res = 0;

        for (int i = 0; i < count; i++) {
            List<Character> chList = new ArrayList<>();
            String word = br.readLine();
            boolean isExists = false;
            chList.add(word.charAt(0));
            for (int j = 1; j < word.length(); j++) {
                if (word.charAt(j) != word.charAt(j-1)) {
                    isExists = chList.contains(word.charAt(j));
                    if (isExists) break;
                    chList.add(word.charAt(j));
                }
            }
            if (!isExists) res++;
        }

        System.out.print(res);
    }
}
