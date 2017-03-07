package framework.qmetryIntegration;

/**
 * Created by Shahin Mannan
 */
public class QmetryTestCaseExecutionPayload {

    //test suite run id
    private int qmTsRunId;
    //set to TCR by default
    private String entityType;
    //comma separated test case run ids
    private String entityIDs;

    //indicates the test result (1= pass, 2= not run, 3=failed)
    private int runStatusID;

    public QmetryTestCaseExecutionPayload(int qmTsRunId, String entityIDs, int runStatusID) {
        this.qmTsRunId = qmTsRunId;
        this.entityIDs = entityIDs;
        this.runStatusID = runStatusID;
        this.entityType = "TCR";
    }

    public int getQmTsRunId() {
        return qmTsRunId;
    }

    public void setQmTsRunId(int qmTsRunId) {
        this.qmTsRunId = qmTsRunId;
    }

    public String getEntityIDs() {
        return entityIDs;
    }

    public void setEntityIDs(String entityIDs) {
        this.entityIDs = entityIDs;
    }

    public int getRunStatusID() {
        return runStatusID;
    }

    public void setRunStatusID(int runStatusID) {
        this.runStatusID = runStatusID;
    }
}
