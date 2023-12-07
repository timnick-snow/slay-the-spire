package com.example.shell.game;

/**
 * @author snow
 * @since 2023/12/7
 */
public class KeyChip {
    private static final int RED = 1;
    private static final int GREEN = 1 << 1;
    private static final int BLUE = 1 << 2;
    private static final int ALL = RED | GREEN | BLUE;
    private int bits;

    public boolean hasAll() {
        return bits == ALL;
    }

    public void addRed() {
        this.bits |= RED;
    }

    public void addBlue() {
        this.bits |= BLUE;
    }

    public void addGreen() {
        this.bits |= GREEN;
    }

    public boolean hasRed() {
        return (bits & RED) != 0;
    }

    public boolean hasBlue() {
        return (bits & BLUE) != 0;
    }

    public boolean hasGreen() {
        return (bits & GREEN) != 0;
    }

    public String format() {
        return "R(%b) G(%b) B(%b)".formatted(hasRed(), hasGreen(), hasBlue());
    }
}
