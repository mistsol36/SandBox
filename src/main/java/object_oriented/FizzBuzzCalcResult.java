package object_oriented;

/**
 * ルールに基いて判定した結果を表すクラス。
 * <p>
 * Created by bububu10 on 15/10/19.
 */
public class FizzBuzzCalcResult {
    /**
     * 割る数で割り切れる場合に表示するメッセージ
     */
    private final String message;
    /**
     * 判定対象の元々の数値
     */
    private final int data;
    /**
     * 割り切れたかどうかを表すフィールド、割り切れた場合true
     */
    private boolean isDivided;

    /**
     * コンストラクタ
     *
     * @param message
     * @param data
     * @param isDivided
     */
    FizzBuzzCalcResult(String message, int data, boolean isDivided) {
        this.message = message;
        this.data = data;
        this.isDivided = isDivided;
    }

    public boolean isDivided() {
        return isDivided;
    }

    public int getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
