package framework.qmetryIntegration;


/**
 * Created by Shahin Mannan
 */
public class QmetryPipeLineExample {

    public static void main(String[] args){

        QmetryPipeLine.updateTestCaseResult(1125, "DFW-TC-4919", QmetryTestCase.FAIL);
        QmetryPipeLine.logOut();

    }



}
