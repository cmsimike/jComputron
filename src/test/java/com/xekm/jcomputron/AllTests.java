/**
 * jcomputron
 *
 * Author:
 *   mike
 *
 * Component:
 *   com.xekm.jcomputron
 *
 * Public class:
 *   AllTests.java
 *
 * Overview:
 *   (What is this class about?)
 *
 * Development history:
 *   Sep 21, 2012 - mike - Created
 */

package com.xekm.jcomputron;

import com.xekm.jcomputron.components.basic.ByteTest;
import com.xekm.jcomputron.util.HexToBooleanArrayTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ByteTest.class, HexToBooleanArrayTest.class})
public class AllTests {

}
