package soot.jimple.infoflow.test.resource;

import org.junit.Test;
import soot.jimple.infoflow.IInfoflow;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;


/**
 * Created by guoxing on 15/2/2017.
 */
public class BasicTests extends ResourceTests {

    /**
     * The originial Infoflow
     *     input: 1. a set of entry point for analsysis
     *            2. a set of taint source
     *
     *     it check if source and reach sink
     *
     *
     *  now, when we do leak test.
     *     input: 1. doesn't change
     *            2. we don't have a set of taint source now.
     *
     *      it check if the resource is in valid state when the object is unreachable
     *
     *
     *
     *    when dataflow runs into a 'new File()' statement, it should ...
     *    if { c },  then   { o }
     *    if { o },  then { o }, ( maybe { twice_o } later
     *    if { o , c }, ???  then
     *    if { next_state(o), next_state(c) }
     *
     *
     *
     *
     */


    @Test
    public void TestResource1() {

        IInfoflow infoflow = initInfoflow();

        List<String> epoints = new ArrayList<>();
        epoints.add("<soot.jimple.infoflow.test.resource.ResourceTestCode: void ResourceTest1()>");
        sources.clear();
        sinks.clear();

        sources.add("<soot.jimple.infoflow.test.android.File: void <init>()>");
        infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
        checkInfoflowResource(infoflow, 1);
    }

    @Test
    public void TestResource2() {
        IInfoflow infoflow = initInfoflow();

        List<String> epoints = new ArrayList<>();
        epoints.add("<soot.jimple.infoflow.test.resource.ResourceTestCode: void ResourceTest2()>");
        sources.clear();
        sinks.clear();

        sources.add("<soot.jimple.infoflow.test.android.File: void <init>()>");
        infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
        checkInfoflowResource(infoflow, 1);
    }

    @Test
    public void TestResource3() {
        IInfoflow infoflow = initInfoflow();

        List<String> epoints = new ArrayList<>();
        epoints.add("<soot.jimple.infoflow.test.resource.ResourceTestCode: void ResourceTest3()>");
        sources.clear();
        sinks.clear();

        sources.add("<soot.jimple.infoflow.test.android.File: void <init>()>");
        infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
        checkInfoflowResource(infoflow, 1);
    }

    @Test
    public void TestResource4() {
        IInfoflow infoflow = initInfoflow();

        List<String> epoints = new ArrayList<>();
        epoints.add("<soot.jimple.infoflow.test.resource.ResourceTestCode: void ResourceTest4()>");
        sources.clear();
        sinks.clear();

        sources.add("<soot.jimple.infoflow.test.android.File: void <init>()>");
        infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
        checkInfoflowResource(infoflow, 1);
    }

    @Test
    public void TestResource5() {
        IInfoflow infoflow = initInfoflow();

        List<String> epoints = new ArrayList<>();
        epoints.add("<soot.jimple.infoflow.test.resource.ResourceTestCode: void ResourceTest5()>");
        sources.clear();
        sinks.clear();

        sources.add("<soot.jimple.infoflow.test.android.File: void <init>()>");
        infoflow.computeInfoflow(appPath, libPath, epoints, sources, sinks);
        checkInfoflowResource(infoflow, 1);
    }


    private void checkInfoflowResource(IInfoflow infoflow, int resultCount) {
//        if (infoflow.isResultAvailable()) {
//            InfoflowResults map = infoflow.getResults();
//            assertEquals(resultCount, map.size());
//            assertTrue(map.containsSinkMethod(sinkFile));
//            assertTrue(map.isPathBetweenMethods(sinkFile, sourceFile)
//            || map.isPathBetweenMethods(sink, sourceFile));
//        } else {
//            fail("result is not available");
//        }
    }


}
