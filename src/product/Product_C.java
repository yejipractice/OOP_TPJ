package product;
import random.Random_func;
import game.option;

public  class Product_C implements Product
{
	private int quantity=0;
	private int price = 0;
	private String name;
	@Override
	public int product_Price(int p)
	{
		this.price=p;
		return price;
	}

	@Override
	public String product_Name(String n) 
	{
		this.name= n;
		return name;
	}

	@Override
	public int product_quantity(int q)
	{
		this.quantity = q;
		return q;
	}
	@Override
	public int Order_quantity()
	{	  
		Random_func a = new Random_func();
		a.setRange_start(option.k-100);
		a.setRange_end(option.k);
		int quantity = a.random_function();
		return quantity;
	}
	@Override
	public int getQuantity()
	{
		return quantity;
	}
	
	@Override
	public int getPrice() 
	{
		return price;
	}

	@Override
	public String getName() {
		
		return name;
	}
	
}