import java.util.ArrayList;
import java.util.List;

public class Buffer
{
    private List<Double> buffer = new ArrayList<Double>();
    private int inicio          = 0;
    private int fin             = 0;
    private int tamanio;

    public Buffer(int tamanio)
    {   this.tamanio = tamanio; }

    public synchronized void push(Double valor)
    {
        while(this.estaLleno())
        {
            try
            {   wait(); }
            catch(InterruptedException e)
            {}
        }
        this.buffer.set(this.inicio, valor);
        this.inicio = this.siguiente(this.inicio);
        notifyAll();
    }

    public synchronized double pop()
    {
        while(this.estaVacio())
        {
            try
            {   wait(); }
            catch(InterruptedException e)
            {}
        }
        Double resultado= this.buffer.get(this.fin);
        this.fin        = this.siguiente(this.fin);
        notifyAll();
        return resultado;
    }

    private boolean estaVacio()
    {   return this.inicio == this.fin; }

    private boolean estaLleno()
    {   return this.siguiente(this.inicio) == this.fin;   }

    private int siguiente(int i)
    {   return (i+1)%(this.tamanio+1);  }
}
