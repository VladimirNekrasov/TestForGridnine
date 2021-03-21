package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

public class FilterForTransferMoreThan2Hours implements Filter {
    @Override
    public void FilterForFlight(List<Flight> flights) {
        Iterator<Flight> iter = flights.iterator();
        while (iter.hasNext()) {
            Flight next = iter.next();
            if (next.getSegments().size() > 1) {
                for (int i = 0; i < next.getSegments().size() - 1; i++) {
                    Segment firstSegment = next.getSegments().get(i);
                    Segment secondSegment = next.getSegments().get(i + 1);
                    LocalDateTime localDateTime = firstSegment.getArrivalDate().plusHours(2);
                    if (secondSegment.getDepartureDate().isAfter(localDateTime)) {
                        iter.remove();
                        break;
                    }
                }
            }
        }
    }
}
