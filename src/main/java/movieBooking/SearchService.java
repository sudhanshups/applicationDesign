package movieBooking;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchService {

    List<City> findCityWithActiveShows() {
        return null;
    }

    Set<String> getMovieByTitle(String title){
        return null;
    }

    //title, language, genre, release date, and city name.
    // ToDo provide a composite serch which support multiple filters

    List<Cinema> getCinemaByMovie(String movieName){
        return null;
    }

    Map<Integer,List<Show>> getShowsByCinemas(List<Integer> cinemaId){
        return null;
    }

}
