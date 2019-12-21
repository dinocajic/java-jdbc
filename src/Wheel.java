import java.sql.ResultSet;
import java.sql.SQLException;

class Wheel {

    static void getWheels(ResultSet resultSet) throws SQLException {

        System.out.println("Displaying all wheels");

        while(resultSet.next()) {
            System.out.println( generatePrintableString( resultSet ) );
        }
    }

    static void getLastWheel(ResultSet resultSet) throws SQLException {

        System.out.println("Last Wheel is");

        resultSet.last();
        System.out.println( generatePrintableString( resultSet ) );
    }

    static void getFirstWheel(ResultSet resultSet) throws SQLException {

        System.out.println("First Wheel is");

        resultSet.first();
        System.out.println( generatePrintableString( resultSet ) );
    }

    static void getWheelByRowNum(ResultSet resultSet) throws SQLException {

        System.out.println("Displaying Wheel By Row #");
        System.out.println("This is not by ID");

        resultSet.absolute(3);
        System.out.println( generatePrintableString( resultSet ) );
    }

    private static String generatePrintableString(ResultSet resultSet) throws SQLException {
        return resultSet.getInt("id") + ". Item Number: "
               + resultSet.getString("itemNumber") + " - "
               + resultSet.getString("diameter") + "x"
               + resultSet.getString("width") + " "
               + resultSet.getString("bolts") + "x"
               + resultSet.getString("boltPattern");
    }
}
