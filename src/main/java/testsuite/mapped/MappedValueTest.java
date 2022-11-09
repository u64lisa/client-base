package testsuite.mapped;

import io.nicky.client.base.mapping.MappedValue;

public final class MappedValueTest {
    private Integer myValue = 100;

    private final MappedValue<Integer> mappedValue = new MappedValue<Integer>()
            .setResolveMethod(() -> this.myValue)
            .setUpdateMethod(element -> this.myValue = element)
            .build();

    public static void main(String[] args) {
        final MappedValueTest valueTest = new MappedValueTest();

        System.out.printf("%d pre", valueTest.mappedValue.getValue());

        valueTest.mappedValue.setValue(69);
        System.out.printf("%d after", valueTest.mappedValue.getValue());

        valueTest.mappedValue.reset();
        System.out.printf("%d reset!", valueTest.mappedValue.getValue());
    }
}
