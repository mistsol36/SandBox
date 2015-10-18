package object_oriented;

import java.util.List;

/**
 * 手続き的に記述したソースコード(procedual.FizzBuzzMain)を
 * オブジェクト指向的に記述し直したサンプル。
 * <p>
 * mainメソッド以外のコードに修正を加えること無く、
 * fizzbuzzのルールの変更に対応できる汎用的な設計を考える。
 * <p>
 * Created by bububu10 on 15/10/18.
 */
public class FizzBuzzMain {
    public static void main(String args[]) {
        // ルールの準備
        FizzBuzzRule dividedBy3 = new FizzBuzzRule(3, "Fizz");
        FizzBuzzRule dividedBy5 = new FizzBuzzRule(5, "Buzz");
        FizzBuzzRule dividedBy15 = new FizzBuzzRule(15, "FizzBuzz");

        // ビルダーを構築
        FizzBuzzAppBuilder builder
                = new FizzBuzzAppBuilder()
                        .addRule(dividedBy3)
                        .addRule(dividedBy5)
                        .addRule(dividedBy15)
                        .setRange(1, 100);

        // 実行
        List<FizzBuzzCalcResult> result = builder.run();

        // 結果の出力
        for (FizzBuzzCalcResult data : result) {
            if (data.isDivided()) {
                System.out.println(data.getMessage());
            } else {
                System.out.println(data.getData());
            }
        }
    }
}
