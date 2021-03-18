package random;

public class Defect_rand extends Random_func
{
	
	public double defect_ran() {
		double  a= 0;
		double range_start = 0.00;
		double range_end = 0.07;
		do
		{
 		a = ((Math.random()*(range_end-range_start))+range_start);
		}while(a<range_start&&a>range_end);
			
		return a;
	}

}
