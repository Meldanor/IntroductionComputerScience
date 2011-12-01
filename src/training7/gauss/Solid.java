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

    /**
     * Add a element of the Solid to this element. Doesn't change the Solid
     * itself, create a new one
     * 
     * @param s
     *            The other summand
     * @return The sum of both elements
     */
    public Solid add(Solid s);

    /**
     * Multiply an element s of this Solid to this element. Doesn't change the
     * Solid itself, create a new one
     * 
     * @param s
     *            The factor
     * @return The product of both elements
     */
    public Solid mult(Solid s);

    /**
     * Returns the factor of the Solid, which solves: s / x = neutral element of
     * Solid
     * 
     * @param s
     *            The element searches for the inverse
     * @return The inverse element of s
     */
    public Solid getInverse(Solid s);

    /**
     * Convert the Solid to a readable format
     * 
     * @return
     */
    public String toString();

    /**
     * @return Is the element the neutral element of addition?
     */
    public boolean isOneElement();

    /**
     * @return Is the element the neutral element of multiplication?
     */
    public boolean isZeroElement();
}
