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

public abstract class Present {
    public abstract double surface();

    public abstract double computeRibbonLength();

    public double computePaperSize() { // same for all presents
        return surface() * 1.5; // 50% waste
    }
}
