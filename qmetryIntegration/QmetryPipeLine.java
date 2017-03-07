package framework.qmetryIntegration;


/**
 * Created by  Shahin Mannan 
 */
public class QmetryPipeLine {

    public static String AUTH_PATH = QmetryServer.getBASEURL()+QmetryServer.getAuthenticationPath();
    public static String TCRUNID_BY_TSRUNID_PATH = QmetryServer.getBASEURL()+QmetryServer.getPathTcRunidByTsRunid();
    public static String TESTCASE__EXECUTION_PATH = QmetryServer.getBASEURL()+QmetryServer.getPathExecuteTcByTcrunid();
    public static String LIST_USERS_PATH = QmetryServer.getBASEURL()+QmetryServer.getPathListUsers();
    public static String LOGOUT_PATH = QmetryServer.getBASEURL()+QmetryServer.getPathLogout();

    private static String LOGIN_ID = "";
    private static String PASSWORD = "";
    private static int USERID;
    private static String USERTOKEN;

static {
    setUserToken();
    setUserId();
}



    public QmetryPipeLine(){

        setUserToken();
        setUserId();
    }

    public static void setUserToken(){
        QmetryRestClient qmetryAuthClient = new QmetryRestClient(AUTH_PATH);
        QmetryUser user = new QmetryUser(LOGIN_ID, PASSWORD);
        USERTOKEN = qmetryAuthClient.getUserToken(user);

    }

    public static void setUserId(){

        QmetryRestClient listUsersClient = new QmetryRestClient(LIST_USERS_PATH);
        USERID = listUsersClient.getUserIdByLoginId(USERTOKEN, LOGIN_ID);
//        System.out.println(USERID);
    }

    public static void logOut(){
        QmetryRestClient qmetryLogOutClient = new QmetryRestClient(LOGOUT_PATH);
        qmetryLogOutClient.logOutCurrentUser(USERTOKEN, USERID);
        System.out.println("User: " + LOGIN_ID + " has been logged out.");

    }

    public String getUserToken(){
        return USERTOKEN;
    }

    public static void updateTestCaseResult(int testSuiteRunId, String entityKey, int testStatus){

        QmetryRestClient qmetryTCbyTSClient = new QmetryRestClient(TCRUNID_BY_TSRUNID_PATH);
        int tcrunid = qmetryTCbyTSClient.getTCrunIdByEntityKey(USERTOKEN,testSuiteRunId, entityKey);

        QmetryRestClient qmetryTestCaseExecutionClient = new QmetryRestClient(TESTCASE__EXECUTION_PATH);
        qmetryTestCaseExecutionClient.executeTCbyTCrunID(USERTOKEN, testSuiteRunId, Integer.toString(tcrunid), testStatus);

    }

    public static void main(String[] args) {

        int testSuiteRunId = Integer.parseInt(args[0]);
        String testCaseId = args[1];
        int testStatus = Integer.parseInt(args[2]);

        QmetryPipeLine.updateTestCaseResult(testSuiteRunId, testCaseId, testStatus);


    }
}
