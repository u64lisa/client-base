package io.nicky.client.base.interfaces;

public interface Cast {
    @SuppressWarnings("unchecked")
    static <Result> Result perform(final Object javaObject) {
        try {
            assert javaObject != null;
            return (Result) javaObject;
        } catch (final ClassCastException exception) {
            throw new RuntimeException(exception);
        } catch (final Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
