/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training7.gauss;

public interface Solid {

    public Solid add(Solid s);

    public Solid sub(Solid s);

    public Solid mult(Solid s);

    public Solid div(Solid s);

    public Solid getInverse(Solid s);

    public String toString();

    public boolean isZero();

    public boolean isOne();
}
