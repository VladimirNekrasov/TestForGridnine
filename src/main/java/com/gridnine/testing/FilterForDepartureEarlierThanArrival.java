package com.gridnine.testing;

import java.util.Iterator;
import java.util.List;

public class FilterForDepartureEarlierThanArrival implements Filter {
    @Override
    public void FilterForFlight(List<Flight> flights) {
        Iterator<Flight> iter = flights.iterator();
        while (iter.hasNext()) {
            Flight next = iter.next();
            boolean needRemove = false;
            for (Segment s : next.getSegments()) {
                if (s.getDepartureDate().isAfter(s.getArrivalDate())) {
                    needRemove = true;
                    break;
                }
            }
            if (needRemove) {
                iter.remove();
            }
        }
    }
}
