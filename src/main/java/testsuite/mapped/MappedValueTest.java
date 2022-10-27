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

        System.out.println(valueTest.mappedValue.getValue() + " pre");

        valueTest.mappedValue.setValue(69);

        System.out.println(valueTest.mappedValue.getValue() + " after");

        valueTest.mappedValue.reset();

        System.out.println(valueTest.mappedValue.getValue() + " reset!");

    }


}
