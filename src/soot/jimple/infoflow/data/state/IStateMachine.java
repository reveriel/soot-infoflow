package soot.jimple.infoflow.data.state;

/**
 * Created by guoxing on 13/3/2017.
 */

/**
 * a state machine, a resource should implement its own state Machine
 *
 * now a stateMachine is written in java, it should be configurable in the future.
 */
public interface IStateMachine {
    /**
     * @return the init state
     */
    String init();

    /**
     * @param curr: the curreent state
     * @return the next state based on the curr state
     */
    String next(String curr);
}
