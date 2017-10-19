import java.util.Arrays;

<<<<<<< HEAD
public class User implements Comparable<User> {
=======
public class User {
>>>>>>> 621b46cc5688f78ce09ec49461ddfd17bdfd078b
    /** Global counter tracking the next available id **/
    private static int nextId = 1;
    /** Identifier marking that this is the id-th user created **/
    private int id;
    /**
     * For this assignment, age is just an automatically assigned field
     * for the sake of variety.
     */
    private int age;
    private String username;
    private String email;

    public User(String username, String email) {
        id = nextId++;
        this.username = username;
        this.email = email;
        setAge();
    }

    /** Force assign an id to a created user **/
    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        setAge();
    }

    void setAge() {
        age = (id % 13) + 20;
    }

    int getAge() {
        return age;
    }

    int getId() {
        return id;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
<<<<<<< HEAD
        if (!(o instanceof User)) {
            return false;
        } else if (((User) o).getId() == this.getId()){
            if (((User) o).getUsername() == this.getUsername()) {
                if (((User) o).getEmail() == this.getEmail()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int compareTo(User o) {
        if (id == ((User) o).id) {
            return username.compareTo(((User) o).username);
        } else {
            return id - ((User) o).id;
        }

=======
        return false; // FIX ME
>>>>>>> 621b46cc5688f78ce09ec49461ddfd17bdfd078b
    }

    public static void main(String[] args) {
        User[] users = {new User(2, "christine", ""), new User(4, "antares", ""), new User(5, "ching", ""),
                new User(1, "daniel", ""), new User(1, "dan", "")};
        Arrays.sort(users);
        System.out.println(Arrays.toString(users));
    }
}
