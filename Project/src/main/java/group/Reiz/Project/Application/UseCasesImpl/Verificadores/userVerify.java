package group.Reiz.Project.Application.UseCasesImpl.Verificadores;


import org.springframework.stereotype.Service;

@Service
public class userVerify {
    
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }
    
    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }
    
}
