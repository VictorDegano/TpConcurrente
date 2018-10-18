package concurrTP;

public class ConcurVector extends SeqVector{
    private final ThreadPoolTP pool;

    public ConcurVector(int size, int threads, int load) {
        super(size);
        this.pool = new ThreadPoolTP(threads, load);
        this.pool.fillPool(this.elements);  //Se generan los threads y se quedan esperando
    }


/*Operaciones de Mapeo*/

    /** Pone el valor d en todas las posiciones del vector.
     * @param d, el valor a ser asignado. */
    public void set(double d) {
        //Se le dice al threadpool que cargue el trabajo
        //se espera el resultado
        //se lo obtiene
        //se lo guarda
    }


    /** Copia los valores de otro vector sobre este vector.
     * @param v, el vector del que se tomaran los valores nuevos.
     * @precondition dimension() == v.dimension(). */
    public void assign(SeqVector v) {
        for (int i = 0; i < dimension(); ++i)
            set(i, v.get(i));
    }


    /** Copia algunos valores de otro vector sobre este vector.
     * Un vector mascara indica cuales valores deben copiarse.
     * @param mask, vector que determina si una posicion se debe copiar.
     * @param v, el vector del que se tomaran los valores nuevos.
     * @precondition dimension() == mask.dimension() && dimension() == v.dimension(). */
    public void assign(SeqVector mask, SeqVector v) {
        for (int i = 0; i < dimension(); ++i)
            if (mask.get(i) >= 0)
                set(i, v.get(i));
    }


    /** Suma los valores de este vector con los de otro (uno a uno).
     * @param v, el vector con los valores a sumar.
     * @precondition dimension() == v.dimension(). */
    public void add(SeqVector v) {
        for (int i = 0; i < dimension(); ++i)
            set(i, get(i) + v.get(i));
    }


    /** Multiplica los valores de este vector con los de otro
     *  (uno a uno).
     * @param v, el vector con los valores a multiplicar.
     * @precondition dimension() == v.dimension(). */
    public void mul(SeqVector v) {
        for (int i = 0; i < dimension(); ++i)
            set(i, get(i) * v.get(i));
    }


    /** Obtiene el valor absoluto de cada elemento del vector. */
    public void abs() {
        for (int i = 0; i < dimension(); ++i)
            set(i, Math.abs(get(i)));
    }


/*Operaciones de Reduccion*/

    /** Obtiene la suma de todos los valores del vector. */
    public double sum() {
        //Se le dice al threadpool que cargue el trabajo
        //se espera el resultado
        //se lo obtiene
        //Si el resultado es otro vector se lo vuelve a trabajar
        //Si es un solo valor se lo retorna

        double result = 0;
        for (int i = 0; i < dimension(); ++i)
            result += get(i);
        return result;
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
    public double prod(SeqVector v) {
        SeqVector aux = new SeqVector(dimension());
        aux.assign(this);
        aux.mul(v);
        return aux.sum();
    }


    /** Retorna la norma del vector.
     *  Recordar que la norma se calcula haciendo la raiz cuadrada de la
     *  suma de los cuadrados de sus coordenadas.
     */
    public double norm() {
        SeqVector aux = new SeqVector(dimension());
        aux.assign(this);
        aux.mul(this);
        return Math.sqrt(aux.sum());
    }


    /** Obtiene el valor maximo en el vector. */
    public double max() {
        double current_max = get(0);
        for (int i = 0; i < dimension(); ++i)
            current_max = Math.max(current_max, get(i));
        return current_max;
    }



}
