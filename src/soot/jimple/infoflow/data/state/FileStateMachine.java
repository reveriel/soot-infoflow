package soot.jimple.infoflow.data.state;

/**
 * Created by guoxing on 13/3/2017.
 */

/**
 * File
 *
 *        c                  o
 */
public class FileStateMachine implements IStateMachine {

    @Override
    public String init() {
        return "c";
    }

    @Override
    public String next(String curr) {
        switch (curr) {
            case "o" : return "c";
            case "c" : return "o";
            default: throw new RuntimeException("unknown state");
        }
    }
}
