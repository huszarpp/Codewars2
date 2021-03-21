package qualified_test.raceresults;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            String sql = "SELECT MAX(id), competitor_id, result FROM race_result GROUP BY competitor_id HAVING competitor_id = ?;";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, competitorId);
            ResultSet rst = pst.executeQuery();
            rst.next();
            lastResult = rst.getInt("result");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return lastResult;
    }

    public List<Integer> getAllResults(int competitorId) {

        List<Integer> resultList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT result FROM race_result WHERE competitor_id = ?;";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, competitorId);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                resultList.add(rst.getInt("result"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return resultList;
    }

    public List<String> getMissingCompetitors() {

        List<String> missingCompetitors = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "" +
                    "SELECT competitor_name, race_result.id " +
                    "FROM competitor " +
                    "INNER JOIN race_result ON competitor.id = race_result.competitor_id " +
                    "WHERE competitor_id = NULL;";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                missingCompetitors.add(rst.getString("competitor_name"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return missingCompetitors;
    }
}
