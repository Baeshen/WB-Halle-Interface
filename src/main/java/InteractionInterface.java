import java.sql.*;

import java.util.*;

/**
 * Interface to Module Analyse.
 */
public class InteractionInterface {
    private static final String DB_URL = "jdbc:mariadb://goethe.se.uni-hannover.de:3306/VirtuHoS_3";   // URL von Databank
    private static final String USER = "Halle_3";           // username von databank
    private static final String PASS = "YOUR_PASSWORD";     // password von databank
    private Connection connection = null;



    public InteractionInterface () throws SQLException {
        // Create the connection to the database
        this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    /**
     * Returns all the data for all users.
     * @return A list with all user data.
     * @throws SQLException
     */
    public List<AnalysedData> getAnalysedData() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT idFrom, idTo, duration, flow FROM ANALYSE_interaction");
        ArrayList<AnalysedData> result = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            result.add(new AnalysedData(
                    resultSet.getString("idFrom"),
                    resultSet.getString("idTo"),
                    resultSet.getDouble("duration"),
                    resultSet.getDouble("flow")
            ));
        }

        resultSet.close();
        statement.close();
        return result;
    }

    /**
     * Returns the data for one user.
     * @param userId ID of the user which data is wanted.
     * @return Returns interaction data for one user.
     * @throws SQLException
     */
    public List<AnalysedData> getAnalysedData(String userId) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT idFrom, idTo, duration, flow FROM ANALYSE_interaction WHERE idFrom = ? OR idTo = ?");
        ArrayList<AnalysedData> result = new ArrayList<>();

        statement.setString(1, userId);
        statement.setString(2, userId);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            result.add(new AnalysedData(
                    resultSet.getString("idFrom"),
                    resultSet.getString("idTo"),
                    resultSet.getDouble("duration"),
                    resultSet.getDouble("flow")
            ));
        }

        resultSet.close();
        statement.close();
        return result;
    }

    /**
     * Returns the date for a selection of users.
     * @param userIds UserIDs the data should be returned for
     * @return A list with the data between the selected users.
     * @throws SQLException
     */
    public List<AnalysedData> getAnalysedData(List<String> userIds) throws SQLException {
        ArrayList<AnalysedData> result = new ArrayList<>(getAnalysedData());
        // Remove all entries with users not in userIds
        result.removeIf(entry -> !(userIds.contains(entry.getFrom()) && userIds.contains(entry.getTo())));

        return result;
    }

    /**
     * Returns the date for a selection of users.
     * @param userIds UserIDs the data should be returned for
     * @return A list with the data between the selected users.
     * @throws SQLException
     */
    public List<AnalysedData> getAnalysedData(String... userIds) throws SQLException {
        return getAnalysedData(Arrays.asList(userIds));
    }
}
