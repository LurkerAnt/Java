import java.util.Comparator;

public class ComparatorDepartamentoPorIDComponentes implements Comparator<Departamento> {

    public int compare(Departamento departameto1paraComparar, Departamento departamento2paraComparar) {
        int resultado = departameto1paraComparar.getIdentificador().compareTo(departamento2paraComparar.getIdentificador());

        if (resultado == 0) {
            resultado = departameto1paraComparar.compareByComponents(departamento2paraComparar);
        }

        return resultado;

    }
}


