package soot.jimple.infoflow.test.resource;

import soot.jimple.infoflow.test.android.File;

/**
 * Created by guoxing on 15/2/2017.
 */


/**
 *  the Program to be tested and the corresponding data flow Facts
 *
 *  ( The most important design decision might be here...
 */
public class ResourceTestCode {

    // some uncertain fact
    private boolean condition;

    /**
     *      init         close
     * c ---------> o  ---------> c
     */


    /**
     *  What should be the Fact ?
     *           ... let me read some papers
     *
     *     the Fact is : all the possible state the resource may have
     *
     *   example1:
     */
    public void ResourceTest1() {

        // ( F, { c } )
        File f = new File();
        // ( F, { o } )
        f.close();
        // ( F, { c } )
    }
    // here, the File is unreachable, but the state has only 'c' in it,
    // So, no bug should be reported

    /**
     *  example2,  branch
     *
      */
    public void ResourceTest2() {
        // ( F, { c } )
        File f = new File();
        // ( F, { o } )
        if (condition) {
            f.close();
            //  ( F, { c } )
        }
        // ( F, { o, c } )
    }
    // here, the File is unreachable. Its state contains 'o' and 'c',
    // obviously I should not report since there exist a valid state 'c'.
    // false positive is more undesirable.


    public void ResourceTest3() {
        // ( F, { c } )
        File f = new File();
        // ( F, { o } )
        if (condition) {
            f.close();
            // ( F, { c } )
        } else {
            f.close();
            // ( F, { c } )
        }
        // ( F, { c } )
    }
    // no bug report


    private class F {
        File f;
    }
    /**
     * test access path
     */
    public void ResourceTest4() {
        File f = new File();

        F a = new F();
        a.f = f;
    }


    public void ResourceTest5() {
        File f1 = new File();
        File f2 = new File();
        f1.close();
        f2.close();
    }

}


