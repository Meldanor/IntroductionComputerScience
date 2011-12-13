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

public class ChristmasPresents {

    // Costs per roll
    private final static double PRICE_PAPER = 10.0;
    // Costs per meter
    private final static double PRICE_RIBBON = 3.0;

    public static double calculatePrice(Present p) {

        double pricePaper = p.computePaperSize();
        // not exactly a roll -> we have to buy one more
        if (pricePaper % 1 != 0)
            pricePaper = Math.floor(pricePaper) + 1;
        pricePaper *= PRICE_PAPER;

        double priceRibbon = p.computeRibbonLength();
        // not exactly a meter of ribbon -> we have to buy one more
        if (priceRibbon % 1 != 0)
            priceRibbon = Math.floor(priceRibbon) + 1;
        priceRibbon *= PRICE_RIBBON;

        return pricePaper + priceRibbon;
    }

}
