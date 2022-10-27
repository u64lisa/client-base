package io.nicky.client.base.math;

/**
 * @author Mojang :shrug:, lumii500pg
 */
public final class TrigoFuncs {
    private static final char SIN_TABLE_CHAR = '\uffff';
    private static final float[] SIN_TABLE = new float[65536];

    static {
        for (int i = 0; i < SIN_TABLE.length; ++i) {
            SIN_TABLE[i] = (float) Math.sin(i * Math.PI * 2.D / 65536.D);
        }
    }

    // @formatter:off
    public static float sin(final float value) { return SIN_TABLE[(int) (value * 10430.378F)           & SIN_TABLE_CHAR]; }
    public static float cos(final float value) { return SIN_TABLE[(int) (value * 10430.378F + 16384.F) & SIN_TABLE_CHAR]; }
    // @formatter:on

}
