package com.example;

import com.google.gson.stream.JsonReader;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class GsonStreamReader {

    private JsonReader jsonReader;

    {
        try {
            jsonReader = new JsonReader(new FileReader("json-stream/src/main/resources/gson.json"));
            jsonReader.beginObject();

            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();

                if (nextName.equals("name")) {
                    log.info(jsonReader.nextString());
                } else if (nextName.equals("year")) {
                    log.info(jsonReader.nextString());
                } else if (nextName.equals("model")) {
                    log.info(jsonReader.nextString());
                } else if (nextName.equals("colors")) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        log.info("\t" + jsonReader.nextString());
                    }
                    jsonReader.endArray();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            jsonReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
