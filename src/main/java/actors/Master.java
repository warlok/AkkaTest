package actors;


import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class Master extends UntypedActor {

    private ActorRef workerRouter;

    public Master(ActorRef workerRouter) {
        this.workerRouter = workerRouter;
    }

    @Override
    public void onReceive(Object o) throws Throwable {
//        for (int i=0; i<10; i++) workerRouter.tell("test", self());
        workerRouter.tell("test", self());
    }

    public static Props createMaster(ActorRef workerRouter) {
        return Props.create(Master.class, workerRouter);
    }

}



