/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training4;

@SuppressWarnings("serial")
public class RectangleFake extends java.awt.Rectangle {

    public RectangleFake(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public boolean intersect(RectangleFake r2) {

        return super.intersects(r2);
    }

}
