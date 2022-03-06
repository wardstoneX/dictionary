import com.JsonParsing.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        BookPojo b1 = new BookPojo();
        b1.setInPrint(true);
        b1.setTitle("life");
        b1.setPublishDate(null);
        BookPojo b2 = new BookPojo();
        b2.setInPrint(false);
        b2.setTitle("hate");
        b2.setPublishDate(null);



        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get("test.json").toFile(), b1);
            String path = "outfile.json";
            mapper.writeValue(new File(path),b2);

            BufferedWriter writer = new BufferedWriter(new FileWriter("outfile.json"));
            String str = Json.prettyPrint(Json.toJson(b1));
            writer.write(str);

            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
