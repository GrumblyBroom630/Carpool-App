import java.util.ArrayList;
import java.util.List;
public class RideBookingSystem {
    //user
    List<User> userList = new ArrayList<>();
    List<Ride> rideList = new ArrayList<>();
    List<Booking> bookingList = new ArrayList<>();

    public void signup(User user) {
        userList.add(user);
    }

    public User login(String email, String password) {
        for (User u : userList) {
            if (u.email.equals(email) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }



    public void deleteAccount(int id) {
        userList.removeIf(u -> u.id == id);
    }

    public void updateUserDetails(int id, String name) {
        for (User u : userList) {
            if (u.id == id) {
                u.name = name;
            }
        }
    }
    public void createRide(int id, String source, String destination, int seats, double fare, User user) {
        rideList.add(new Ride(id, source, destination, seats, fare, user));
    }

    public List<Ride> showAllRide() {
        return rideList;
    }

    public List<Ride> searchRide(String source, String destination, int seats) {
        List<Ride> available = new ArrayList<>();
        for (Ride r : rideList) {
            if (r.source.equals(source) && r.destination.equals(destination) && r.seats >= seats) {
                available.add(r);
            }
        }
        return available;
    }

    public void updateRide(int rideId, int newSeats, double newFare) {
        for (Ride r : rideList) {
            if (r.id == rideId) {
                r.seats = newSeats;
                r.fare = newFare;
            }
        }
    }

    public void deleteRide(int rideId) {
        rideList.removeIf(r -> r.id == rideId);
    }



    public void bookRide(Ride ride, User user, int seatsBooked) {
        if (ride.seats >= seatsBooked) {
            ride.seats -= seatsBooked;

            Booking b = new Booking(bookingList.size() + 1,
                    ride,
                    user,
                    seatsBooked
            );

            bookingList.add(b);
        } else {
            System.out.println("Not enough seats available");
        }
    }



    public List<Booking> viewRideCreated(User user) {
        List<Booking> list = new ArrayList<>();
        for (Booking b : bookingList) {
            if (b.ride.user.id == user.id) {
                list.add(b);
            }
        }
        return list;
    }


    public void updateBooking(int bookingId, int newSeats) {
        for (Booking b : bookingList) {
            if (b.id == bookingId) {
                int diff = newSeats - b.seatsBooked;
                if (b.ride.seats >= diff) {
                    b.ride.seats -= diff;
                    b.seatsBooked = newSeats;
                    b.totalFare = b.ride.fare * newSeats;
                }
            }
        }
    }

    public void deleteBooking(int bookingId) {
        bookingList.removeIf(b -> b.id == bookingId);
    }
}
