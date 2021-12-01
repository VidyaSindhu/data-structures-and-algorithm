import java.util.*;


class MaxPairWiseProduct {
	public static long calMaxPairWiseProduct(long arr[], int size) {
		long result = 0;
		for(int j = 0; j < size - 1; j++) {
			for(int i = j + 1 ; i < size; i++) {
				if ( arr[j] * arr[i] > result) {
					result = arr[j] * arr[i];
				}
			}
		}
		return result;
	}
	
	public static long calMaxPairWiseProductFast(long arr[], int size) {
		long result = 0;
		int maxNumber1 = 0;
		int maxNumberIndex2 = 0;
		long maxNumber2 = -1;
		for(int i = 0; i < size; i++) {
			if(arr[i] > arr[maxNumber1]) {
				maxNumber1 = i;
			}
		}
		
		for (int j = 0; j < size; j++) {
			if (j != maxNumber1 && arr[j] > maxNumber2) {
				maxNumberIndex2 = j;
				maxNumber2 = arr[j];
			}
		}
		result = maxNumber2 * arr[maxNumber1];
		return result;
	}
	
	public static void main(String args[]) {
		/*while(true) {
			Random random = new Random();
			int size = random.nextInt(1000)+2;
			long[] a = new long[size];
			for(int i = 0; i < size; i++) {
				a[i] = random.nextInt(100000);
			}
			for(int i = 0; i < size; i++) {
				System.out.print(a[i] + "  ");
			}
			System.out.println();
			long res1 = calMaxPairWiseProduct(a, size);
			long res2 = calMaxPairWiseProductFast(a, size);
			if(res1 != res2) {
				System.out.println(res1 + "   " + res2);	
				break;
			}
			else System.out.println("OK");
		}*/
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		long[] arr = new long[size];
		for (int i = 0; i < size; i++) {
			arr[i] = input.nextLong();
		}
		
		System.out.println(calMaxPairWiseProductFast(arr, size));
	}
}
			
		
