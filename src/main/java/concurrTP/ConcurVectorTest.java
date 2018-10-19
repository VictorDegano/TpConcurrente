package concurrTP;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConcurVectorTest {

    private ConcurVector concurVectorSut;


    @Before
    public void setUp() throws Exception
    {
        this.concurVectorSut    = new ConcurVector(10, 2, 2);
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
}