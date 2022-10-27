package io.nicky.client.base.module.settings.changable;

public final class ChangeableModeValue extends ChangeableValue {

    private final String[] possible;
    private String value;

    public ChangeableModeValue(String[] possible, String value) {
        this.possible = possible;
        this.value = value;
    }

    public String[] getPossible() {
        return possible;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
