package testPack;

public final class JavaClas {
	
	public final void test() {
		
	}

	public static void main(String[] args){
		
		JavaClas g = new JavaClas();
		g.finalize();
		
		int a = 10;
		int b = 3;
		int c = 56;
		System.out.println("Hi");
		int i = 9;
		int x[] = {56,43,67,87};
		
		try {
			c = a/b ;
			System.out.println(x[i]);
		}
		finally {
			System.out.println("finally block");
		}
		System.out.println(c);
		System.out.println("END");
		
		//Exception not generated
		// try -> finally -> normal flow
		
		// Exception generated and get handled 
		// try -> catch -> finally -> normal flow
		
		// Exception id generated and not handle
		// try -> finally
	}
}
