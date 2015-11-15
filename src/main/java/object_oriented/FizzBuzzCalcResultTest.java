package object_oriented;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bububu10 on 15/10/25.
 */
public class FizzBuzzCalcResultTest {
    private List<FizzBuzzCalcResult> testData;

    /**
     * テストデータの生成
     */
    @BeforeClass
    private void makeTestData(){
        testData = new ArrayList<>();
        testData.add(new FizzBuzzCalcResult("test1",1,true));
        testData.add(new FizzBuzzCalcResult("test2",2,false));
    }

}
