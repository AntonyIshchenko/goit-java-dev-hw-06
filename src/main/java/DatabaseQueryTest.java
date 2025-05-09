import data_structures.ClientProjectCount;
import data_structures.ProjectDuration;
import data_structures.WorkerAgeTypesDetail;
import data_structures.WorkerSalary;

import java.util.List;

public class DatabaseQueryTest {
    public static void main(String[] args) {
        String delimiter = "----------------------";
        List<ProjectDuration> longestProjects = DatabaseQueryService.findLongestProject();
        System.out.println("longestProjects = " + longestProjects);

        System.out.println(delimiter);

        List<ClientProjectCount> maxProjectCountClient = DatabaseQueryService.findMaxProjectsClient();
        System.out.println("maxProjectCountClient = " + maxProjectCountClient);

        System.out.println(delimiter);

        List<WorkerSalary> maxSalaryWorkers = DatabaseQueryService.findMaxSalaryWorker();
        System.out.println("maxSalaryWorkers = " + maxSalaryWorkers);

        System.out.println(delimiter);

        List<WorkerAgeTypesDetail> youngestEldestWorkers = DatabaseQueryService.findYoungestEldestWorkers();
        System.out.println("youngestEldestWorkers = " + youngestEldestWorkers);
    }
}
