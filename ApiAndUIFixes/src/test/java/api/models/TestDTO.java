package api.models;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class TestDTO {
    private String duration;
    private String method;
    private String name;
    private String startTime;
    private String endTime;
    private String status;
}
