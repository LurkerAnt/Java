package ejercicio_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaValores {

	private List <Integer>  listaValores;
	
	public ListaValores (int value1,int value2){
		listaValores= new ArrayList <Integer> ();
		listaValores=createListWith100RandomsBetweenParameters(value1, value2);
		
		
	}
	
	
	
	public ArrayList <Integer> createListWith100RandomsBetweenParameters(int value1,int value2){
		ArrayList<Integer>listToReturn=new ArrayList<>();
		
		for(int i=0;i<100;i++) {
			listToReturn.add((int)((Math.random()*value2)+value1));
		}
		
		return listToReturn;
	}
	
	
	public void addElement(Integer element) {
		listaValores.add(element);
	}
	
	public void orderLowerToHigher() {
		//esto lo ordena de menor a mayor.
		Collections.sort(listaValores);
	}

	public void orderHigherToLower() {
		Collections.sort(listaValores);
		//crear objeto comparador para que compare los elementos y los ponga en orden inverso.
		Comparator<Integer> comparator=Collections.reverseOrder();
		Collections.sort(listaValores, comparator);
	}
	
	public int countTheTimesNumberAppears(int numberToCheck) {
		int counter=0;
		for (Integer integer : listaValores) {
			if (integer==numberToCheck) {
				counter++;
			}
		}
		return counter;
	}
	
	public ArrayList <Integer> getListOfElementsBetweenTwoNumbers(int number1, int number2){
		ArrayList <Integer> listToReturn=new ArrayList<Integer>();
		int extraNumber;
		
		if(number2>number1) {
			extraNumber=number1;
			number1=number2;
			number2=extraNumber;
		}
		
		
		for (Integer integer : listToReturn) {
			if (integer>number1&&integer<number2) {
				listToReturn.add(integer);
			}
		}
		
		return listToReturn;
	}
	
	public Integer getCompleteAddedValueOfList() {
		Integer acumulator=0;
		for (Integer integer : listaValores) {
			acumulator+=integer;
		}
		
		return acumulator;
	}
	
	public Integer getHighestElementInList() {
		orderHigherToLower();
		return listaValores.get(0);
	}
	
	public Integer getLowestElementInList() {
		orderLowerToHigher();
		return listaValores.get(0);
	}
	
	public ArrayList <Integer> returnListWithElementsBetweenValuesIncludingTheValues(int value1, int value2){
		ArrayList<Integer> listToReturn=new ArrayList<>();
		
		if(value2>value1) {
			int extraNumber=value1;
			value1=value2;
			value2=extraNumber;
		}
		
		for (Integer integer : listToReturn) {
			if (integer>=value1&&integer<=value2) {
				listToReturn.add(integer);
			}
		}
		
		return listToReturn;
	}
	
	public ArrayList<Integer> returnListWithCommonElementsBetweenLists(ArrayList<Integer> listToCheck){
		ArrayList<Integer> listToReturn=new ArrayList<>();
		
		listToReturn.addAll(this.listaValores);
		//el metodo retainAll hace que únicamente se quede con los valores que coincidan con los que ya estan metidos osease los elementos comunes, bastante útil.
		listToReturn.retainAll(listToCheck);
		return listToReturn;
	}
	
	
}
