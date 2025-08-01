package group.Reiz.Project.Adapters.DTOs.User;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class createUserDTO {
    private String email;
    private String password;
}
    

