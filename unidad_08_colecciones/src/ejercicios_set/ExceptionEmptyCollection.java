package ejercicios_set;

public class ExceptionEmptyCollection extends Exception{
    public ExceptionEmptyCollection(String s){
        super("\nColección vacía " + s);
    }
}
