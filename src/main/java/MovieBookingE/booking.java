package MovieBookingE;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

enum BookingStatus {
    REQUESTED, PENDING, CONFIRMED, CHECKED_IN, CANCELED, ABANDONED
}

enum SeatType {
    REGULAR, PREMIUM, ACCESSIBLE, SHIPPED, EMERGENCY_EXIT, OTHER
}

enum AccountStatus {
    ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
}

enum PaymentStatus {
    UNPAID, PENDING, COMPLETED, FILLED, DECLINED, CANCELLED, ABANDONED, SETTLING, SETTLED, REFUNDED
}

class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}


abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;

    boolean resetPassword() {
        return true;//should be implemented by different actors
    }
}

abstract class Person extends Account {
    private String name;
    private Address address;
    private String email;
    private String phone;
}

class Customer extends Person {
    boolean makeBooking(Booking booking) {
        return true;
    }

    List<Booking> getBookings() {
        return null;
    }
}

class Admin extends Person {
    boolean addMovie(Movie movie) {
        return true;
    }

    boolean addShow(Show show) {
        return true;
    }

    boolean blockUser(Customer customer) {
        return true;
    }
}

class FrontDeskOfficer extends Person {
    boolean createBooking(Booking booking) {
        return true;
    }
}

class Guest {
    boolean registerAccount() {
        return true;
    }
}


class Show {
    private int showId;
    private Date createdOn;
    private Date startTime;
    private Date endTime;
    private CinemaHall playedAt;
    private Movie movie;
}

class Movie {
    private String title;
    private String description;
    private int durationInMins;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
    private Admin movieAddedBy;

    private List<Show> shows;

    List<Show> getShows() {
        return null;
    }
}


class Booking {
    private String bookingNumber;
    private int numberOfSeats;
    private Date createdOn;
    private BookingStatus status;

    private Show show;
    private List<ShowSeat> seats;
    private Payment payment;

    boolean makePayment(Payment payment) {
        return true;
    }

    boolean cancel() {
        return true;
    }

    boolean assignSeats(List<ShowSeat> seats) {
        return true;
    }
}

class CinemaHallSeat {
    int row;
    int col;
}

class ShowSeat extends CinemaHallSeat {
    private int showSeatId;
    private boolean isReserved;
    private double price;
}

class Cinema {
    private String name;
    private int totalCinemaHalls;
    private Address location;
    private List<CinemaHall> halls;
}

class CinemaHall {
    private String name;
    private int totalSeats;
    //private List<CinemaGallSeat> seats;
    private List<Show> shows;
}


class Payment {
    private double amount;
    private Date createdOn;
    private int transactionId;
    private PaymentStatus status;
}


class City {
    private String name;
    private String state;
    private String zipCode;
}


interface Search {
    List<Movie> searchByTitle(String title);

    List<Movie> searchByLanguage(String language);

    //List<Movie> searchByGenre(String genre);
    //List<Movie> searchByReleaseDate(Date relDate);
    List<Movie> searchByCity(String cityName);
}

class Catalog implements Search {
    HashMap<String, List<Movie>> movieTitles;
    HashMap<String, List<Movie>> movieLanguages;
    HashMap<String, List<Movie>> movieGenres;
    HashMap<Date, List<Movie>> movieReleaseDates;
    HashMap<String, List<Movie>> movieCities;

    public List<Movie> searchByTitle(String title) {
        return movieTitles.get("name");
    }

    public List<Movie> searchByLanguage(String language) {
        return movieLanguages.get(language);
    }

    public List<Movie> searchByCity(String cityName) {
        return movieCities.get(cityName);
    }
}




