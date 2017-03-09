package soot.jimple.infoflow.test.junit;

import org.junit.Test;
import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.config.ConfigForTest;
import soot.jimple.infoflow.data.pathBuilders.IPathBuilderFactory;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;


/**
 * Created by guoxing on 15/2/2017.
 */
public class LeakTest extends JUnitTests {

//    private final static String sourceFile = "<soot.jimple.infoflow.test.android.File:"+
//         " java.lang.Object <init>()>";
    private final static String sourceFile =
        "<soot.jimple.infoflow.test.android.File: " +
                "soot.jimple.infoflow.test.android.File getFile()>";

    private final static String sinkFile =
            "<soot.jimple.infoflow.test.android." +
                    "ConnectionManager: void publish(soot.jimple.infoflow.test.android.File)>";


    @Test
    public void TestLeak() {


        IInfoflow infoflow = initInfoflow(); // don't need to change

        List<String> epoints = new ArrayList<>();
        epoints.add("<soot.jimple.infoflow.test.LeakTestCode: void LeakTest()>");

        sources.clear();
//        sinks.clear();

        sources.add(sourceFile);

        sinks.add(sinkFile);

        infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
        checkInfoflowLeak(infoflow, 1);
    }

    private void checkInfoflowLeak(IInfoflow infoflow, int resultCount) {
        if (infoflow.isResultAvailable()) {
            InfoflowResults map = infoflow.getResults();
            assertEquals(resultCount, map.size());
            assertTrue(map.containsSinkMethod(sinkFile));
            assertTrue(map.isPathBetweenMethods(sinkFile, sourceFile)
            || map.isPathBetweenMethods(sink, sourceFile));
        } else {
            fail("result is not available");
        }

    }


}
