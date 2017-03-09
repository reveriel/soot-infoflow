package soot.jimple.infoflow.test;

import soot.jimple.infoflow.test.android.ConnectionManager;
import soot.jimple.infoflow.test.android.File;

/**
 * Created by guoxing on 15/2/2017.
 */
public class LeakTestCode {
    public void LeakTest() {
        File f = new File();
        // define a state for file object
        //  State : Type := {
        //      Open : State,
        //      Closed : State
        //  }
        //

        // we need a map from object to State




        f.close();

        ConnectionManager cm = new ConnectionManager();
        cm.publish(f.getFile());
        //
    }
}
