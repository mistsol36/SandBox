package structuring;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * structuring.FizzBuzzMainのテストケース
 * 出力部分（mainメソッド）についてはテストしない。
 * データの判定部分（createOutputStringメソッド）についてのみのテストを行う。
 * <p>
 * Junitのアノテーションについては以下サイトなどを参照。
 * http://symfoware.blog68.fc2.com/blog-entry-992.html
 * <p>
 * Created by bububu10 on 15/10/18.
 */
public class FizzBuzzMainTest {

    /**
     * テストデータ
     */
    private static List<Integer> testData;

    /**
     * テスト対象のメソッド（privateでstaticなのでリフレクションを使う）
     */
    private static Method createOutputStringMethod;

    /**
     * テストデータ・テスト対象のメソッドの準備
     */
    @BeforeClass
    public static void makeTestData() {
        // データの準備
        // 100個のランダムな数値を生成し、Listに詰める
        Random random = new Random();
        testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add(random.nextInt());
        }
        // テスト対象メソッドの準備
        try {
            createOutputStringMethod = FizzBuzzMain.class.getDeclaredMethod("createOutputString", int.class);
            createOutputStringMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * createOutputStringのテスト
     */
    @Test
    public void createOutputStringTest() {
        for (Integer data : testData) {
            // テストデータがどのようなデータなのか分析、DataTypeという型で結果を保持
            DataType dataType = createDataType(data);
            // テスト対象のメソッドが返す結果を格納する変数
            String result = null;

            // テスト対象メソッドへテストデータを渡して結果を取得
            try {
                result = (String) createOutputStringMethod.invoke(FizzBuzzMain.class, data.intValue());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            // テストデータとテスト対象のメソッドが返した結果を突き合わせる
            String message = "data: " + data + ", type: " + dataType.getType() + ", result: " + result;
            switch (dataType) {
                case MULTIPLE_OF_15:
                case MULTIPLE_OF_3:
                case MULTIPLE_OF_5:
                    Assert.assertEquals(message, dataType.getType(), result);
                    break;
                case OTHER:
                    Assert.assertEquals(message, dataType.getRealData().toString(), result);
                    break;
            }
        }
    }

    /**
     * テストデータがどのようなデータなのか分析する。
     *
     * @param data
     * @return DataType
     */
    private DataType createDataType(Integer data) {
        if (data % 3 == 0 && data % 5 == 0) {
            return DataType.MULTIPLE_OF_15.setRealData(data);
        } else if (data % 3 == 0) {
            return DataType.MULTIPLE_OF_3.setRealData(data);
        } else if (data % 5 == 0) {
            return DataType.MULTIPLE_OF_5.setRealData(data);
        } else {
            return DataType.OTHER.setRealData(data);
        }
    }

    /**
     * テストデータの分析結果を表すenum
     * ・分析結果
     * ・生のテストデータ
     * を保持する
     */
    private enum DataType {
        MULTIPLE_OF_3("Fizz"),
        MULTIPLE_OF_5("Buzz"),
        MULTIPLE_OF_15("FizzBuzz"),
        OTHER("OTHER");

        private final String type;
        private Integer realData;

        DataType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public DataType setRealData(Integer realData) {
            this.realData = realData;
            return this;
        }

        public Integer getRealData() {
            return this.realData;
        }
    }
}