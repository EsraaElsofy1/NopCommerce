package example.utils;

import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonFileManager {
    private JsonNode rootNode;

    public JsonFileManager(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            rootNode = mapper.readTree(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, String>> getArrayData() {
        List<Map<String, String>> dataList = new ArrayList<>();
        if (rootNode.isArray()) {
            for (JsonNode element : rootNode) {
                Map<String, String> map = new HashMap<>();
                element.fieldNames().forEachRemaining(field -> {
                    map.put(field, element.get(field).asText());
                });
                dataList.add(map);
            }
        }
        return dataList;
    }

    public Object[][] getObjectData() {
        List<Map<String, String>> dataList = getArrayData();

        Object[][] data = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }
        return data;
    }
}
