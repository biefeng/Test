package com.biefeng.thinkInJava.constructor;

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}


class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Before draw()");
        draw();
        System.out.println("After draw()");
    }
}

class RoundGlyph extends Glyph {

    private int radius = 1;

    RoundGlyph(int r) {
        this.radius = r;
        System.out.println("RoundGlyph.RoundGlyph().radius " + radius);
    }

    void draw() {
        System.out.println("RoundGlyph.draw.radius = " + radius);
    }

}
