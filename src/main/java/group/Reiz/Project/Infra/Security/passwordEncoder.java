package group.Reiz.Project.Infra.Security;

import org.springframework.security.crypto.bcrypt.BCrypt;

import group.Reiz.Project.Adapters.IpasswordEncoder;

public class passwordEncoder implements IpasswordEncoder {
    public String encodePassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
