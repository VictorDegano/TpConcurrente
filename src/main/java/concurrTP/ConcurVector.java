package concurrTP;

import concurrTP.buffer.Buffer;
import concurrTP.buffer.ResultBufferType;
import workTP.WorkTP;
import workTP.WorkType;
import java.util.Arrays;
import java.util.List;

public class ConcurVector extends SeqVector{

    private final ThreadPoolTP pool;
    private Buffer buffer;
    private ResultBufferType resultBuffer;
    private int caluloDeCarga;

    public ConcurVector(int size, int threads, int load) {
        super(size);
        this.pool           = new ThreadPoolTP(threads, load);
        this.buffer         = new Buffer(elements.length);
        this.resultBuffer   = new ResultBufferType();
        this.caluloDeCarga  = this.elements.length / threads;
        this.pool.fillPool(this.elements, buffer, resultBuffer);  //Se generan los threads y se quedan esperando
    }


/*Operaciones de Mapeo*/

    /** Pone el valor d en todas las posiciones del vector.
     * @param d, el valor a ser asignado. */
    public void set(double d)
    {
        this.loadWork(this.caluloDeCarga, elements, WorkType.SET, d);

        this.pool.jobFinished();

        this.joinResults();
    }


    /** Copia los valores de otro vector sobre este vector.
     * @param v, el vector del que se tomaran los valores nuevos.
     * @precondition dimension() == v.dimension(). */
    public void assign(SeqVector v) {
        this.loadWork(this.caluloDeCarga, elements, WorkType.ASSIGN, v.elements);

        this.pool.jobFinished();

        this.joinResults();
    }


    /** Copia algunos valores de otro vector sobre este vector.
     * Un vector mascara indica cuales valores deben copiarse.
     * @param mask, vector que determina si una posicion se debe copiar.
     * @param v, el vector del que se tomaran los valores nuevos.
     * @precondition dimension() == mask.dimension() && dimension() == v.dimension(). */
    public void assign(SeqVector mask, SeqVector v) {
        this.loadWork(this.caluloDeCarga, elements, WorkType.ASSIGNMASK, v.elements, mask.elements);

        this.pool.jobFinished();

        this.joinResults();
    }


    /** Suma los valores de este vector con los de otro (uno a uno).
     * @param v, el vector con los valores a sumar.
     * @precondition dimension() == v.dimension(). */
    public void add(SeqVector v) {
        this.loadWork(this.caluloDeCarga, elements, WorkType.ADD, v.elements);

        this.pool.jobFinished();

        this.joinResults();
    }


    /** Multiplica los valores de este vector con los de otro
     *  (uno a uno).
     * @param v, el vector con los valores a multiplicar.
     * @precondition dimension() == v.dimension(). */
    public void mul(SeqVector v) {
        this.loadWork(this.caluloDeCarga, elements, WorkType.MUL, v.elements);

        this.pool.jobFinished();

        this.joinResults();
    }


    /** Obtiene el valor absoluto de cada elemento del vector. */
    public void abs() {
        this.loadWork(this.caluloDeCarga, elements, WorkType.ABS);

        this.pool.jobFinished();

        this.joinResults();
    }


/*Operaciones de Reduccion*/

    /** Obtiene la suma de todos los valores del vector. */
    public double sum()
    {
        this.loadWork(this.caluloDeCarga, this.elements, WorkType.SUM);
        this.pool.jobFinished();
        return this.reviewResultAndWorkIt(WorkType.SUM);
    }

    /** Obtiene el valor promedio en el vector. */
    public double mean() {
        double total = sum();
        return total / dimension();
    }


    /** Retorna el producto de este vector con otro.
     * El producto vectorial consiste en la suma de los productos
     * de cada coordenada.
     * @param v, el vector a usar para realizar el producto.
     * @precondition dimension() == v.dimension(). */
    public double prod(SeqVector v)
    {
        ConcurVector aux = new ConcurVector(dimension(), this.pool.getThreads(), this.pool.getLoad());
        aux.assign(this);
        aux.mul(v);
        return aux.sum();
    }


    /** Retorna la norma del vector.
     *  Recordar que la norma se calcula haciendo la raiz cuadrada de la
     *  suma de los cuadrados de sus coordenadas.
     */
    public double norm() {
        ConcurVector aux = new ConcurVector(dimension(), this.pool.getThreads(), this.pool.getLoad());
        aux.assign(this);
        aux.mul(this);
        return Math.sqrt(aux.sum());
    }


    /** Obtiene el valor maximo en el vector. */
    public double max()
    {
        this.loadWork(this.caluloDeCarga, this.elements, WorkType.MAX);
        this.pool.jobFinished();
        return this.reviewResultAndWorkIt(WorkType.MAX);
    }



    private void loadWork(int caluloDeCarga, double[] elements, WorkType aType) {
        Double works = Math.ceil(Double.valueOf(elements.length)/Double.valueOf(caluloDeCarga));
        this.pool.setNewWorks(works.intValue());
        for (int i = 0; i < elements.length; i += caluloDeCarga) {
            WorkTP work = getBasicWork(caluloDeCarga, elements, aType, i);
            this.buffer.push(work);
        }
    }

    private void loadWork(int caluloDeCarga, double[] elements, WorkType aType, double value) {
        Double works = Math.ceil(Double.valueOf(elements.length)/Double.valueOf(caluloDeCarga));
        this.pool.setNewWorks(works.intValue());
        for (int i = 0; i < elements.length; i += caluloDeCarga) {
            WorkTP work = getBasicWork(caluloDeCarga, elements, aType, i);
            work.setValue(value);
            this.buffer.push(work);
        }
    }

    private void loadWork(int caluloDeCarga, double[] elements, WorkType aType, double[] otherVector) {
        Double works = Math.ceil(Double.valueOf(elements.length)/Double.valueOf(caluloDeCarga));
        this.pool.setNewWorks(works.intValue());
        for (int i = 0; i < elements.length; i += caluloDeCarga) {
            WorkTP work = getBasicWork(caluloDeCarga, elements, aType, i);
            work.setHelperVector(otherVector);
            this.buffer.push(work);
        }
    }


    private void loadWork(int caluloDeCarga, double[] elements, WorkType aType, double[] otherVector, double[] maskVector) {
        Double works = Math.ceil(Double.valueOf(elements.length)/Double.valueOf(caluloDeCarga));
        this.pool.setNewWorks(works.intValue());
        for (int i = 0; i < elements.length; i += caluloDeCarga) {
            WorkTP work = getBasicWork(caluloDeCarga, elements, aType, i);
            work.setHelperVector(otherVector);
            work.setMaskVector(maskVector);
            this.buffer.push(work);
        }
    }


    private void joinResults() {
        for (WorkTP element: this.resultBuffer.getResults())
        {
            int elementPosition = element.getPosition();
            for (int i = elementPosition; i < elementPosition+caluloDeCarga; i++)
            {   this.elements[i] = element.getResultVector()[i-elementPosition];  }
        }
    }

    private WorkTP getBasicWork(int caluloDeCarga, double[] elements, WorkType aType, int position) {
        WorkTP work = new WorkTP();
        work.setVector(Arrays.copyOfRange(elements, position, position + caluloDeCarga));
        work.setWorkType(aType);
        work.setPosition(position);
        return work;
    }

    private double reviewResultAndWorkIt(WorkType aWorkType) {
        List<WorkTP> partialResult = this.resultBuffer.getResults();

        if (partialResult.size() != 1)
        {
            double[]    algo = new double[partialResult.size()];
            for (int i = 0; i < partialResult.size() ; i++)
            {   algo[i] = partialResult.get(i).getResultValue();}
            this.loadWork(caluloDeCarga, algo, aWorkType);
            this.pool.jobFinished();
            partialResult = this.resultBuffer.getResults();
        }
        return partialResult.get(0).getResultValue();
    }
}
