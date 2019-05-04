package movieBooking;

import java.util.List;
import java.util.Set;

class CityService {

    //CityService
    List<City> findCityWithActiveShows() {
        return null;
    }

}


 class BookingService {

    private Ticket bookTicket(Integer customerId, Integer showId, Seat seat) {
        return null;
    }

    public TicketBO bookTicketForCustomer(Integer customerId, Integer showId, Seat seat) {
        return null;
    }


}

 class MovieSearchService {

    Set<Movie> getMovie(MovieSearchRequest request) {
        return null;
    }

    List<Cinema> getCinemaByMovie(String movieName) {
        return null;
    }

    private List<Show> getShowsByCinemas(List<Integer> cinemaIds) {
        return null;
    }

    List<Show> getShowsByCityId(Integer cityId) {
        return null;
    }

}


 class MovieShowService {
    List<Seat> getSeatsByShowId(Integer showId) {
        return null;
    }

}

class PaymentService {

//    void execute(ModeOfPayment ,CustometId , amount){
//
//    }
}