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

import java.util.ArrayList;
import java.util.List;

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
        pricePaper *= PRICE_PAPER / 5;

        double priceRibbon = p.computeRibbonLength();
        // not exactly a meter of ribbon -> we have to buy one more
        if (priceRibbon % 1 != 0)
            priceRibbon = Math.floor(priceRibbon) + 1;
        priceRibbon *= PRICE_RIBBON;

        return pricePaper + priceRibbon;
    }

    public static void test() {
        List<Present> list = new ArrayList<Present>();
        Cylinder wineBottle = new Cylinder(0.4, 0.20);
        // Four wine bottles with a height of 40cm and a diameter of 20cm
        list.add(wineBottle);
        list.add(wineBottle);
        list.add(wineBottle);
        list.add(wineBottle);

        // Two gift baskets with a radius of 20cm
        Ball basket = new Ball(0.2);
        list.add(basket);
        list.add(basket);

        // An ugly dwarf -> what else? 30 cm x 30cm and more than half a meter
        // height! The bad boy in the garden!
        Cuboid dwarf = new Cuboid(0.3, 0.3, 0.6);
        list.add(dwarf);

        // A cute teddy -> 20cm x 20cm x 30cm!
        Cuboid teddy = new Cuboid(0.2, 0.2, 0.3);
        list.add(teddy);

        // Anno2070, SW TOR and Zelda Skyward Sword
        Cuboid games = new Cuboid(0.14, 0.02, 0.20);
        list.add(games);
        list.add(games);
        list.add(games);

        double costs = 0.0;

        for (Present present : list)
            costs += calculatePrice(present);

        System.out.println("Costs are : " + costs + " €! Happy Christmas!");
    }
}
