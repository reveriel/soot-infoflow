package soot.jimple.infoflow.test;

import soot.jimple.infoflow.test.android.ConnectionManager;
import soot.jimple.infoflow.test.android.File;

/**
 * Created by guoxing on 15/2/2017.
 */


/**
 *  the Program to be tested and the corresponding data flow Facts
 *
 *  ( The most important design decision might be here...
 */
public class LeakTestCode {

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
    public void LeakTest1() {

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
    public void LeakTest2() {
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


    public void LeakTest3() {
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

}


