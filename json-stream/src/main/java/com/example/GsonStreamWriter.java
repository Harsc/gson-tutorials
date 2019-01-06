package com.example;


import com.google.gson.stream.JsonWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class GsonStreamWriter {

    @Autowired
    private JsonWriter jsonWriter;

    {
        try {
            jsonWriter = new JsonWriter(new FileWriter("json-stream/src/main/resources/gson.json"));
            jsonWriter.beginObject();
            jsonWriter.name("name").value("BMW");
            jsonWriter.name("model").value("X1");
            jsonWriter.name("year").value(2016);

            jsonWriter.name("colors");
            jsonWriter.beginArray();
            jsonWriter.value("RED");
            jsonWriter.value("YEALLOW");
            jsonWriter.value("WHITE");
            jsonWriter.endArray();

            jsonWriter.endObject();
            jsonWriter.close();
            log.info("close");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
