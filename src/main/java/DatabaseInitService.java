import utils.FileReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) throws SQLException {
        Database database = Database.getInstance();

        String sql = FileReader.read("sql/init_db.sql");

        try (Statement st = database.getConnection().createStatement()) {
            int result = st.executeUpdate(sql);

            System.out.println("result = " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
