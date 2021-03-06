/******************************************************************************
 *                   Confidential Proprietary                                 *
 *         (c) Copyright Haifeng Li 2011, All Rights Reserved                 *
 ******************************************************************************/

package smile.math.matrix;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Haifeng Li
 */
public class LUDecompositionTest {
    double[][] A = {
        {0.9000, 0.4000, 0.7000},
        {0.4000, 0.5000, 0.3000},
        {0.7000, 0.3000, 0.8000}
    };
    double[] B = {0.5, 0.5, 0.5};
    double[] X = {-0.2027027, 0.8783784, 0.4729730};
    double[][] B2 = {
        {0.5, 0.2},
        {0.5, 0.8},
        {0.5, 0.3}
    };
    double[][] X2 = {
        {-0.2027027, -1.2837838},
        {0.8783784, 2.2297297},
        {0.4729730, 0.6621622}
    };

    public LUDecompositionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of solve method, of class LUDecomposition.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        LUDecomposition result = new LUDecomposition(A);
        double[] x = new double[B.length];
        result.solve(B, x);
        assertEquals(X.length, x.length);
        for (int i = 0; i < X.length; i++) {
            assertEquals(X[i], x[i], 1E-7);
        }
    }

    /**
     * Test of solve method, of class LUDecomposition.
     */
    @Test
    public void testSolveoverwrite() {
        System.out.println("solve in place");
        LUDecomposition result = new LUDecomposition(A);
        double[] x = B;
        result.solve(B, x);
        assertEquals(X.length, x.length);
        for (int i = 0; i < X.length; i++) {
            assertEquals(X[i], x[i], 1E-7);
        }
    }

    /**
     * Test of solve method, of class LUDecomposition.
     */
    @Test
    public void testSolveMatrix() {
        System.out.println("solve");
        LUDecomposition result = new LUDecomposition(A);
        double[][] x = new double[B2.length][B2[0].length];
        result.solve(B2, x);
        assertEquals(X2.length, x.length);
        assertEquals(X2[0].length, x[0].length);
        for (int i = 0; i < X2.length; i++) {
            for (int j = 0; j < X2[i].length; j++) {
                assertEquals(X2[i][j], x[i][j], 1E-7);
            }
        }
    }

    /**
     * Test of solve method, of class LUDecomposition.
     */
    @Test
    public void testSolveMatrixOverwrite() {
        System.out.println("solve in place");
        LUDecomposition result = new LUDecomposition(A, true);
        double[][] x = B2;
        result.solve(B2, x);
        assertEquals(X2.length, x.length);
        assertEquals(X2[0].length, x[0].length);
        for (int i = 0; i < X2.length; i++) {
            for (int j = 0; j < X2[i].length; j++) {
                assertEquals(X2[i][j], x[i][j], 1E-7);
            }
        }
    }
}