/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training5;

import java.math.BigInteger;

public class MyAckermann {

    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static BigInteger ackermann(BigInteger x, BigInteger y) {
        if (y.equals(BigInteger.ZERO))
            return BigInteger.ZERO;
        if (x.equals(BigInteger.ZERO))
            return y.multiply(TWO);
        if (y.equals(BigInteger.ONE))
            return TWO;
        else
            return ackermann(x.subtract(BigInteger.ONE),
                    ackermann(x, y.subtract(BigInteger.ONE)));
    }

    public static void test() {
        // 20
        System.out.println(ackermann(BigInteger.ZERO, BigInteger.TEN));
        // 65536
        System.out.println(ackermann(TWO, TWO.multiply(TWO)));
        // 65536
        System.out.println(ackermann(TWO.add(BigInteger.ONE),
                TWO.add(BigInteger.ONE)));
    }

    //@formatter:off
    /**
     * a ) Trivaler Fall
     * b ) z.Z. ack(1,n) = 2^n
     *     IA   ack(1,1) = 2^1 = 2 (per Defintion)
     *     IV   ack(1,k) = 2^k
     *     IBeh ack(1,k+1) = 2^(k+1)
     *     Ibew ack(1,k+1) = ack(0, ack(1,k))
     *          Nach IV -> = ack(0,2^k) 
     *                     = 2*2^k = 2^(k+1)
     *                     q.e.d
     * c ) z.Z ack(2,n) = 2^2^2^...^2 = hyp(2,n) (nach eigener Definition)
     *         IA  ack(2,2) = ack(1,(ack(2,1))
     *                   2  = 2
     *         IB hyp(2,n+1) = ack(2,n+1)
     *                       = ack(1,(ack(2,n))
     *         Nach IV ->    = ack(1, hyp(2,n))
     *                       = 2^(hyp(2,n))
     *                       = hyp(2,n+1) q.e.d 
     */
    //@formatter:on
}
