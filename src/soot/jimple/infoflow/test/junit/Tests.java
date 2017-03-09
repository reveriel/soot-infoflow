/**
 * Created by guoxing on 7/2/2017.
 */

package soot.jimple.infoflow.test.junit;


import org.junit.Assert;
import org.junit.Test;
import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.results.InfoflowResults;

import java.util.ArrayList;
import java.util.List;


public class Tests extends  JUnitTests {
    @Test
    public void Test1() {
        IInfoflow infoflow = initInfoflow();
        List<String > epoints = new ArrayList<>();
        epoints.add("<soot.jimple.infoflow.test.BasicTestCode: void overwriteInCalleeTest1()>");
        infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);

        System.out.println(appPath);
        System.out.println(libPath);

//        if (infoflow.isResultAvailable()) {
//            InfoflowResults map = infoflow.getResults();
//            Assert.assertEquals(0, map.size());
//            Assert.assertFalse(map.containsSinkMethod(sink));
//            Assert.assertFalse(map.containsSinkMethod(sinkInt));
//        }
    }


}
