package movieBooking;

import lombok.AllArgsConstructor;
import lombok.Data;

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
    Integer cityId;
}

@Data
class Show {
    Integer id;
    String movie;
    Integer cinemaId;
    Integer hallId;
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
}



