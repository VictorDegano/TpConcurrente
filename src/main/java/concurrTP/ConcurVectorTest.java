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
}