/**
 * User: mike 
 * Date: 9/19/12 
 *
 * Basic Byte class for the computer
 */

package com.xekm.jcomputron.components.basic;

import com.xekm.jcomputron.Util;

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
     *
     * @param seven
     * @param six
     * @param five
     * @param four
     * @param three
     * @param two
     * @param one
     * @param zero
     */
    public Byte(boolean seven, boolean six, boolean five, boolean four,
                boolean three, boolean two, boolean one, boolean zero) {
        this(new boolean[]{seven, six, five, four, three, two, one, zero});
    }

    /**
     * Constructor that creates a byte where all the bits are unset.
     */
    public Byte() {
        this(false, false, false, false, false, false, false, false);
    }

    @Override
    public Byte clone() {
        return new Byte(this.theByte);
    }

    /**
     * Returns the bit that is at the position given. Order [7,6,5,4,3,2,1,0]
     *
     * @param location
     * @return
     */
    public boolean getBitAt(int location) {
        return this.theByte[location];
    }

    public boolean[] getByteArray() {
        return this.theByte.clone();
    }

    @Override
    public String toString() {
        StringBuffer b = new StringBuffer();

        for (int i = 0; i < this.getByteArray().length; i++) {
            if (b.length() > 0) {
                b.append(", ");
            }
            b.append(this.theByte[i] ? 1 : 0);
        }

        return "[" + b.toString() + "]";
    }

    public boolean[] getHighOrderNibble() {
        return new boolean[] {
                this.theByte[0],this.theByte[1],this.theByte[2],this.theByte[3]

        };
    }

    public boolean[] getLowOrderNibble() {
        return new boolean[] {
                this.theByte[4],this.theByte[5],this.theByte[6],this.theByte[7]

        };
    }

    public int toInt() {
        int[] multiply = {128, 64, 32, 16, 8, 4, 2, 1};
        int total = 0;

        for(int i = 0; i < 8; i++){
            total += (this.theByte[i] ? multiply[i] : 0);
        }

        return total;
    }

    public String toHex() {
        return Util.intToHex(this.toInt());
    }
}
