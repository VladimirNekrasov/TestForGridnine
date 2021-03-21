package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

public class FilterForUpcomingFlights implements Filter {

    @Override
    public void FilterForFlight(List<Flight> flights) {

        Iterator<Flight> iter = flights.iterator();
        while (iter.hasNext()) {
            Flight next = iter.next();
            boolean result = false;
            for (Segment s : next.getSegments()) {
                if (s.getDepartureDate().isBefore(LocalDateTime.now())) {
                    result = true;
                    break;
                }
            }
            if (result) {
                iter.remove();
            }
        }
    }
}

