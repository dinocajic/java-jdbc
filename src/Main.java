import java.sql.*;

public class Main {

    public static void main(String[] args) {

        hardCodedSqlTest();
        preparedStatementTest("15", "8");
    }

    private static void hardCodedSqlTest() {
        String sql_query = "SELECT * FROM wheels WHERE msrp > '2000'";

        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                );
                ResultSet resultSet = statement.executeQuery( sql_query );
        ){

            Wheel.getWheels( resultSet );
            Wheel.getLastWheel( resultSet );
            Wheel.getFirstWheel( resultSet );
            Wheel.getWheelByRowNum( resultSet );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void preparedStatementTest(String diameter, String width) {

        String sql = "SELECT * FROM wheels WHERE diameter = ? AND width = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish Connection
            connection = DBConnection.getConnection();

            // Prepare the statement
            preparedStatement = connection.prepareStatement( sql );

            // Set the parameters
            preparedStatement.setString(1, diameter);
            preparedStatement.setString(2, width);

            // Execute query
            resultSet = preparedStatement.executeQuery();

            // Send results to getWheels() method in Wheel class
            Wheel.getWheels( resultSet );

        } catch(SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if ( resultSet != null )
                    resultSet.close();

                if ( preparedStatement != null )
                    preparedStatement.close();

                if ( connection != null )
                    connection.close();

            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
