package com.example.bhaskara;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class MathUtilTest {
    MathUtil math;

    @Before
    public void setup(){
        math = new MathUtil();
    }

    @Test
    public void CalculaDeltaTest(){
        assertEquals(
                9.0,
                math.CalculaDelta(2.0, 5.0, 2.0),
                0.01);
    }

    @Test
    public void CalculaDeltaZeroTest(){
        assertEquals(
                0.0,
                math.CalculaDelta(4.0, -4.0, 1.0),
                0.01);
    }

    @Test
    public void CalculaRaizesEq2GrauIguaisTest(){
        MathUtil spyMath = spy(math);

        doReturn(0.0)
                .when(spyMath)
                .CalculaDelta(4.0, -4.0, 1.0);

        Double[] aux = spyMath.CalculaRaizesEq2Grau(4.0, -4.0, 1.0);

        assertSame(aux[0], aux[1]);
    }

    @Test
    public void CalculaRaizesEq2GrauNullTest(){
        assertNull(math.CalculaRaizesEq2Grau(1.0, -4.0, 5.0));
    }

    @Test
    public void CalculaRaizesEq2GrauTest(){
        MathUtil spyMath = spy(math);

        doReturn(9.0)
                .when(spyMath)
                .CalculaDelta(2.0, 5.0, 2.0);

        Double[] aux = spyMath.CalculaRaizesEq2Grau(2.0, 5.0, 2.0);
        double[] atual = new double[]{aux[0], aux[1]};
        double[] esperado = new double[]{-0.5, -2.0};

        assertArrayEquals(esperado, atual, 0.01);
    }
}

