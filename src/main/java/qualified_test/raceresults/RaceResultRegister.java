package qualified_test.raceresults;

import java.sql.*;

public class RaceResultRegister {

    private final String URL;
    private final String USER_NAME;
    private final String PASSWORD;

    public RaceResultRegister(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER_NAME = USER;
        this.PASSWORD = PASSWORD;
    }

    private Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    URL, USER_NAME, PASSWORD);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return connection;
    }

    public void saveResult(int CompetitorId, int result) {

        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO race_result (competitor_id, result) VALUES (?,?);";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, CompetitorId);
            pst.setInt(2, result);
            pst.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public int getLastResult(int competitorId) {

        int lastResult = 0;

        try (Connection connection = getConnection()) {
            String sql = "SELECT MAX(id), result FROM race_result WHERE competitor_id = ?;";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, competitorId);
            ResultSet rst = pst.executeQuery();
            lastResult = rst.getInt("result");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return lastResult;
    }
}
