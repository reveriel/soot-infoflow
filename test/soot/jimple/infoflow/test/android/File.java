package soot.jimple.infoflow.test.android;

/**
 * Created by guoxing on 15/2/2017.
 */
public class File {

    public static File p;
    public File() {
        if (p == null) {
            p = new File();
        }
    }

    public File getFile() {
        return p;
    }

    public void close() {

    }

}
