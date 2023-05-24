package dataread.models;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ConfigDataDbDTO {
    private String databaseUrl;
    private String userName;
    private String userPassword;
    private String deleteTestCommand;
    private String deleteProjectCommand;
}
