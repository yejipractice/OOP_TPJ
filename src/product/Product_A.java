package product;
import random.Random_func;
import game.option;

public  class Product_A implements Product
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
	public int product_quantity(int q) //재고량
	{
		this.quantity = q;
		return q;
	}
	
	@Override
	public int Order_quantity() // 주문량
	{	 
		Random_func a = new Random_func();
		a.setRange_start(option.k-100); //100대신 변수 지정하야 랜덤으로 하면 제품별 주문량 범위를 랜덤으로 설정 가능할 듯
		a.setRange_end(option.k);
		int orderQuantity = a.random_function();
		return orderQuantity;
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
	public String getName() 
	{
		
		return name;
	}


}

