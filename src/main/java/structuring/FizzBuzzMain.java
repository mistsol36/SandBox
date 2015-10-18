package structuring;

/**
 * 手続き的に記述したソースコード(procedual.FizzBuzzMain)を構造化したサンプル。
 * ここでは標準出力へ出力すべき結果の判定と生成をprivateメソッドへ切り出している。
 * <p>
 * mainメソッドでまとめて行っていた以下の処理が構造化されている。
 * ①数値の判定と結果の生成
 * ②標準出力への出力処理
 * <p>
 * このようにソースコードを構造化しておくことで、
 * 以下のような変更があったときに、修正すべき箇所の可読性が上がる。
 * ①fizzBuzzのルールに変更があったとき
 * 　->creatOutputStringメソッドを修正すればよい。
 * ②出力先を標準出力ではなく、ファイルやDBなどにしたいとき
 * 　->mainメソッドのSystem.out.printlnとしている部分を修正すればよい。
 * <p>
 * また、判定部分と出力部分が分かれていると、
 * 単体テストやバグ発生時の原因の追跡も容易になる。
 * mainメソッドでは「正しく出力されること」を確認すればよく、
 * createOutputStringでは「正しくデータが生成されること」を確認すればよい。
 * 判定処理と出力処理が分かれていないと、不正な結果が出た時に、
 * 「判定処理におけるバグ」なのか「出力処理におけるバグ」なのかの
 * 切り分けが困難になってしまう。
 *
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

        // 標準出力への出力処理
        for (i = 1; i <= 100; i++) {
            System.out.println(createOutputString(i));
        }
    }

    /**
     * 引数で受け取った数値を判定し、出力すべき結果の文字列を生成する。
     *
     * @param i 判定対象
     * @return 出力すべき結果
     */
    private static String createOutputString(final int i) {
        //結果を格納するための変数
        String result;

        // 引数で受け取った数値を判定し、結果を生成する
        if (i % 3 == 0 && i % 5 == 0) {
            result = "FizzBuzz";
        } else if (i % 3 == 0) {
            result = "Fizz";
        } else if (i % 5 == 0) {
            result = "Buzz";
        } else {
            result = Integer.toString(i);
        }
        return result;
    }
}
