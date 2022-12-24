package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataReader {
    public DataReader() {
    }

    public static <T> T writeToModel(String a, Class<?> t) {
        Gson gson = new GsonBuilder().create();
        System.out.println();
        return gson.fromJson(a, (Type) t);
    }

    private static final String dataPathData = "src/test/resources/data.json";
    private static final String dataPathConfig = "src/test/resources/config.json";

    public static String TestdataContentData;
    public static String TestdataContentConfig;


    static {
        try {
            TestdataContentData = new String(Files.readAllBytes(Paths.get(dataPathData)));
            TestdataContentConfig = new String(Files.readAllBytes(Paths.get(dataPathConfig)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}