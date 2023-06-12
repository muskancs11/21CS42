import java.util.Random;
import java.util.Scanner;
public class Quickshort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();
		
		int array[]=new int[n];
		long start,end;
		
		for(int i=0;i<n;i++)
		{
			array[i]=r.nextInt(n);
		}
		
		System.out.println("Quick Sort\n\n");
		System.out.println("Value Before the sort:");
		
		for(int i=0;i<n;i++)
			System.out.println(array[i]);
		start= System.nanoTime();
		Quickshort qs = new Quickshort();
		qs.quicksort(array,0,n-1);
		end= System.nanoTime();
		System.out.println("Value after sort:");
		for(int i=0;i<n;i++)
			System.out.println(array[i]);
		
		System.out.println("\n\nThe time taken to sort is"+((end-start)/1000000)+"ms");
		double best =n*Math.log(n);
		double avg=best;
		double worst = n*n;
		System.out.println("\nBest case="+Math.round(best)+"\nAverage="+Math.round(avg)+"\nWorst="+Math.round(worst));
				
	}
	
	static void quicksort(int a[],int p,int q)
	{
		int j;
		if(p<q)
		{
			j=partition(a,p,q);
			quicksort(a,p,j-1);
			quicksort(a,j,q);
		}
	}
    static int partition(int a[],int i,int j)
    {
    	int v=a[i];
    	while(i<=j)
    	{
    		while(a[i]<v)
    			i++;
    		while(a[j]>v)
    			j--;
    		if(i<=j)
    		{
    			int temp =a[i];
    			a[i]= a[j];
    			a[j]=temp;
    			i++;
    			j--;
    		}
    	}
    	return i;
    }
}
