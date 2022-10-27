package testsuite.injection;

import io.nicky.client.base.transformation.annotation.*;
import io.nicky.client.base.transformation.targets.TargetType;
import testsuite.event.EventBusTest;

@Inject(clazz = EventBusTest.class)
public final class InjectionTest {
    @Shadow
    public String name;

    @Transform(method = "test", position = @Position(type = TargetType.HEAD))
    public void test(final int first, final int last) {}

    @Detour(method = "close", position = @Position(type = TargetType.INVOKE))
    public void close() {
        System.out.println("Closing");
    }

    @Rewrite(method = "toString")
    public String rewrittenToString() {
        return "Test";
    }
}
