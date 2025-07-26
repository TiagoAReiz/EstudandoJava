package group.Reiz.Project.Adapters;

import org.springframework.stereotype.Service;

@Service
public interface IpasswordEncoder {
    String encodePassword(String password);
    boolean checkPassword(String password, String hashed);
}
