
package ticketbooking2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DatabaseConnection {

    private static final String DB_URL;

    static {
        try {
            Path dbFolder = Path.of("database");
            Files.createDirectories(dbFolder);

            Path dbPath = dbFolder.resolve("ticketbooking.db")
                                  .toAbsolutePath();

            DB_URL = "jdbc:sqlite:" + dbPath;

        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // CREATE CUSTOMER TABLE
    public static void createCustomerTable() {

        String sql = """
            CREATE TABLE IF NOT EXISTS newcust (
                regid INTEGER PRIMARY KEY AUTOINCREMENT,
                fname TEXT NOT NULL,
                lname TEXT NOT NULL,
                gender TEXT,
                pincode TEXT,
                contactno TEXT,
                address TEXT,
                state TEXT,
                country TEXT
            )
            """;

        try (Connection con = getConnection();
             java.sql.Statement stmt = con.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Customer table created successfully!");

        } catch (SQLException e) {
            System.err.println("Error creating customer table!");
            e.printStackTrace();
        }
    }

    // CREATE BOOKING TABLE
    public static void createBookingTable() {

        String sql = """
            CREATE TABLE IF NOT EXISTS bookings (
                ticket_id INTEGER PRIMARY KEY AUTOINCREMENT,
                match_name TEXT NOT NULL,
                venue TEXT NOT NULL,
                match_time TEXT NOT NULL,
                match_date TEXT NOT NULL,
                gate_open_time TEXT,
                ticket_price INTEGER NOT NULL,
                quantity INTEGER NOT NULL,
                total_amount INTEGER NOT NULL
            )
            """;

        try (Connection con = getConnection();
             java.sql.Statement stmt = con.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Booking table created successfully!");

        } catch (SQLException e) {
            System.err.println("Error creating booking table!");
            e.printStackTrace();
        }
    }


public static void addCustomerIdToBookings() {

    try (java.sql.Connection con = getConnection();
         java.sql.Statement stmt = con.createStatement()) {

        boolean columnExists = false;

        try (java.sql.ResultSet rs =
                 stmt.executeQuery("PRAGMA table_info(bookings)")) {

            while (rs.next()) {
                if ("customer_id".equalsIgnoreCase(
                        rs.getString("name"))) {
                    columnExists = true;
                    break;
                }
            }
        }

        if (!columnExists) {
            stmt.executeUpdate(
                "ALTER TABLE bookings ADD COLUMN customer_id INTEGER"
            );
            System.out.println("Customer ID column added!");
        } else {
            System.out.println("Customer ID column already exists!");
        }

    } catch (java.sql.SQLException ex) {
        ex.printStackTrace();
    }
}

    // CREATE MATCH CAPACITY TABLE
    public static void createMatchCapacityTable() {

        String sql = """
            CREATE TABLE IF NOT EXISTS match_capacity (
                match_name TEXT NOT NULL,
                venue TEXT NOT NULL,
                match_time TEXT NOT NULL,
                match_date TEXT NOT NULL,
                total_seats INTEGER NOT NULL CHECK (total_seats > 0),
                PRIMARY KEY (
                    match_name, venue, match_time, match_date
                )
            )
            """;

        try (Connection con = getConnection();
             java.sql.Statement stmt = con.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println(
                "Match capacity table created successfully!"
            );

        } catch (SQLException e) {
            System.err.println(
                "Unable to create match capacity table!"
            );
            e.printStackTrace();
        }
    }


    // DISPLAY REGISTERED CUSTOMERS
    public static void showCustomers() {

        String sql = "SELECT regid, fname, lname, contactno FROM newcust";

        try (Connection con = getConnection();
             java.sql.Statement stmt = con.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Registered Customers ---");

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("regid") +
                    " | Name: " + rs.getString("fname") +
                    " " + rs.getString("lname") +
                    " | Contact: " + rs.getString("contactno")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


public static void showBookings() {

    String sql = "SELECT ticket_id, customer_id, match_name FROM bookings";

    try (Connection con = getConnection();
         java.sql.Statement stmt = con.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sql)) {

        System.out.println("\n--- Saved Bookings ---");

        while (rs.next()) {
            System.out.println(
                "Ticket ID: " + rs.getInt("ticket_id") +
                " | Customer ID: " + rs.getString("customer_id") +
                " | Match: " + rs.getString("match_name")
            );
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


   // MAIN METHOD
public static void main(String[] args) {

    try (Connection con = getConnection()) {
        System.out.println("SQLite database connected successfully!");
        System.out.println("Database: " + con.getMetaData().getURL());

    } catch (SQLException e) {
        e.printStackTrace();
        return;
    }

    createCustomerTable();
    createBookingTable();
    addCustomerIdToBookings();
    createMatchCapacityTable();

    showCustomers();
    showBookings();
}
}