package testsuite.event;

import io.nicky.client.base.event.EventBus;
import io.nicky.client.base.event.IEventBus;
import io.nicky.client.base.event.defaults.BusDebuggingEvent;

public final class EventBusTest {

    private String name;

    public EventBusTest() {
    }

    public static void main(String[] args) {
        IEventBus eventBus = new EventBus();

        eventBus.registerListener(BusDebuggingEvent.class, () -> true, element -> {
            System.out.println("Called event");
        });

        eventBus.releaseEvent(new BusDebuggingEvent<>(null));

    }

}
