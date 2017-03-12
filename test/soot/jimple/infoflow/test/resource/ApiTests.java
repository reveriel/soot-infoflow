package soot.jimple.infoflow.test.resource;



/**
 * Created by guoxing on 12/3/2017.
 */

import org.junit.Test;
import soot.PatchingChain;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.AssignStmt;
import soot.jimple.infoflow.source.DefaultSourceSinkManager;
import soot.jimple.infoflow.source.ISourceSinkManager;

import java.util.LinkedList;
import java.util.List;

/**
 *  Test if I uesed FlowDroids API currectly
 */
public class ApiTests {

    @Test
    public void test1() {

        List<String> sources = new LinkedList<>();
        sources.add("<soot.jimple.infoflow.test.android.File: void <init>()>");

        //  difficult to init the environment..  give up

//        List<String> sinks = new LinkedList<>();
//
//
//
//        for (SootMethod m : getMethodsForSeeds())
//        SootMethod m = null;
//        PatchingChain<Unit> units = m.getActiveBody().getUnits();
//
//
//        ISourceSinkManager sourceSinkManager = new DefaultSourceSinkManager(sources, sinks);
//        sourceSinkManager.getSourceInfo(
//                new Stmt
//                }
//
//        )

    }



}
