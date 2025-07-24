package group.Reiz.Project.Adapters;

public interface IpasswordEncoder {
    String encodePassword(String password);
    boolean checkPassword(String password, String hashed);
}
