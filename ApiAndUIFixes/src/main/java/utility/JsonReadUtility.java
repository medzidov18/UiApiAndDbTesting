package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class JsonReadUtility {
    private static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public <T> T jsonToPojo(Class<T> myClassToDeserialize, String fileName) {
        File file = new File(this.getClass().getResource(String.format("/%s", fileName)).getFile());

        return objectMapper.readValue(file, myClassToDeserialize);
    }
}
