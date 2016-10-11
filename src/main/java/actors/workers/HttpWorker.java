package actors.workers;

import akka.actor.Props;
import akka.actor.UntypedActor;
import com.mashape.unirest.http.Unirest;

public class HttpWorker extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Throwable {
        Unirest.get("http://localhost")
                .queryString("name", "Mark")
                .asString();
    }

    public static Props props() {
        return Props.create(HttpWorker.class);
    }

}
