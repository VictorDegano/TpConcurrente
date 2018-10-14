public class Buffer
{
    private WorkTP[] buffer;
    private int start = 0;
    private int end = 0;
    private int size;

    public Buffer(int size)
    {
        this.size = size;
        buffer = new WorkTP[size + 1];
    }

    public synchronized void push(WorkTP value)
    {
        while(this.isFull())
        {
            try
            {   wait(); }
            catch(InterruptedException e)
            {}
        }
        this.buffer[this.start] = value;
        this.start = this.next(this.start);
        notifyAll();
    }

    public synchronized WorkTP pop()
    {
        while(this.isEmpty())
        {
            try
            {   wait(); }
            catch(InterruptedException e)
            {}
        }
        WorkTP result= this.buffer[this.end];
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
