import java.util.HashMap;

public class Fibonacci {
	int callsToFib;
	int result;
	HashMap<Integer, Integer> fibmap= new HashMap();

	public Fibonacci(int n){
		this.callsToFib = 0;
		this.result = fib(n);
	}
	
	private int fib(int n) {
		callsToFib++;
		if (n == 0) {
			return 0;
		} else if (n <= 2) {
			return 1;
		} else {
			if (fibmap.get(n) != null) {
				return fibmap.get(n);
			} else {
				int returnValue = fib(n - 1) + fib(n - 2);
				fibmap.put(n, returnValue);
				return returnValue;
			}
		}
	}

}
