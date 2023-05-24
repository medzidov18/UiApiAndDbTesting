package datareadmain.models;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ScriptsDTO {
    private String closeWindowJavaScriptCommand;
}
