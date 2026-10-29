
package ticketbooking2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatAvailabilityService {

    public String checkAvailability(
            String matchName,
            String venue,
            String matchTime,
            String matchDate) {

        String capacitySql = """
            SELECT total_seats
            FROM match_capacity
            WHERE match_name = ?
              AND venue = ?
              AND match_time = ?
              AND match_date = ?
            """;

        String bookedSql = """
            SELECT COALESCE(SUM(quantity), 0) AS booked_seats
            FROM bookings
            WHERE match_name = ?
              AND venue = ?
              AND match_time = ?
              AND match_date = ?
            """;

        try (Connection con = DatabaseConnection.getConnection()) {

            // Read configured capacity for the selected match.
            int totalSeats;

            try (PreparedStatement ps =
                    con.prepareStatement(capacitySql)) {

                ps.setString(1, matchName);
                ps.setString(2, venue);
                ps.setString(3, matchTime);
                ps.setString(4, matchDate);

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        return "Capacity is not configured for this match. "
                             + "Please contact the administrator.";
                    }

                    totalSeats = rs.getInt("total_seats");
                }
            }

            // Calculate the number of booked seats.
            int bookedSeats;

            try (PreparedStatement ps =
                    con.prepareStatement(bookedSql)) {

                ps.setString(1, matchName);
                ps.setString(2, venue);
                ps.setString(3, matchTime);
                ps.setString(4, matchDate);

                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                    bookedSeats = rs.getInt("booked_seats");
                }
            }

            if (totalSeats <= 0
                    || bookedSeats < 0
                    || bookedSeats > totalSeats) {
                return "Invalid seat data. Please contact the administrator.";
            }

            int availableSeats = totalSeats - bookedSeats;

            if (availableSeats == 0) {
                return "Match sold out! No seats available."
                     + "\nTotal Seats: " + totalSeats
                     + "\nBooked Seats: " + bookedSeats;
            }

            return "Seat Availability"
                 + "\nMatch: " + matchName
                 + "\nVenue: " + venue
                 + "\nTotal Seats: " + totalSeats
                 + "\nBooked Seats: " + bookedSeats
                 + "\nAvailable Seats: " + availableSeats;

        } catch (SQLException e) {
            System.err.println(
                "Seat availability error: " + e.getMessage()
            );
            return "Unable to check availability. Please try again.";
        }
    }
}
