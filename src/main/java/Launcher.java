import actors.Master;
import actors.workers.HttpWorker;
import actors.workers.WorkerWithChild;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.routing.RoundRobinPool;

public class Launcher {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("HttpRequesterDemo");
        ActorRef worker = system.actorOf(new RoundRobinPool(10).props(HttpWorker.props()));
        ActorRef workerWithChild = system.actorOf(new RoundRobinPool(10).props(WorkerWithChild.props()));
//        ActorRef master = system.actorOf(Master.createMaster(worker));
        ActorRef master = system.actorOf(Master.createMaster(workerWithChild));
        master.tell("str", ActorRef.noSender());
    }

}
