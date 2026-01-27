import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public class main {
    public static void main(String[] args) {

        RideBookingSystem rideBookingSystem = new RideBookingSystem();

        User u1 = new User(1, "Aman", "a@mail.com", "123");
        rideBookingSystem.signup(u1);
        //ride book by which user

        rideBookingSystem.createRide(2, "jaipur", "madhubani", 2, 232.00, u1);
        rideBookingSystem.createRide(3, "agar", "new delhi", 5, 232.00, u1);
        List<Ride> result = rideBookingSystem.searchRide("agar", "new delhi", 5);
        System.out.println(result);

    }
}
