package io.nicky.client.base.mapping;

import io.nicky.client.base.interfaces.Callback;
import io.nicky.client.base.interfaces.Supplier;

public final class MappedValue<Value> {

    private Callback<Value> valueChanger;
    private Supplier<Value> valueCallback;

    private Value defaultValue;

    public MappedValue<Value> setUpdateMethod(final Callback<Value> valueSupplier) {
        this.valueChanger = valueSupplier;
        return this;
    }

    public MappedValue<Value> setResolveMethod(final Supplier<Value> valueCallback) {
        this.valueCallback = valueCallback;
        return this;
    }

    public MappedValue<Value> build() {
        if (valueCallback != null)
            this.defaultValue = this.valueCallback.supply();

        if (this.valueCallback == null || this.valueChanger == null)
            throw new IllegalStateException("Missing Resolve method or Update method");

        return this;
    }

    public void setValue(final Value value) {
        if (valueCallback != null)
            this.defaultValue = this.valueCallback.supply();

        this.valueChanger.accept(value);
    }

    public Value getValue() {
        return this.valueCallback.supply();
    }

    public void reset() {
        this.valueChanger.accept(this.defaultValue);
    }

}
