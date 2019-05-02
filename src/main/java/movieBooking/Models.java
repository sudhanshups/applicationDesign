package movieBooking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
class City {
    Integer id;
    String name;
}

@AllArgsConstructor
class Cinema {
    Integer id;
    String name;
    City city;
}

@Data
class Movie {
    Integer id;
    String name;
    Date releaseDate;
    Integer lengthInMinutes;
}

@Data
class Show {
    Integer id;
    Movie movie;
    Cinema cinema;
    Hall hall;
    ShowTiming showTiming;
}

@Data
class Hall {
    Integer id;
    List<Seat> seats;
}

@Data
class Seat {
    Integer id;
    Boolean isAvailable;
}

@Data
class ShowTiming {
    Enum day;
    Integer startTime;
    Integer duration;
}

@Data
class Customer {
    Integer id;
    String name;
}

@Data
class Ticket {
    Integer id;
    Integer customerId;
    Integer showId;
    TicketStatus ticketStatus;
    Double amount;
    //provide show timings
    //customer details
}

@Data
class TicketBO {
    Integer id;
    Customer customer;
    Show show;
    TicketStatus ticketStatus;
    Double amount;
}

enum TicketStatus {
    CONFIRMED, CANCELED, PENDING
}


class MovieSearchRequest {
    String title;
    String language;
    String genre;
    Date releaseDate;
    String cityName;
}


