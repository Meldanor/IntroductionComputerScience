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

public class Cylinder extends Present {
    private final double height; // in meter
    private final double diameter; // in meter

    public Cylinder(final double height, final double diameter) {
        this.height = height;
        this.diameter = diameter;
    }

    @Override
    public double surface() {
        return Math.PI * diameter * height * (height + diameter);
    }

    @Override
    public double computeRibbonLength() {
        return (height + diameter) * 4 * 1.1;
    }

}
