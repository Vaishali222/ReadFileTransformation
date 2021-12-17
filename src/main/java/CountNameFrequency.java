import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CountNameFrequency implements CountNameFrequency_Interface {

    final static String filePath = "src/main/java/FileData/FileToReadNames";

    @Override
    public Map<String, String> makeMapfromTextFile() {

        Map<String, String> map = new HashMap<String, String>();
        BufferedReader buff = null;

        try {
            File myFile = new File(filePath);
            buff = new BufferedReader(new FileReader(myFile));

            String lineBreak = null;
            while ((lineBreak = buff.readLine()) != null) {
                String[] parts = lineBreak.split(" ");
                for(String wordBreak : parts) {
                    map.put(wordBreak,(map.containsKey(wordBreak))?Integer.toString((Integer.parseInt(map.get(wordBreak)) + 1)) : "1");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();


        }
        finally {
            if (buff != null) {
                try {
                    buff.close();
                } catch (Exception e) {
                    e.printStackTrace();
                };
            }
        }

        return map;
    }

}
