package workTP;

// TODO: 18/10/2018 La idea es que sea una interfaz o una clase abstracta(si hay comportamiento que vale la pena unificar) para tener una forma polimorfica de trabajar los distintos pedidos
public interface WorkTpInterface
{
    WorkType workType();

    int workSize();

    double[] getResult();

    double getSingleResult();
}
