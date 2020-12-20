import java.sql.*;

import java.util.*;

/**
 * Created in HalleInterface : PACKAGE_NAME
 * on 20.12.2020 : 13:41 .
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
}
