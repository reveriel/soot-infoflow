package soot.jimple.infoflow.problems.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import soot.SootMethod;
import soot.jimple.Stmt;
import soot.jimple.infoflow.InfoflowManager;
import soot.jimple.infoflow.aliasing.Aliasing;
import soot.jimple.infoflow.data.Abstraction;
import soot.jimple.infoflow.problems.TaintPropagationResults;
import soot.jimple.infoflow.util.ByReferenceBoolean;
import sun.rmi.runtime.Log;

import java.util.Collection;

/**
 * Created by guoxing on 12/3/2017.
 */
public class ResourceStateRule extends AbstractTaintPropagationRule {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public ResourceStateRule(InfoflowManager manager, Aliasing aliasing,
                             Abstraction zeroValue, TaintPropagationResults results) {
        super(manager, aliasing, zeroValue, results);
    }

    /**
     * Propagates a flow along a normal statement this is not a call or return
     * site
     * @param d1 The context abstraction
     * @param source The abstraction to propagate over the statement
     * @param stmt The statement at which to propagate the abstraction
     * @param destStmt The next statement to which control flow will continue after
     * processing stmt
     * @param killSource Outgoing value for the rule to specify whether
     * the incoming taint shall be killed
     * @param killAll Outgoing value that receives whether all taints shall be
     * killed and nothing shall be propagated onwards
     * @return The new abstractions to be propagated to the next statement
     */
    @Override
    public Collection<Abstraction> propagateNormalFlow(Abstraction d1,
                                                       Abstraction source,
                                                       Stmt stmt,
                                                       Stmt destStmt,
                                                       ByReferenceBoolean killSource,
                                                       ByReferenceBoolean killAll) {
        logger.info(d1.toString());
        return null;
    }

    @Override
    public Collection<Abstraction> propagateCallFlow(Abstraction d1,
                                                     Abstraction source,
                                                     Stmt stmt,
                                                     SootMethod dest,
                                                     ByReferenceBoolean killAll) {
        return null;
    }

    @Override
    public Collection<Abstraction> propagateCallToReturnFlow(Abstraction d1,
                                                             Abstraction source,
                                                             Stmt stmt,
                                                             ByReferenceBoolean killSource,
                                                             ByReferenceBoolean killAll) {
        return null;
    }

    @Override
    public Collection<Abstraction> propagateReturnFlow(Collection<Abstraction> callerD1s,
                                                       Abstraction source,
                                                       Stmt stmt,
                                                       Stmt retSite,
                                                       Stmt callSite,
                                                       ByReferenceBoolean killAll) {
        return null;
    }
}
