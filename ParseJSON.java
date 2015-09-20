import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

/**
 *
 * @author admin
 * Gets from JSON data with DESCRIPTIONS:
 * "DESCRIPTION": "U.S. (50 States)",
 * "DESCRIPTION": "Europe"
 */
public class ParseJSON {
    public static void main(String[] args) throws MalformedURLException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMM" );
        String end = formatter.format(new java.util.Date()); // параметр для URL
        String sURL = "http://www.eia.gov/beta/steo/dataService.cfc?v=6&f=M&start=201501&end="+end+"&maptype=0&ctype=linechart&method=getData";
         // Connect to the URL using java's native library
        URL url = new URL(sURL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        
        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
        //String desc = rootobj.get("DESCRIPTION").getAsString(); 
        
        System.out.println(rootobj.toString());
    }
    
}
