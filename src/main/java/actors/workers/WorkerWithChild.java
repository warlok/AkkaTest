package actors.workers;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinPool;
import com.mashape.unirest.http.Unirest;

/**
 * Created by dean on 10.10.16.
 */
public class WorkerWithChild extends UntypedActor {

    ActorRef workerRouter;

    public WorkerWithChild() {
        workerRouter = this.getContext().actorOf(new RoundRobinPool(10).props(HttpWorker.props()));
    }

    @Override
    public void onReceive(Object o) throws Throwable {
        for (int i=0; i<10; i++) workerRouter.tell("test", self());
    }

    public static Props props() {
        return Props.create(WorkerWithChild.class);
    }

}
