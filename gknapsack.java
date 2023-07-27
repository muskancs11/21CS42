import java.util.Scanner;

public class gknapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j, m, n;
		float temp;
		float p[] = new float[10];
		float w[] = new float[10];
		float c[] = new float[10];
		System.out.print("Enter no. of objects: ");
		n = sc.nextInt();
		System.out.println("Enter weights: ");
		for(i=1;i<=n;i++)
			w[i] = sc.nextFloat();
		System.out.println("Enter profits: ");
		for(i=1;i<=n;i++)
			p[i] = sc.nextFloat();
		System.out.println("Enter Knapsack size: ");
		m = sc.nextInt();
		for(i=1;i<=n;i++)
			c[i] = p[i]/w[i];
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n-1;j++)
			{
				if (c[j] < c[j+1])
				{
					temp = c[j];
					c[j] = c[j+1];
					c[j+1] = temp;
					
					temp = w[j];
					w[j] = w[j+1];
					w[j+1] = temp;
					
					temp = p[j];
					p[j] = p[j+1];
					p[j+1] = temp;
				}
			}
		}
		System.out.println("\n\tThe Items are arranged as: \n");
		System.out.println("\n\tItems\tWeights\tProfits\tProfits/Weight\n\n");
		for(i=1;i<=n;i++)
		{
			System.out.println("\t"+i+"\t"+w[i]+"\t"+p[i]+"\t"+c[i]);
		}
		float x[] = new float[10];
		float U,profit=0;
		U=m;
		for(i=1;i<=n;i++)
			x[i]=0;
		for(i=1;i<=n;i++)
		{
			if (w[i]>U)
				break;
			x[i] = 1;
			U=U-w[i];
		}
		if(i<n)
			x[i] = U/w[i];
		System.out.println("\n\tThe solution vector is: ");
		for(i=1;i<=n;i++)
			System.out.println("\n\t\tx["+i+"]="+x[i]);
		for(i=1;i<=n;i++)
			profit=profit+(p[i]*x[i]);
		System.out.println("\n\tMaximum Profit = "+ profit);
	}
}
