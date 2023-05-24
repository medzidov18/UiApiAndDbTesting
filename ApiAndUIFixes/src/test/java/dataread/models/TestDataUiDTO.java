package dataread.models;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class TestDataUiDTO {
    private Integer minLenghtOfProjectName;
    private Integer maxLenghtOfProjectName;
}
