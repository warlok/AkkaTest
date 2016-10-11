import akka.http.javadsl.model.HttpRequest;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Test {

    @org.junit.Test
    public void firstTest() throws UnirestException {
//        HttpRequest request = HttpRequest.GET("/");
        Unirest.get("http://localhost")
                .queryString("name", "Mark")
                .asString();
    }

}
