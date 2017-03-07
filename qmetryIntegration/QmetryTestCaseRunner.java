package framework.qmetryIntegration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Shahin Mannan
 */
public class QmetryTestCaseRunner {

    private static Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    private static int TEST_SUITE_RUN_ID = 1052;


    public static void main(String[] args){

        //Login Path
        String authPath = QmetryServer.getBASEURL()+QmetryServer.getAuthenticationPath();
        QmetryRestClient qmetryAuthClient = new QmetryRestClient(authPath);
        QmetryUser user = new QmetryUser("a05435","pass4u@17");
        String userToken = qmetryAuthClient.getUserToken(user);
        System.out.println("User Token: " + userToken);


        String tcRunIdByTsRunIdPath  = QmetryServer.getBASEURL()+QmetryServer.getPathTcRunidByTsRunid();
        System.out.println("tc run id service path: " + tcRunIdByTsRunIdPath);

        QmetryRestClient qmetryTCbyTSClient = new QmetryRestClient(tcRunIdByTsRunIdPath);
//        int tcrunid = qmetryTCbyTSClient.getTCrunId(TEST_SUITE_RUN_ID, userToken);
        int tcrunid = qmetryTCbyTSClient.getTCrunIdByEntityKey(userToken,TEST_SUITE_RUN_ID, "DFW-TC-4919");

        System.out.println("Test Case Run ID: " + tcrunid);


        String testCaseExecutionPath = QmetryServer.getBASEURL()+QmetryServer.getPathExecuteTcByTcrunid();
        System.out.println("tc execution path: " + testCaseExecutionPath);

        QmetryRestClient qmetryTestCaseExecutionClient = new QmetryRestClient(testCaseExecutionPath);

        qmetryTestCaseExecutionClient.executeTCbyTCrunID(userToken, TEST_SUITE_RUN_ID, Integer.toString(tcrunid), 3);



    }

}
