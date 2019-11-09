package splitwise;

import lombok.Data;

@Data
public class User {
    private final int id;
    private String name;

    public User(String name) {
        this.id = IdGenerator.getId();
        this.name = name;
    }
}
