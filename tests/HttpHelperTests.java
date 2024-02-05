import Models.*;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
Test API Documentation:
    URL: https://jsonplaceholder.typicode.com/
*/
public class HttpHelperTests {
    private final String baseApi = "https://jsonplaceholder.typicode.com";

    @Test
    @DisplayName("Performs a basic HTTP GET with default Content-Type header of application/json")
    public void BasicGet(){
        //Arrange
        String getUrl = String.format("%s/posts/1", baseApi);
        Gson gson = new Gson();

        //Act
        String json = HttpHelper.Get(getUrl);
        Post post = gson.fromJson(json, Models.Post.class);

        //Assert
        assertEquals(1, post.getUserId());
        assertEquals(1, post.getId());
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", post.getTitle());
        assertEquals("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto", post.getBody());
    }

    @Test
    @DisplayName("Performs a basic HTTP GET setting the Content-Type header to application/json")
    public void GetWithContentType(){
        //Arrange
        String getUrl = String.format("%s/users/1", baseApi);
        Gson gson = new Gson();

        //Act
        String json = HttpHelper.Get(getUrl, "application/json");
        User user = gson.fromJson(json, Models.User.class);

        //Assert
        assertEquals(1, user.getId());
        assertEquals("Leanne Graham", user.getName());
        assertEquals("Bret", user.getUsername());
        assertEquals("Sincere@april.biz", user.getEmail());
        assertEquals("1-770-736-8031 x56442", user.getPhone());
        assertEquals("hildegard.org", user.getWebsite());

        Address userAddress = user.getAddress();
        assertNotNull(userAddress);
        assertEquals("Kulas Light", userAddress.getStreet());
        assertEquals("Apt. 556", userAddress.getSuite());
        assertEquals("Gwenborough", userAddress.getCity());
        assertEquals("92998-3874", userAddress.getZipcode());

        Geo addressGeo = userAddress.getGeo();
        assertNotNull(addressGeo);
        assertEquals("-37.3159", addressGeo.getLat());
        assertEquals("81.1496", addressGeo.getLng());

        Company userCompany = user.getCompany();
        assertNotNull(userCompany);
        assertEquals("Romaguera-Crona", userCompany.getName());
        assertEquals("Multi-layered client-server neural-net", userCompany.getCatchPhrase());
        assertEquals("harness real-time e-markets", userCompany.getBs());
    }
}