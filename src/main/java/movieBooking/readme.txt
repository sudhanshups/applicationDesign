Use case:

1. It should be able to list the cities where affiliate cinemas are located. (CityFinder)
2. Customers should be able to search movies by their title, language, genre, release date, and city name. (MovieService)
3. Once the customer selects a movie, the service should display the cinemas running that movie and its available shows.
4. The customer should be able to select a show at a particular cinema and book their tickets.(MovieShowService, BookingService)




FLOW:

1. User calls cityfinder service to get all cities with atleast one cinema (CityFinder.getCityWithCinema)
2. User selects a city and fetches all the cinema for the city (CinemaService.getAllCinemas)
3. User selects a cinema and get all movies (MovieService.getAllMovieShowForCinema)
4. User selects a movie show and get all available seats (MovieShowService.getAudiInfoForMovieShow)
5. User selects seats and attempt the booking (BookingService.bookMovieShow)
6. User invokes the payment service
