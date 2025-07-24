package group.Reiz.Project.Adapters.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class loginResponseDTO {
    private String token;
    private String message;
}
