import utils.FileReader;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        String sql = FileReader.read("sql/populate_db.sql");

        try (Statement st = database.getConnection().createStatement()) {
            int result = st.executeUpdate(sql);

            System.out.println("result = " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
