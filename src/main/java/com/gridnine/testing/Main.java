package com.gridnine.testing;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        List<Flight> flights = Collections.unmodifiableList(FlightBuilder.createFlights());
        List<Flight> tempFly = new ArrayList<>(flights);

        // для использования любого количества фильтров. Мне кажется это наиболее оптимальный вариант
        List<Filter> filters = new LinkedList<Filter>(Arrays.asList(new FilterForUpcomingFlights(),
                new FilterForTransferMoreThan2Hours(), new FilterForDepartureEarlierThanArrival()));
        for (Filter filter : filters) {
            filter.FilterForFlight(tempFly);
        }
        tempFly.stream().forEach(System.out::println);


        filterMethod(new FilterForDepartureEarlierThanArrival(), tempFly);
        filterMethod(new FilterForTransferMoreThan2Hours(), tempFly);
        filterMethod(new FilterForUpcomingFlights(), tempFly);

    }

    /* сделал отдельный метод для применения одного фильтра, но по мне вариант выше лучше, так как он может быть
            более широко использован*/
    public static void filterMethod(Filter filter, List<Flight> flights) {
        filter.FilterForFlight(flights);
        flights.stream().forEach(System.out::println);
    }

}