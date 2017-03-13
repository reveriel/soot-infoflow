package soot.jimple.infoflow.data.state;

/**
 * Created by guoxing on 13/3/2017.
 */


import com.sun.deploy.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * The State of a resource
 * The all possible states of a resource, precisely speaking
 *
 * it depends on the type of the resource, and is customizable
 */
public class ResourceState {
    Set<String> states = new HashSet<>();


    ResourceState(IStateMachine sm) {
        states.add(sm.init());
    }

    @Override
    public String toString() {
        String res = "{";
        res += StringUtils.join(states,",");
        res += "}";
        return res;
    }
}



