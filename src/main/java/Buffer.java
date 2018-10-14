import java.util.ArrayList;
import java.util.List;

public class Buffer
{
    private List<Double> buffer = new ArrayList<Double>();
    private int start = 0;
    private int end = 0;
    private int size;

    public Buffer(int size)
    {   this.size = size; }

    public synchronized void push(Double value)
    {
        while(this.isFull())
        {
            try
            {   wait(); }
            catch(InterruptedException e)
            {}
        }
        this.buffer.set(this.start, value);
        this.start = this.next(this.start);
        notifyAll();
    }

    public synchronized double pop()
    {
        while(this.isEmpty())
        {
            try
            {   wait(); }
            catch(InterruptedException e)
            {}
        }
        Double result= this.buffer.get(this.end);
        this.end = this.next(this.end);
        notifyAll();
        return result;
    }

    public synchronized boolean isEmpty()
    {   return this.start == this.end; }

    private boolean isFull()
    {   return this.next(this.start) == this.end;   }

    private int next(int i)
    {   return (i+1)%(this.size +1);  }
}
