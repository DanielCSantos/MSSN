package TPC01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BulgarianSolitaire {
	List<Integer> cards ;
	ArrayList<Object> sequences = new ArrayList<>();
	List<Integer>  triangularsolution = new ArrayList<>();
	int iterations = 0;




	//Constructor
	public BulgarianSolitaire(List<Integer> a) {
		cards = new ArrayList<Integer>(a);
		Collections.sort(cards);
		triangularSolution();
		cycle();
	}

	//Solution if(N= total number of cards) 
	//the input is a triangular number
	public List<Integer> triangularSolution() {
		triangularsolution.add(1);
		triangularsolution.add(2);
		triangularsolution.add(3);
		triangularsolution.add(4);
		triangularsolution.add(5);
		triangularsolution.add(6);
		triangularsolution.add(7);
		triangularsolution.add(8);
		triangularsolution.add(9);

		return triangularsolution;
	}

	//Creates a deep copy of a recieved list of integers
	public List<Integer> deepCopy(List<Integer> aux) {
		List<Integer>newList = new ArrayList<Integer>();
		for(Integer p : aux) {
			newList.add(p);
		}
		return newList;
	}

	//Verifies if the game has reached the ending conditions
	public boolean gameOver(List<Integer> current) {

		for(int i = 0; i < sequences.size();i++) {
			if(Arrays.asList(sequences.get(i)).contains(triangularsolution) || 
					Arrays.asList(sequences.get(i)).contains(current)) {
				System.out.println("Game has reached the end");
				return true;
			}
		}
		sequences.add(deepCopy(cards));
		return false;
	}



	//Cycles the game till end condition is reached
	public void cycle() {
		int counter;
		System.out.println(cards);
		while(!gameOver(cards)) {


			for(counter = 0; counter < cards.size(); counter++) {

				int value = cards.get(counter);

				cards.set(counter, value-1);
			}

			iterations++;
			removeZeros(cards);
			cards.add(counter);
			Collections.sort(cards);

			counter = 0;


			System.out.println(cards);
		}
		System.out.println("The number of required iterations is: " + iterations);
		System.out.println("");
		sequences.add(deepCopy(cards));
		System.out.println(sequences);
	}

	public void removeZeros(List<Integer> current) {

		while(current.get(0) == 0) {
			current.remove(0);
		}
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		//		a.add(5);
		//		a.add(5);
		//		a.add(5);

		//		a.add(21);
		//		a.add(4);
		//		
		//		a.add(1);
		//		a.add(1);
		//		a.add(1);
		//		a.add(1);
		//		a.add(4);
		//		a.add(4);
		//		a.add(9);

		//		a.add(7);
		//		a.add(1);
		//		a.add(1);

		a.add(8);
		//		a.add(1);
		//		a.add(6);
		//		a.add(3);
		new BulgarianSolitaire(a);
	}


}
