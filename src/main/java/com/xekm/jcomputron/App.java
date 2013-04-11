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
 *   Jcomputron.java
 *
 * Overview:
 *   (What is this class about?)
 *
 * Development history:
 *   Sep 20, 2012 - mike - Created
 */

package com.xekm.jcomputron;

import com.xekm.jcomputron.components.cpu.CPU;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
    public static void main(String... args) {
        try {
            InputStream in = App.class.getClassLoader().getResourceAsStream(
                    "addition.txt");

            InputStreamReader is = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(is);
            String read = null;
            StringBuffer buffer = new StringBuffer();
            StringBuffer bufferd = new StringBuffer();
            while ((read = br.readLine()) != null) {
                buffer.append(read);
                bufferd.append(read+"|");
            }

            System.err.println("Program loaded: " + bufferd.toString());
            CPU cpu = new CPU(buffer.toString());
            cpu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
