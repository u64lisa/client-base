package io.nicky.client.base.interfaces;

public interface Cast {

    @SuppressWarnings("all")
    public static <Result> Result perform(final Object javaObject) {
        try {
            assert javaObject != null;

            return (Result) javaObject;
        } catch (final Throwable throwable) {
            if (throwable instanceof ClassCastException castException)
                throw new RuntimeException(castException);
            else
                throwable.printStackTrace();
        }
        return null;
    }

}
