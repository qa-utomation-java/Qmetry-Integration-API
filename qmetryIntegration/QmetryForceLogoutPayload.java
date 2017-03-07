package framework.qmetryIntegration;

/**
 * Created by  Shahin Mannan
 */
public class QmetryForceLogoutPayload {
    private int userID;

    public QmetryForceLogoutPayload(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
