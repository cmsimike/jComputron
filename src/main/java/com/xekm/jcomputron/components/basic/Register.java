/**
 * jcomputron
 *
 * Author:
 *   mike
 *
 * Component:
 *   com.xekm.jcomputron.components.basic
 *
 * Public class:
 *   Register.java
 *
 * Overview:
 *   A register on the CPU.
 *
 * Development history:
 *   Sep 20, 2012 - mike - Created
 */

package com.xekm.jcomputron.components.basic;

public class Register {
    private Byte value = null;

    public Byte getValue() {
        return value.clone();
    }

    public void setValue(Byte value) {
        this.value = value.clone();
    }

    public Register(Byte val) {
        this.value = val.clone();
    }

    public Register() {
        this.value = new Byte();
    }

}
