public class User {
    int id;
    String name;
    String email;
    String password;
    User owner;

    public User(int id,String name,  String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", owner=" + owner +
                '}';
    }
}
