import java.util.ArrayList;
import java.util.Arrays;

public class Solution { 
	
	public int[] solution(int K, int M, int[] A) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int leader;
		int leaderCount;
		int count;
		int actual;
		int[] segmento; 
		int limite = A.length - K;
		int lastLeader = 0;
		while(i <= limite) { //Esto evalua que podamos sacar segmetos desde A[0] hasta A[N-K]
			
			segmento = Arrays.copyOfRange(A, i, i + K); //Cogemos el segmento
			Arrays.sort(segmento); //Ordenamos el segmento para recorrerlo una sola vez luego
			
			leader = M+1; //El valor del lider debe ser igual o menor a M, se asigna el valor de M+1 para un valor no valido al principio
			leaderCount = 1; //Para elegir el primer lider debe tener mas de una repeticion
			count = 0; //Valor con el que se compara y evalua el posible lider
			actual = segmento[0]; //numero que se evalua como posible lider
			for(int number : segmento){
				//Si el numero cambia comenzamos a contar de nuevo
				if(actual != number) {
					count = 0;
					actual = number;
				}
				count++;
				//Si el acumulado del numero actual es superior a la cantidad del posible lider, se coge el actual como nuevo posible lider
				if(count > leaderCount) {
					leader = actual;
					leaderCount = count;
				}
			}
			//Los valores aceptados como lider deben ser menor o igual que M y no repetimos el lider si ya lo tenemos
			//Dentro del segmento no sumamos el 1, sino en el lider al evaluarlo, asi nos ahorramos el sumarlo en todos los segmentos
			if(leader <= M && !result.contains(leader+1)) {
				result.add(leader + 1);
			}
			i++;
		}
		return result.stream().mapToInt(num -> num).toArray();
	}; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solve = new Solution();
		int[] sol;
		
		/*Caso A*/
		int[] A = {2, 1, 3, 1, 2, 2, 3};
		int K =3, M = 5;
		sol = solve.solution(K, M, A);
		
		for(int num : sol) {
			System.out.print(num);
		}
		System.out.println("\n");
		
		/*Caso B*/
		int[] B = {1, 2, 2, 1, 2};
		solve.solution(4, 2, B);
		
		for(int num : sol) {
			System.out.print(num);
		}
		System.out.println("\n");
	}
}