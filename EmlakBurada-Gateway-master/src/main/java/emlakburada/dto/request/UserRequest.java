package emlakburada.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private Integer id;
    //private UserType userType;
    private String name;
    private String email;
    private String bio;
}