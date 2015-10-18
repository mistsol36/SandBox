package object_oriented;

/**
 * FizzBuzzのルールを表すクラス
 *
 * Created by bububu10 on 15/10/18.
 */
public class FizzBuzzRule implements Comparable {
    /** 割る数 */
    private final int dividedBy;
    /** 割る数で割り切れる場合に表示するメッセージ */
    private final String message;

    /**
     * コンストラクタ
     *
     * @param dividedBy
     * @param message
     */
    FizzBuzzRule(final int dividedBy, final String message) {
        this.dividedBy = dividedBy;
        this.message = message;
    }

    /**
     * 引数で渡された数値について判定処理を行い、結果を返す。
     *
     * @param target
     * @return FizzBuzzCalcResult
     */
    public FizzBuzzCalcResult calc(int target) {
        if (target % dividedBy == 0) {
            return new FizzBuzzCalcResult(message, target, true);
        } else {
            return new FizzBuzzCalcResult(null, target, false);
        }
    }

    /**
     * 比較メソッド。
     *
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Object o) {
        int d1 = this.dividedBy;
        int d2 = ((FizzBuzzRule) o).getDividedBy();

        if (d1 < d2) {
            return 1;
        } else if (d1 == d2) {
            return 0;
        } else {
            return -1;
        }
    }

    public int getDividedBy() {
        return dividedBy;
    }

    public String getMessage() {
        return message;
    }

}
