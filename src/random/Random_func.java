package random;

public class Random_func 
{
	private int range_start;
	private int range_end;

	
	public void setRange_start(int s)
	{
		this.range_start =s;
	}
	
	public void setRange_end(int e)
	{
		this.range_end =e;
	}
	
	public int getRange_start()
	{
		return range_start;
	}
	
	public int getRange_end()
	{
		return range_end;
	}

	public int random_function() {
		int a= 0;
		do
		{
 		a = (int)((Math.random()*(range_end-range_start))+range_start);
		}while(a<range_start&&a>range_end);
			
		return a;
	}


}
