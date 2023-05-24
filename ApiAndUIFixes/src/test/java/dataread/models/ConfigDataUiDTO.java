package dataread.models;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ConfigDataUiDTO {
    private String webAppPath;
    private String userLogin;
    private String userPassword;
}
