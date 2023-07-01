import java.util.Scanner;

class Reservation {
    private int reservationId;
    private String passengerName;
    private String trainNumber;
    private int seatNumber;

    public Reservation(int reservationId, String passengerName, String trainNumber, int seatNumber) {
        this.reservationId = reservationId;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.seatNumber = seatNumber;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void confirmReservation() {
        System.out.println("Reservation confirmed for passenger: " + passengerName);
    }

    public void cancelReservation() {
        System.out.println("Reservation canceled for passenger: " + passengerName);
    }
}

class ReservationManagementSystem {
    private Reservation[] reservations;
    private int reservationCount;

    public ReservationManagementSystem() {
        reservations = new Reservation[100]; // Assuming a maximum of 100 reservations
        reservationCount = 0;
    }

    public void addReservation(Reservation reservation) {
        reservations[reservationCount] = reservation;
        reservationCount++;
    }

    public void confirmReservation(int reservationId) {
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].getReservationId() == reservationId) {
                reservations[i].confirmReservation();
                return;
            }
        }
        System.out.println("Reservation not found with ID: " + reservationId);
    }

    public void cancelReservation(int reservationId) {
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].getReservationId() == reservationId) {
                reservations[i].cancelReservation();
                // Remove the reservation from the array
                for (int j = i; j < reservationCount - 1; j++) {
                    reservations[j] = reservations[j + 1];
                }
                reservationCount--;
                return;
            }
        }
        System.out.println("Reservation not found with ID: " + reservationId);
    }
}

public class TrainTicketReservation {
    public static void main(String[] args) {
        ReservationManagementSystem reservationSystem = new ReservationManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Example usage
        Reservation reservation1 = new Reservation(1, "John Doe", "ABC123", 10);
        reservationSystem.addReservation(reservation1);

        Reservation reservation2 = new Reservation(2, "Jane Smith", "DEF456", 20);
        reservationSystem.addReservation(reservation2);

        System.out.print("Enter the reservation ID to confirm: ");
        int confirmId = scanner.nextInt();
        reservationSystem.confirmReservation(confirmId);

        System.out.print("Enter the reservation ID to cancel: ");
        int cancelId = scanner.nextInt();
        reservationSystem.cancelReservation(cancelId);

        scanner.close();
    }
}