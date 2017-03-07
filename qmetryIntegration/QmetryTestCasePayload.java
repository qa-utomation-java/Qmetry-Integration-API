package framework.qmetryIntegration;

/**
 * Created by Shahin Mannan
 */
public class QmetryTestCasePayload {

    private int qmTsRunId;
    private String entityType;
    private int entityIDs;
    private int runStatusID;
    private String dropID;
    private String qmRunObj;
    private String comment;

    public int getQmTsRunId() {
        return qmTsRunId;
    }

    public void setQmTsRunId(int qmTsRunId) {
        this.qmTsRunId = qmTsRunId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public int getEntityIDs() {
        return entityIDs;
    }

    public void setEntityIDs(int entityIDs) {
        this.entityIDs = entityIDs;
    }

    public int getRunStatusID() {
        return runStatusID;
    }

    public void setRunStatusID(int runStatusID) {
        this.runStatusID = runStatusID;
    }

    public String getDropID() {
        return dropID;
    }

    public void setDropID(String dropID) {
        this.dropID = dropID;
    }

    public String getQmRunObj() {
        return qmRunObj;
    }

    public void setQmRunObj(String qmRunObj) {
        this.qmRunObj = qmRunObj;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
