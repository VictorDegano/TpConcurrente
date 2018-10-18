package concurrTP.buffer;
import workTP.WorkTP;
import java.util.ArrayList;
import java.util.List;

/**Sub clase del Buffer para dar soporte a las funciones tipo mapper para
 * que puedan guardar los resultados conforme a la posicion que lo sacaron**/
public class ResultBufferType
{
    private final List<WorkTP> results = new ArrayList<>();

    public synchronized void add(WorkTP value)
    {   this.results.add(value);    }


    public List<WorkTP> getResults()
    {   return this.results; }
}
