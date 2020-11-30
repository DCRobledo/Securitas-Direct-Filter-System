package detector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import detector.Exception.IncidenciaException;

public class App {
    public static void main(String args[]) {
        //Valid case test
        checkEvent(System.getProperty("user.dir") + "/detector/TestData/validCase.json");

        //Invalid case test
        checkEvent(System.getProperty("user.dir") + "/detector/TestData/invalidCase.json");
    }

    public static void checkEvent(String filePath) {
        // First, we generate the corresponding event object
        Event event = null;
        try {
            event = new Event(filePath);
        } catch (IncidenciaException e) {
            System.err.println(e.message);
            return;
        }

        //Second, we decide if the event is an incidence or not
        if (!isIncidence(event)) {
            //Finally, we store only the non-incidence events for the central system
            try {
                storeRobberyCase(event);
            } catch (IncidenciaException e) {
                System.err.println(e.message);
            }
        }
        else {
            try {
                storeIncidentialCase(event);
            } catch (IncidenciaException e) {
                System.err.println(e.message);
            }
        }
    }

    public static void storeRobberyCase(Event event) throws IncidenciaException {
        try {
            Files.move(Paths.get(event.path.getValue()), Paths.get(System.getProperty("user.dir") + "/Store/robberyCases"));
        } catch (IOException e) {
            throw new IncidenciaException("Error: robbery case could not be stored");
        }
    }

    public static void storeIncidentialCase(Event event) throws IncidenciaException {
        try {
            Files.move(Paths.get(event.path.getValue()), Paths.get(System.getProperty("user.dir") + "/Store/incidentialCases"));
        } catch (IOException e) {
            throw new IncidenciaException("Error: robbery case could not be stored");
        }
    }

    public static boolean isIncidence(Event event) {
        // First, we check if the event is cause by an failure
        if (checkFailure(event)) {
            event.cause.setValue("Failure");
            return true;
        }

        // Second, we check if it is one of possible shock causes
        if (checkShockIncidences(event)) {
            determinateShockEventCause(event);
            return true;
        }

        // Finally, we check all of the remaining possible causes, if false then it is
        // not an incidence
        return checkOtherCauses(event);
    }

    public static boolean checkShockIncidences(Event event) {
        return Integer.parseInt(event.sensorValue.getValue()) > 10;
    }

    public static void determinateShockEventCause(Event event) {
        if (Integer.parseInt(event.sensorValue.getValue()) < 20) {
            event.cause.setValue("Fireworks");
            return;
        }

        if (Integer.parseInt(event.sensorValue.getValue()) < 60) {
            event.cause.setValue("Storm");
            return;
        }

        event.cause.setValue("Earthquake");
    }

    public static boolean checkFailure(Event event) {
        return ((event.battery.getValue().equals("true")) || (!event.medium.getValue().equals("ADSL"))
                || (event.medium.getValue().equals("SIGFOX")));
    }

    private static boolean checkOtherCauses(Event event) {
        switch (event.type.getValue()) {
            case "SMOKE":
                if (Integer.parseInt(event.sensorValue.getValue()) > 70)
                    event.cause.setValue("Fire");
                return true;
            case "WATER":
                if (Integer.parseInt(event.sensorValue.getValue()) > 40)
                    event.cause.setValue("Flood");
                return true;
            case "INHIBITION":
                if (Integer.parseInt(event.sensorValue.getValue()) > 10)
                    event.cause.setValue("Inhibition");
                return true;
            case "AIR":
                if (Integer.parseInt(event.sensorValue.getValue()) > 60)
                    event.cause.setValue("High Pollution");
                return true;
            default:
                return false;
        }
    }

    private boolean checkTooManyEvents(Event event, EventsStore store) {

        /*
         * As we didn't have enough time to accomplish this, we have writting in
         * pseudocode how would it look like
         * 
         * First we get a List of the incidents(events) that happenned to a client 
         * 
         * Begin:
         * var eventsCount = 0;
         * var userEventsList;
         * 
         * for each userEvent in userEventsList :
         *      if |(event.timeStamp - userEvent.timeStamp) < 120| 
         *      eventsCount++;
         *      end if;
         * end for;
         * 
         * //if there has been more than 4 events in a period of 2 minutes, its returns true, else false
         * 
         * return eventsCount > 4;
         *  
         * 
         * 
         * 
         */
        return false;
    }

    private boolean checkSameLocation(Event event, EventsStore store) {

        /*
         * The behaviour of this method is similar to the previous one but we have to
         * get a list of the incidents from a postal code rather than a user To get the
         * postal code from a user, we would have to get it throgh the id number of a
         * incidence The period of time we have decided would be 1 hour
         * 
         * 
         * Begin:
         * 
         * var PostalCodeEventsList;
         * var eventsCount = 0;
         * 
         * for each userEvent in PostalCodeEventsList :
         *      if |(event.timeStamp - userEvent.timeStamp) < 3600| 
         *      eventsCount++;
         *      end if;
         * end for;
         * 
         * //if there has been more than 10 events in a postal code in a period of an hour, its returns true, else false
         * 
         * return eventsCount > 10;
         *  
         * 
         * 
         */

        return false;
    }

    private boolean checkSimilarPatern(Event event, EventsStore store) {
        /*
         * The format of this method is also similar to the other 2 but we would have to
         * get a List of incidences where event.type is the same And we would look if
         * these events happenned in a short period of time of 5 minutes
         * 
         * Begin:
         * 
         * var sameTypeEventList;
         * var eventsCount = 0;
         * 
         * for each userEvent in sameTypeEventList :
         *      if |(event.timeStamp - userEvent.timeStamp) < 300| 
         *      eventsCount++;
         *      end if;
         * end for;
         * 
         * //if there has been more than 10 events in a postal code in a period of 5 minutes, its returns true, else false
         * 
         * return eventsCount > 10;
         * 
         */
        return false;
    }
}
