package framework.qmetryIntegration;

/**
 * Created by Shahin Mannan
 * Payload that will be sent to get tc run id by test suite id
 */
public class QmetryTestCaseRunIdPayload {

    private int tsrID;

    public QmetryTestCaseRunIdPayload(int tsrID) {
        this.tsrID = tsrID;
    }

    public int getTsrID() {
        return tsrID;
    }

    public void setTsrID(int tsrID) {
        this.tsrID = tsrID;
    }
}
