package Models;

import lombok.Getter;
import lombok.Setter;

public class Post {

    @Getter @Setter
    private int userId;

    @Getter @Setter
    public int id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String body;
}
