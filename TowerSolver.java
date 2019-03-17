public class TowerSolver{

	static int height = 1;
	public static int[] a = new int[height];
	public static int[] b = new int[height];
	public static int[] c = new int[height];
	public static long count = 0;
	
	public static void main(String[] args){
		long time = System.currentTimeMillis();
		TowerOfHanoi.startfill(a);
		System.out.println("Start");
		sort(height, a, c, b);
		System.out.println("\nMoves: " + count);
		System.out.println("Run Time: " +(System.currentTimeMillis()- time) + "ms");
		
	}
	
	public static void sort(int height, int[] from, int[] to, int[] via){
		if(height > 0){
			sort(height-1, from, via, to);
			
			TowerOfHanoi.displayboard(a,b,c);
			
			System.out.print("Move " + (count+1) + ":");
			
			System.out.print("\nFrom: ");
			if (from == a)
				System.out.print("a");
			if (from == b)
				System.out.print("b");
			if (from == c)
				System.out.print("c");
			
			System.out.print("\nMove: ");
			if (from == a)
				System.out.print("a");
			if (from == b)
				System.out.print("b");
			if (from == c)
				System.out.print("c");
			System.out.print(" -> ");
			if (to == a)
				System.out.print("a");
			if (to == b)
				System.out.print("b");
			if (to == c)
				System.out.print("c");
				
			TowerOfHanoi.move(from, to);
			
			
			  
			count++;			
			
			sort(height-1, via, to, from);			
		}
		
		return;		
	} 
}