/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training9.presents;

public class Cuboid extends Present {

    private final double length; // in meter
    private final double width; // in meter
    private final double height; // in meter

    public Cuboid(final double length, final double width, final double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double surface() {
        return 2 * (length * width + length * height + width * height);
    }

    @Override
    public double computeRibbonLength() {
        return (2 * (width + height) + 2 * (length + height)) *  1.1;
    }
}
