package datareadmain;

import datareadmain.models.*;
import utility.JsonReadUtility;

public class DataRead {
    private static JsonReadUtility jsonReadUtility = new JsonReadUtility();

    public static PathsDTO pathsDTO = jsonReadUtility.jsonToPojo(PathsDTO.class, "paths.json");
    public static ScriptsDTO scriptsDTO = jsonReadUtility.jsonToPojo(ScriptsDTO.class, "scripts.json");
}
