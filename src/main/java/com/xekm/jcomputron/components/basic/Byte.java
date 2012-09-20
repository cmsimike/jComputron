package com.xekm.jcomputron.components.basic;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 9/19/12
 * Basic Byte class for the computer
 */
public class Byte {
    private boolean[] theByte = null;

    /**
     * Takes a boolean array as the starting Byte value
     *
     * @param theByte
     */
    public Byte(boolean[] theByte) {
        if (theByte.length != 8) {
            throw new IllegalArgumentException("Bytes are 8 bits long.");
        }
        this.theByte = theByte.clone();
    }

    /**
     * A constructor that takes in 8 boolean primitives and creates a Byte.
     * @param seven
     * @param six
     * @param five
     * @param four
     * @param three
     * @param two
     * @param one
     * @param zero
     */
    public Byte(boolean seven, boolean six, boolean five, boolean four, boolean three, boolean two, boolean one, boolean zero) {
        this(new boolean[]{seven, six, five, four, three, two, one, zero});
    }

    /**
     * Constructor that creates a byte where all the bits are unset.
     */
    public Byte() {
        this(false, false, false, false, false, false, false, false);
    }

    public boolean[] getByteArray() {
        return this.theByte;
    }
}
