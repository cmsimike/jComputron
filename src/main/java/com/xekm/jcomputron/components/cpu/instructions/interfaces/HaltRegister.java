/**
 *
 * jComputron
 *
 * Author:
 *   mike
 *
 * Component:
 *   com.xekm.jcomputron.components.cpu.instructions.interfaces
 *
 * Public class:
 *   HaltRegister.java
 *
 * Overview:
 *   (What is this class about?)
 *
 * Development history:
 *   Oct 17, 2012 - mike - Created
 */

package com.xekm.jcomputron.components.cpu.instructions.interfaces;

public interface HaltRegister {
    /**
     * Sets the running flag to stop
     */
    void stop();

    /**
     * Checks to see if the halt bit is set
     *
     * @return If the halt bit is set or not
     */
    public boolean isRunning();
}
