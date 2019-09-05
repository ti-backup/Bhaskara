package com.example.bhaskara;

public class MathUtil {
    public Double CalculaDelta(Double a, Double b, Double c){
        return Math.pow(b, 2.0) - 4 * a * c;
    }

    public Double[] CalculaRaizesEq2Grau(Double a, Double b, Double c){
        Double delta = CalculaDelta(a, b, c);
        Double[] raizes = null;

        if (delta >= 0){
            raizes = new Double[2];
            raizes[0] = (b * -1 + Math.sqrt(delta)) / (2 * a);

            if (delta == 0) raizes[1] = raizes[0];
            else raizes[1] = (b * -1 - Math.sqrt(delta)) / (2 * a);
        }
        return raizes;
    }
}
