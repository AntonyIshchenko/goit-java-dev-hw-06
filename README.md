## Task 0 - Preparation
Create a new `gradle` project. Add the necessary dependencies to work with the H2 DBMS.
Create a directory named `sql` in the root of your project. Copy all `.sql` files from the previous homework into this directory.

---

## Task 1 – Create a Utility Class for Database Operations

Create a singleton class named `Database` that encapsulates the logic for working with the database. When an instance of this class is created, it should establish a connection to the DBMS and store a `Connection` object. There should be a method `getConnection()` to retrieve the connection. For example:

```java
Connection conn = Database.getInstance().getConnection();
```

---

## Task 2 – Create a Class for Database Initialization

Create a class named `DatabaseInitService`. This class should contain a `public static void main(String[] args)` method that reads the file `sql/init_db.sql` and executes the SQL statements in the database.

Use the previously implemented `Database` class for database operations.

**Expected result**: the database is initialized with correctly created tables and relationships between them.

---

## Task 3 – Create a Class for Populating Database Tables

Create a class named `DatabasePopulateService`. This class should contain a `public static void main(String[] args)` method that reads the file `sql/populate_db.sql` and executes the SQL statements in the database.

Use the previously implemented `Database` class for database operations.

**Expected result**: database tables are filled with data.

---

## Task 4 – Create a Class for Querying Data from the Database

Create a class named `DatabaseQueryService`. This class should contain a method for each `.sql` file with a `SELECT` query from the previous task. Each method should:

- Read the corresponding `.sql` file
- Return the required result

Name each method according to the Java Code Conventions. Make sure each method returns the correct type. For example, for the file `find_max_projects_client.sql`, the method signature would be: `List<MaxProjectCountClient> findMaxProjectsClient()`. Define the `MaxProjectCountClient` class like this:

```java
public class MaxProjectCountClient {
    private String name;
    private int projectCount;
}
```

Use the previously implemented `Database` class for database operations.

**Expected result**: methods for each `SELECT` query that can be invoked as follows:

```java
List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
```

Run each method and verify that it returns the correct information and does not throw any exceptions during execution.
