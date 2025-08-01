package group.Reiz.Project.Infra.Security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import group.Reiz.Project.Adapters.Security.IpasswordEncoder;


@Service
public class passwordEncoder implements IpasswordEncoder {
    @Override
    public String encodePassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    @Override
    public boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
