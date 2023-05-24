package dataread;

import dataread.models.*;
import utility.*;

public class DataRead {
    private static JsonReadUtility jsonReadUtility = new JsonReadUtility();

    public static ConfigDataApiDTO configDataApiDTO = jsonReadUtility.jsonToPojo(ConfigDataApiDTO.class, "configApi.json");
    public static TestDataApiDTO testDataApiDTO = jsonReadUtility.jsonToPojo(TestDataApiDTO.class, "testDataApi.json");
    public static ConfigDataUiDTO configDataUiDTO = jsonReadUtility.jsonToPojo(ConfigDataUiDTO.class, "configUI.json");
    public static ConfigDataDbDTO configDataDbDTO = jsonReadUtility.jsonToPojo(ConfigDataDbDTO.class, "configDB.json");
    public static TestDataUiDTO testDataUiDTO = jsonReadUtility.jsonToPojo(TestDataUiDTO.class, "testDataUI.json");
}
