package framework.qmetryIntegration;

/**
 * Created by Shahin Mannan
 */
public class QmetryUser {

    private static String username;
    private static String password;
    private static int userID;

    public QmetryUser(){}
    public QmetryUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static int getUserID() {
        return userID;
    }

    public static void setUserID(int userID) {
        QmetryUser.userID = userID;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        QmetryUser.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        QmetryUser.password = password;
    }

}
