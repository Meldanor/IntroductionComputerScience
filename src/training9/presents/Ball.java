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

public class Ball extends Present {

    private final double radius; // in meter

    public Ball(final double radius) {
        this.radius = radius;
    }

    @Override
    public double surface() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double computeRibbonLength() {
        return 4 * Math.PI * radius * 1.1;
    }

}
