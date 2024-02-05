package Models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Post {
    private int userId;
    public int id;
    private String title;
    private String body;
}