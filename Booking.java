public class Booking {
    int id;
    Ride ride;
    User user;
    int seatsBooked;
    double totalFare;

    public Booking( int id,Ride ride, User User, int seatsBooked) {
        this.id = id;
        this.ride = ride;
        User = user;
        this.seatsBooked = seatsBooked;
        this.totalFare = totalFare * seatsBooked;
    }
    @Override
    public String toString() {
        return "Booking{" +
                "User: " + user.name +
                "id=" + id +
                ", ride=" + ride +
                ", user=" + user +
                ", seats_book=" + seatsBooked +
                ", total_fare=" + totalFare +
                '}';
    }
}
