package pocedural;

/**
 * fizzbuzzを手続き的に書いた場合のサンプル。
 * <p>
 * Created by bububu10 on 15/10/18.
 */
public class FizzBuzzMain {
    /**
     * 1〜100までの間でfizzbuzzを実行する。
     *
     * @param args
     */
    public static void main(String args[]) {
        /** カウンタ */
        int i;

        // カウンタを1〜100まで上げながら、カウンタの数値がどの倍数かを判断し、
        // 3の倍数の場合はfizz, 5の倍数の場合はbuzz, 15の倍数の場合はfizzbuzzという文字列を
        // 標準出力へ出力する。どの倍数でもなかった場合はカウンタの数値をそのまま標準出力へ出力する。
        for (i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
