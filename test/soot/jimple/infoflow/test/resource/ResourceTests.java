package soot.jimple.infoflow.test.resource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.jimple.infoflow.util.SystemClassHandler;
import soot.options.Options;

import java.util.LinkedList;

/**
 * Created by guoxing on 10/3/2017.
 */

/**
 *
 * base class for junit tests.
 */
public abstract class ResourceTests {

    protected static String appPath, libPath;

    protected static List<String> sinks;
    protected static List<String> sources;

    public IInfoflow initInfoflow() {
        Infoflow infoflow = new Infoflow();
        // there are two configuration,
        // InfoflowConfiguration and Soot Configuration
        infoflow.setSootConfig(new ResourceSootConfig());


        return infoflow;
    }

    @BeforeClass
    public static void setUp() {
        final String sep = System.getProperty("path.separator");

        File f = new File(".");
        File testSrc1 = new File(f, "bin");
        File testSrc2 = new File(f, "build" + File.separator + "classes");
        File testSrc3 = new File(f, "build" + File.separator + "testclasses");

        if (!(testSrc1.exists() || testSrc2.exists() || testSrc3.exists())) {
            fail("Test aborted - none of the test sources are available");
        }

        try {
            appPath = testSrc1.getCanonicalPath() + sep
                    + testSrc2.getCanonicalPath() + sep
                    + testSrc3.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }

        libPath = System.getProperty("java.home") + File.separator + "lib"
                + File.separator + "rt.jar";

        sources = new ArrayList<>();
        sinks = new ArrayList<>();
    }

    @Before
    public void resetSootAndStream() {
        soot.G.reset();
        System.gc();
    }



    /**
     * soot config, copied from JUnitTests's config setting.
     */
    public class ResourceSootConfig implements IInfoflowConfig {

        @Override
        public void setSootOptions(Options options) {
            // explicitly include packages for shorter runtime:
            List<String> includeList = new LinkedList<String>();
            includeList.add("java.lang.*");
            ;
            includeList.add("java.util.*");
            includeList.add("java.io.*");
            includeList.add("sun.misc.*");
            includeList.add("java.net.*");
            includeList.add("javax.servlet.*");
            includeList.add("javax.crypto.*");

            includeList.add("android.*");
            includeList.add("org.apache.http.*");

            includeList.add("de.test.*");
            includeList.add("soot.*");
            includeList.add("com.example.*");
            includeList.add("libcore.icu.*");
            includeList.add("securibench.*");
            Options.v().set_no_bodies_for_excluded(true);
            Options.v().set_allow_phantom_refs(true);
            options.set_include(includeList);
            options.set_output_format(Options.output_format_none);
            Options.v().setPhaseOption("jb", "use-original-names:true");
    //      Options.v().setPhaseOption("cg.spark", "string-constants:true");
            Options.v().set_ignore_classpath_errors(true);
        }
    }

}
