package dataread.models;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class TestDataApiDTO {
    private String sid;
    private String nexagePageName;
    private String variantToTakeTokenApiAndUi;
    private String variantToTakeTokenUiAndDb;
}
