import data_structures.ClientProjectCount;
import data_structures.ProjectDuration;
import data_structures.WorkerAgeTypesDetail;
import data_structures.WorkerSalary;
import utils.FileReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseQueryService {

    private static Statement createStatement() throws SQLException {
        return Database.getInstance().getConnection().createStatement();
    }

    public static List<ClientProjectCount> findMaxProjectsClient() {
        List<ClientProjectCount> result = new ArrayList<>();

        try (Statement st = createStatement()) {
            String sql = FileReader.read("sql/find_max_projects_client.sql");
            if (st.execute(sql)) {
                ResultSet rs = st.getResultSet();
                while (rs.next()) {
                    String name = rs.getString("name");
                    int projectCount = rs.getInt("project_count");

                    result.add(new ClientProjectCount(name, projectCount));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<ProjectDuration> findLongestProject() {
        List<ProjectDuration> result = new ArrayList<>();

        try (Statement st = createStatement()) {
            String sql = FileReader.read("sql/find_longest_project.sql");
            if (st.execute(sql)) {
                ResultSet rs = st.getResultSet();
                while (rs.next()) {
                    String name = rs.getString("name");
                    int duration = rs.getInt("month_count");

                    result.add(new ProjectDuration(name, duration));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<WorkerSalary> findMaxSalaryWorker() {
        List<WorkerSalary> result = new ArrayList<>();

        try (Statement st = createStatement()) {
            String sql = FileReader.read("sql/find_max_salary_worker.sql");
            if (st.execute(sql)) {
                ResultSet rs = st.getResultSet();
                while (rs.next()) {
                    String name = rs.getString("name");
                    int salary = rs.getInt("salary");

                    result.add(new WorkerSalary(name, salary));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<WorkerAgeTypesDetail> findYoungestEldestWorkers() {
        List<WorkerAgeTypesDetail> result = new ArrayList<>();

        try (Statement st = createStatement()) {
            String sql = FileReader.read("sql/find_youngest_eldest_workers.sql");
            if (st.execute(sql)) {
                ResultSet rs = st.getResultSet();
                while (rs.next()) {
                    String name = rs.getString("name");
                    String type = rs.getString("type");
                    Date birthday = rs.getDate("birthday");

                    result.add(new WorkerAgeTypesDetail(type, name, birthday));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
