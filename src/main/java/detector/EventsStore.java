package detector;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import detector.Exception.IncidenciaException;

public class EventsStore {
    public List<Event> eventsList;

    private void load () {
		try
		{
			JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir") + "/Store/eventStore.json"));
			Gson gson = new Gson();
			Event [] myArray = gson.fromJson(reader, Event[].class);
			this.eventsList = new ArrayList<Event>();
			for (Event event: myArray) {
				this.eventsList.add(event);
			}
		}
		catch (Exception ex)
		{		
			this.eventsList = new ArrayList<Event>();
		}	
    }
    
    public void add (Event newEvent) throws IncidenciaException {
		this.load();
		if (find(newEvent.device.getValue())==null) {
			eventsList.add(newEvent);
			this.save();
		}
    }

    private void save() throws IncidenciaException {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonString = gson.toJson(this.eventsList);
        FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(System.getProperty("user.dir") + "/Store/tokenStore.json");
	        fileWriter.write(jsonString);
	        fileWriter.close();
		} catch (IOException e) {
			throw new IncidenciaException("Error: Unable to save a new event in the internal licenses store");
		}
    }
    
    public Event find (String eventIDToFind) {
		Event result = null;
		this.load();
	    for (Event event : this.eventsList) {
	        if (event.device.equals(eventIDToFind)) {
	        	result = event;
	        }
	    }
		return result;
	}
}
