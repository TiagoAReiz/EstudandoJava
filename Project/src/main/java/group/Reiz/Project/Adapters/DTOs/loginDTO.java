package group.Reiz.Project.Adapters.DTOs;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class loginDTO {
    private String email;
    private String password;


}
