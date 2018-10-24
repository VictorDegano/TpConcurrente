package concurrTP;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ConcurVectorTest {

    private ConcurVector concurVectorSut;
    private ConcurVector concurVectorSutRecursive;

    @Before
    public void setUp() throws Exception
    {
        this.concurVectorSut            = new ConcurVector(10, 2, 2);
        this.concurVectorSutRecursive   = new ConcurVector(25, 2, 2);
    }

    @Test
    public void set()
    {
        this.concurVectorSut.set(0, 2);
        this.concurVectorSut.set(1, 5);
        this.concurVectorSut.set(2, 2);
        this.concurVectorSut.set(3, 4);
        this.concurVectorSut.set(4, 7);

        this.concurVectorSut.set(10);

        assertTrue(10 == this.concurVectorSut.get(0));
        assertTrue(10 == this.concurVectorSut.get(1));
        assertTrue(10 == this.concurVectorSut.get(2));
        assertTrue(10 == this.concurVectorSut.get(3));
        assertTrue(10 == this.concurVectorSut.get(4));
        assertTrue(10 == this.concurVectorSut.get(5));
        assertTrue(10 == this.concurVectorSut.get(6));
        assertTrue(10 == this.concurVectorSut.get(7));
        assertTrue(10 == this.concurVectorSut.get(8));
        assertTrue(10 == this.concurVectorSut.get(9));

    }

    @Test
    public void assign()
    {
        this.concurVectorSut.set(0, 2);
        this.concurVectorSut.set(1, 5);
        this.concurVectorSut.set(2, 2);
        this.concurVectorSut.set(3, 4);
        this.concurVectorSut.set(4, 7);
        this.concurVectorSut.set(5, 4);
        this.concurVectorSut.set(6, 7);
        this.concurVectorSut.set(7, 5);
        this.concurVectorSut.set(8, 23);
        this.concurVectorSut.set(9, 7);

        SeqVector other = new SeqVector(10);
        other.set(0, 0);
        other.set(1, 3);
        other.set(0, 0);
        other.set(3, 3);
        other.set(4, 4);
        other.set(5, 5);
        other.set(6, 6);
        other.set(7, 0);
        other.set(8, 3);
        other.set(9, 0);

        this.concurVectorSut.assign(other);

        assertTrue(0 == this.concurVectorSut.get(0));
        assertTrue(3 == this.concurVectorSut.get(1));
        assertTrue(0 == this.concurVectorSut.get(2));
        assertTrue(3 == this.concurVectorSut.get(3));
        assertTrue(4 == this.concurVectorSut.get(4));
        assertTrue(5 == this.concurVectorSut.get(5));
        assertTrue(6 == this.concurVectorSut.get(6));
        assertTrue(0 == this.concurVectorSut.get(7));
        assertTrue(3 == this.concurVectorSut.get(8));
        assertTrue(0 == this.concurVectorSut.get(9));

    }

    @Test
    public void assignMask()
    {
        this.concurVectorSut.set(0, 2);
        this.concurVectorSut.set(1, 5);
        this.concurVectorSut.set(2, 2);
        this.concurVectorSut.set(3, 4);
        this.concurVectorSut.set(4, 7);
        this.concurVectorSut.set(5, 4);
        this.concurVectorSut.set(6, 7);
        this.concurVectorSut.set(7, 5);
        this.concurVectorSut.set(8, 23);
        this.concurVectorSut.set(9, 7);

        SeqVector other = new SeqVector(10);
        other.set(0, 0);
        other.set(1, 3);
        other.set(0, 0);
        other.set(3, 3);
        other.set(4, 4);
        other.set(5, 5);
        other.set(6, 6);
        other.set(7, 0);
        other.set(8, 3);
        other.set(9, 0);

        SeqVector mask = new SeqVector(10);
        mask.set(0, 0);
        mask.set(1, 1);
        mask.set(2, 1);
        mask.set(3, 0);
        mask.set(4, 0);
        mask.set(5, 0);
        mask.set(6, 0);
        mask.set(7, 1);
        mask.set(8, 1);
        mask.set(9, 0);

        this.concurVectorSut.assign(mask, other);

        assertTrue(2 == this.concurVectorSut.get(0));
        assertTrue(3 == this.concurVectorSut.get(1));
        assertTrue(0 == this.concurVectorSut.get(2));
        assertTrue(4 == this.concurVectorSut.get(3));
        assertTrue(7 == this.concurVectorSut.get(4));
        assertTrue(4 == this.concurVectorSut.get(5));
        assertTrue(7 == this.concurVectorSut.get(6));
        assertTrue(0 == this.concurVectorSut.get(7));
        assertTrue(3 == this.concurVectorSut.get(8));
        assertTrue(7 == this.concurVectorSut.get(9));

    }

    @Test
    public void add()
    {
        this.concurVectorSut.set(0, 2);
        this.concurVectorSut.set(1, 5);
        this.concurVectorSut.set(2, 2);
        this.concurVectorSut.set(3, 4);
        this.concurVectorSut.set(4, 7);
        this.concurVectorSut.set(5, 4);
        this.concurVectorSut.set(6, 7);
        this.concurVectorSut.set(7, 5);
        this.concurVectorSut.set(8, 23);
        this.concurVectorSut.set(9, 7);

        SeqVector other = new SeqVector(10);
        other.set(0, 0);
        other.set(1, 3);
        other.set(0, 0);
        other.set(3, 3);
        other.set(4, 4);
        other.set(5, 5);
        other.set(6, 6);
        other.set(7, 0);
        other.set(8, 3);
        other.set(9, 0);

        this.concurVectorSut.add(other);

        assertTrue( 2 == this.concurVectorSut.get(0));
        assertTrue( 8 == this.concurVectorSut.get(1));
        assertTrue( 2 == this.concurVectorSut.get(2));
        assertTrue( 7 == this.concurVectorSut.get(3));
        assertTrue(11 == this.concurVectorSut.get(4));
        assertTrue( 9 == this.concurVectorSut.get(5));
        assertTrue(13 == this.concurVectorSut.get(6));
        assertTrue( 5 == this.concurVectorSut.get(7));
        assertTrue(26 == this.concurVectorSut.get(8));
        assertTrue( 7 == this.concurVectorSut.get(9));
    }


    @Test
    public void mul()
    {
        this.concurVectorSut.set(0, 2);
        this.concurVectorSut.set(1, 5);
        this.concurVectorSut.set(2, 2);
        this.concurVectorSut.set(3, 4);
        this.concurVectorSut.set(4, 7);
        this.concurVectorSut.set(5, 4);
        this.concurVectorSut.set(6, 7);
        this.concurVectorSut.set(7, 5);
        this.concurVectorSut.set(8, 23);
        this.concurVectorSut.set(9, 7);

        SeqVector other = new SeqVector(10);
        other.set(0, 0);
        other.set(1, 3);
        other.set(0, 0);
        other.set(3, 3);
        other.set(4, 4);
        other.set(5, 5);
        other.set(6, 6);
        other.set(7, 0);
        other.set(8, 3);
        other.set(9, 0);

        this.concurVectorSut.mul(other);

        assertTrue( 0 == this.concurVectorSut.get(0));
        assertTrue(15 == this.concurVectorSut.get(1));
        assertTrue( 0 == this.concurVectorSut.get(2));
        assertTrue(12 == this.concurVectorSut.get(3));
        assertTrue(28 == this.concurVectorSut.get(4));
        assertTrue(20 == this.concurVectorSut.get(5));
        assertTrue(42 == this.concurVectorSut.get(6));
        assertTrue( 0 == this.concurVectorSut.get(7));
        assertTrue(69 == this.concurVectorSut.get(8));
        assertTrue( 0 == this.concurVectorSut.get(9));
    }


    @Test
    public void abs()
    {
        this.concurVectorSut.set(0,  -2);
        this.concurVectorSut.set(1,   5);
        this.concurVectorSut.set(2,  -2);
        this.concurVectorSut.set(3,  -4);
        this.concurVectorSut.set(4,   7);
        this.concurVectorSut.set(5,  -4);
        this.concurVectorSut.set(6,  -7);
        this.concurVectorSut.set(7,  -5);
        this.concurVectorSut.set(8, -23);
        this.concurVectorSut.set(9,   7);

        this.concurVectorSut.abs();

        assertTrue( 2 == this.concurVectorSut.get(0));
        assertTrue( 5 == this.concurVectorSut.get(1));
        assertTrue( 2 == this.concurVectorSut.get(2));
        assertTrue( 4 == this.concurVectorSut.get(3));
        assertTrue( 7 == this.concurVectorSut.get(4));
        assertTrue( 4 == this.concurVectorSut.get(5));
        assertTrue( 7 == this.concurVectorSut.get(6));
        assertTrue( 5 == this.concurVectorSut.get(7));
        assertTrue(23 == this.concurVectorSut.get(8));
        assertTrue( 7 == this.concurVectorSut.get(9));
    }

    @Test
    public void sum()
    {
        this.concurVectorSut.set(0, 1);
        this.concurVectorSut.set(1, 2);
        this.concurVectorSut.set(2, 3);
        this.concurVectorSut.set(3, 4);
        this.concurVectorSut.set(4, 5);
        this.concurVectorSut.set(5, 6);
        this.concurVectorSut.set(6, 7);
        this.concurVectorSut.set(7, 8);
        this.concurVectorSut.set(8, 9);
        this.concurVectorSut.set(9, 10);

        assertTrue(55 == this.concurVectorSut.sum());
    }

    @Test
    public void sumWithRecursiveJob()
    {
        this.concurVectorSutRecursive.set(0, 1);
        this.concurVectorSutRecursive.set(1, 2);
        this.concurVectorSutRecursive.set(2, 3);
        this.concurVectorSutRecursive.set(3, 4);
        this.concurVectorSutRecursive.set(4, 5);
        this.concurVectorSutRecursive.set(5, 6);
        this.concurVectorSutRecursive.set(6, 7);
        this.concurVectorSutRecursive.set(7, 8);
        this.concurVectorSutRecursive.set(8, 9);
        this.concurVectorSutRecursive.set(9, 10);
        this.concurVectorSutRecursive.set(10, 11);
        this.concurVectorSutRecursive.set(11, 12);
        this.concurVectorSutRecursive.set(12, 13);
        this.concurVectorSutRecursive.set(13, 14);
        this.concurVectorSutRecursive.set(14, 15);
        this.concurVectorSutRecursive.set(15, 16);
        this.concurVectorSutRecursive.set(16, 17);
        this.concurVectorSutRecursive.set(17, 18);
        this.concurVectorSutRecursive.set(18, 19);
        this.concurVectorSutRecursive.set(19, 20);
        this.concurVectorSutRecursive.set(20, 21);
        this.concurVectorSutRecursive.set(21, 22);
        this.concurVectorSutRecursive.set(22, 23);
        this.concurVectorSutRecursive.set(23, 24);
        this.concurVectorSutRecursive.set(24, 25);

        assertTrue(325 == this.concurVectorSutRecursive.sum());
    }

    @Test
    public void max()
    {
        this.concurVectorSut.set(0, 1);
        this.concurVectorSut.set(1, 2);
        this.concurVectorSut.set(2, 3);
        this.concurVectorSut.set(3, 4);
        this.concurVectorSut.set(4, 34);
        this.concurVectorSut.set(5, 6);
        this.concurVectorSut.set(6, 7);
        this.concurVectorSut.set(7, 43);
        this.concurVectorSut.set(8, 9);
        this.concurVectorSut.set(9, 10);

        assertTrue(43 == this.concurVectorSut.max());
    }

    @Test
    public void prod()
    {
        this.concurVectorSut.set(0, 1);
        this.concurVectorSut.set(1, 2);
        this.concurVectorSut.set(2, 3);
        this.concurVectorSut.set(3, 4);
        this.concurVectorSut.set(4, 5);
        this.concurVectorSut.set(5, 6);
        this.concurVectorSut.set(6, 7);
        this.concurVectorSut.set(7, 8);
        this.concurVectorSut.set(8, 9);
        this.concurVectorSut.set(9, 10);

        SeqVector other = new SeqVector(10);
        other.set(0, 1);
        other.set(1, 2);
        other.set(2, 6);
        other.set(3, 4);
        other.set(4, 7);
        other.set(5, 5);
        other.set(6, 2);
        other.set(7, 10);
        other.set(8, 3);
        other.set(9, 1);

        assertTrue(235 == this.concurVectorSut.prod(other));
    }

    @Test
    public void norm()
    {
        this.concurVectorSut.set(0, 1);
        this.concurVectorSut.set(1, 2);
        this.concurVectorSut.set(2, 3);
        this.concurVectorSut.set(3, 4);
        this.concurVectorSut.set(4, 5);
        this.concurVectorSut.set(5, 6);
        this.concurVectorSut.set(6, 7);
        this.concurVectorSut.set(7, 8);
        this.concurVectorSut.set(8, 9);
        this.concurVectorSut.set(9, 10);

        double result = this.concurVectorSut.norm();
        result = Math.round(result* 100d) / 100d;

        assertTrue(19.62 ==  result);
    }
}