package object_oriented;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FizzBuzzの処理を実行するために必要な状態を構築するクラス
 * FizzBuzz処理の本体。
 *
 * Created by bububu10 on 15/10/18.
 */
public class FizzBuzzAppBuilder {
    /**
     * FizzBuzzルールのリスト
     */
    private final List<FizzBuzzRule> rules;
    /**
     * FizzBuzz判定をする範囲のリスト
     */
    private final List<Integer> range;

    /**
     * コンストラクタ
     */
    FizzBuzzAppBuilder() {
        rules = new ArrayList<>();
        range = new ArrayList<>();
    }

    /**
     * 判定を実行し、結果のリストを返す
     *
     * @return List<FizzBuzzCalcResult>
     */
    public List<FizzBuzzCalcResult> run() {
        prepareRules();
        checkRange();

        List<FizzBuzzCalcResult> result = new ArrayList<>();

        for (Integer target : range) {
            result.add(calc(target));
        }

        return result;
    }

    /**
     * 判定処理
     *
     * @param target
     * @return FizzBuzzCalcResult
     */
    private FizzBuzzCalcResult calc(Integer target) {
        FizzBuzzCalcResult result = null;

        for (FizzBuzzRule rule : rules) {
            result = rule.calc(target);
            if (result.isDivided()) {
                return result;
            }
        }
        return result;
    }

    /**
     * 範囲が正しく設定されているかのチェック
     */
    private void checkRange() {
        if (range.isEmpty()) {
            String errMsg = "range must be set at least one.";
            throw new IllegalStateException(errMsg);
        }
    }

    /**
     * ルールが正しく設定されているかのチェック
     * ＆ルールのソート（割る数が大きいものから順にソートする）
     */
    private void prepareRules() {
        // ruleのチェック
        if (rules.isEmpty()) {
            String errMsg = "rules must be set at least one.";
            throw new IllegalStateException(errMsg);
        }
        // ルールのソート
        Collections.sort(rules);
    }

    /**
     * ルールを追加する。
     *
     * @param rule
     * @return 自分自身
     */
    public FizzBuzzAppBuilder addRule(FizzBuzzRule rule) {
        this.rules.add(rule);
        return this;
    }

    /**
     * 範囲を設定する。
     *
     * @param start
     * @param end
     * @return 自分自身
     */
    public FizzBuzzAppBuilder setRange(final int start, final int end) {
        //パラメータのチェック
        if (start > end) {
            String errMsg = "start: " + start + ", end: " + end + ", must be start < end.";
            throw new IllegalArgumentException(errMsg);
        }

        int i;
        for (i = start; i <= end; i++) {
            this.range.add(i);
        }
        return this;
    }

}
