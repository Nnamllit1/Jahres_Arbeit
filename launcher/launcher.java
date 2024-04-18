import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class launcher {

    public static void main(String[] args) {
        String programName = "luncher";
        String programVersion = "0.0.1";
        String downloadUrl = getDownloadUrl(programName, programVersion);
        System.out.println(downloadUrl);
    }

    public static String getDownloadUrl(String programName, String programVersion) {
        String urlString = "https://raw.githubusercontent.com/Nnamllit1/Jahres_Arbeit/main/update/Vers.txt";
        try {
            URI uri = new URI(urlString);
            URL url = uri.toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            JSONObject json = new JSONObject(result.toString());
            JSONArray jsonArray = json.getJSONArray(programName);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getString("version").equals(programVersion)) {
                    return jsonObject.getString("download");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
