import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

/**
 * Created by deslyxia on 6/23/15.
 */
public class JsonDeserialize {
    private TestData testData = new TestData();
    private static final ObjectMapper mapper = new ObjectMapper();


    public TreeMap<Date,FlightData> getFightData(){
        TreeMap<Date,FlightData> requestedMap = new TreeMap<>();
        ArrayList<FlightData> flightDataList = new ArrayList<>();
        String json = testData.getTestData();

        try{
            flightDataList = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(ArrayList.class,FlightData.class));
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return requestedMap;
    }
}
