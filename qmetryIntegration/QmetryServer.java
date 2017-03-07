package framework.qmetryIntegration;

/**
 * Created by Shahin Mannan on 1/13/2017.
 */

public class QmetryServer {

    private static String BASEURL = "";
    private static String AUTHENTICATION_PATH = "/rest/login";
    private static String PATH_EXECUTE_TC_BY_TCRUNID = "/rest/execution/runstatus/bulkupdate";

    private static String PATH_TC_RUNID_BY_TS_RUNID = "/rest/execution/list/tcr";
    private static String PATH_LIST_USERS = "/rest/admin/user/list";
    private static String PATH_LOGOUT = "/rest/admin/user/forcelogout";
    private static String PATH_LIST_USER_ROLES = "/rest/admin/role/list";
    private static String PATH_LIST_EXECUTION_STATUS  = "rest/admin/execution/list";

    public static String getPathListUsers() {
        return PATH_LIST_USERS;
    }

    public static void setPathListUsers(String pathListUsers) {
        PATH_LIST_USERS = pathListUsers;
    }

    public static String getPathLogout() {
        return PATH_LOGOUT;
    }

    public static void setPathLogout(String pathLogout) {
        PATH_LOGOUT = pathLogout;
    }


    public static String getBASEURL() {
        return BASEURL;
    }

    public static void setBASEURL(String BASEURL) {
        QmetryServer.BASEURL = BASEURL;
    }

    public static String getAuthenticationPath() {
        return AUTHENTICATION_PATH;
    }

    public static void setPathAuthentication(String pathAuthentication) {
        AUTHENTICATION_PATH = pathAuthentication;
    }

    public static String getPathExecuteTcByTcrunid() {
        return PATH_EXECUTE_TC_BY_TCRUNID;
    }

    public static void setPathExecuteTcByTcrunid(String pathExecuteTcByTcrunid) {
        PATH_EXECUTE_TC_BY_TCRUNID = pathExecuteTcByTcrunid;
    }

    public static String getPathTcRunidByTsRunid() {
        return PATH_TC_RUNID_BY_TS_RUNID;
    }

    public static void setPathTcRunidByTsRunid(String pathTcRunidByTsRunid) {
        PATH_TC_RUNID_BY_TS_RUNID = pathTcRunidByTsRunid;
    }

    public QmetryServer(){}
}
