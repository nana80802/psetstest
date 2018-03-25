package at.refugeescode.psetstest.pset4.controller;

import at.refugeescode.psetstest.pset4.model.Luggage;
import at.refugeescode.psetstest.pset4.parse.LuggageParser;
import at.refugeescode.psetstest.pset4.util.TimeUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirportTest {
    private Airport airport = new Airport();
    LuggageParser luggageParser = new LuggageParser();
    List<Luggage> departureLuggage = luggageParser.asList("src/main/java/at/refugeescode/psetstest/pset4/data/luggage.csv");

    @Test
    void travel() {
        List<Luggage>   luggageList = airport.travel(departureLuggage);
        int luggageSize = luggageList.size();
        Luggage luggage = luggageList.get(0);
        String report = report(luggage);

        assertEquals(luggageSize, 18);
        assertEquals(report,"Backpack of Hosam arrived to Athens at 23:00 (local time 00:00) and waited a total of 08 hours 20 minutes");
    }

    private String report(Luggage luggage) {
        StringBuilder builder = new StringBuilder();
        builder.append(luggage.getType());
        builder.append(" of ");
        builder.append(luggage.getOwner());
        builder.append(" arrived to ");
        builder.append(luggage.getDestination());
        builder.append(" at ");
        builder.append(TimeUtils.formatTime(luggage.getArrivalTime()));
        builder.append(" (local time ");
        builder.append(TimeUtils.formatLocalTime(luggage.getArrivalTime(), luggage.getDestination()));
        builder.append(") and waited a total of ");
        builder.append(TimeUtils.format(luggage.getWaitingDuration()));

        return builder.toString();
    }
}