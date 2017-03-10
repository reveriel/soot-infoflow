package soot.jimple.infoflow.test.android;

/**
 * Created by guoxing on 15/2/2017.
 */


/**
 * Model for File Object
 *
 *             init
 *      c    ------>     o
 *           <------
 *             close
 *
 *
 *
 */

public class File {
    /**
     * a dummy file descriptor, representing the real file descriptor
     */
    private Object fd;




    public File() {
        if (getFd() != null) {
            setFd(new Object());  // dummy init
        }
    }

    public void close() {
        if (getFd() != null) {
            fd = null;
        } else {
            // if close when uninitialized
            // error state, what to do now ?
        }
    }

    public Object getFd() {
        return fd;
    }

    public void setFd(Object fd) {
        this.fd = fd;
    }
}
