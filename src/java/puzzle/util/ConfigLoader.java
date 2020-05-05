package puzzle.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.util.Map;

public class ConfigLoader {
    public static Gson gson;

    private static ConfigLoader configLoader;

    private Map<Integer, String> imagesPath;
    private Map<String, Object> gameSizes;

    private ConfigLoader() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gson = gsonBuilder.create();
        try {
            loadConfigs();
        } catch (Exception e) {
            System.out.println("failed to load data base!");
            e.printStackTrace();
        }
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            return configLoader = new ConfigLoader();
        } else {
            return configLoader;
        }
    }

    private void loadConfigs() throws Exception {
        imagesPath = loadImagesPath();
        gameSizes = loadGameSizes();
    }

    private Map<Integer, String> loadImagesPath() throws Exception {
        File json = new File("./data/images_path.json");
        json.getParentFile().mkdirs();
        json.createNewFile();
        FileReader fileReader = new FileReader("./data/images_path.json");
        return gson.fromJson(fileReader, new TypeToken<Map<Integer, String>>() {
        }.getType());
    }

    private Map<String, Object> loadGameSizes() throws Exception {
        File json = new File("./data/game_sizes.json");
        json.getParentFile().mkdirs();
        json.createNewFile();
        FileReader fileReader = new FileReader("./data/game_sizes.json");
        return gson.fromJson(fileReader, new TypeToken<Map<String, Object>>() {
        }.getType());
    }

    // Start of getter setter
    public Map<Integer, String> getImagesPath() {
        return imagesPath;
    }

    public Map<String, Object> getGameSizes() {
        return gameSizes;
    }
}
