package apps4life.servicemanager;

/**
 * Created by sserje06 on 09/10/2017.
 */

public class Letters_Model {

    String pathname;
    String pathroute;

    public Letters_Model(String pathname, String pathroute) {
        this.pathname = pathname;
        this.pathroute = pathroute;
    }

    public Letters_Model() {
    }

    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public String getPathroute() {
        return pathroute;
    }

    public void setPathroute(String pathroute) {
        this.pathroute = pathroute;
    }
}
