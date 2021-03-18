package order;
import java.util.ArrayList;

import game.option;
import product.Product;
import product.Product_A;
import product.Product_B;
import product.Product_C;
import product.Product_D;
import product.Product_E;

public class Order 
{
	Product a = new Product_A();
	Product b = new Product_B();
	Product c = new Product_C();
	Product d = new Product_D();
	Product e = new Product_E();
	
	static boolean[] sell_possibility= {false,false,false,false,false}; //��ǰ�� �Ǹ� ���� ����
	static int[] order_quantity = {0,0,0,0,0}; //��ǰ�� ���� �ֹ���
	static int[] quantity = {0,0,0,0,0}; //��ǰ�� ���
	static int[] price = {0,0,0,0,0};
	
	public static void check_q(ArrayList<Product> list) 
	{
		for(int i = 0;i<list.size();i++)
		{
			order_quantity[i] = list.get(i).Order_quantity();
			quantity[i]=list.get(i).getQuantity();
			if(order_quantity[i]>quantity[i])
			{
				sell_possibility[i]=false;
			}else
			{
				sell_possibility[i]=true;
			}
		}	
	}
	
	public static void sell(ArrayList<Product> list)
	{
		check_q(list);
		System.out.print("���� �ֹ�����?"); //
		for(int i = 0;i<list.size();i++) 
		{
			int a = order_quantity[i];
			System.out.printf("%d ", a);
		}
		System.out.print("\n");
		for(int i = 0;i<list.size();i++) 
		{
			if(sell_possibility[i]==true)
			{
				int a = list.get(i).getPrice(); //��ǰ�� ����
				int b = list.get(i).Order_quantity(); //������ų�� �ִ� ��ǰ�� �ֹ���
				int profit = a*b; //������Ų �ֹ��� ����
				option.money+=profit; //�ڱݿ� ���ϱ�
				String n = list.get(i).getName();
				System.out.printf("%s�� �Ǹ��� �� �ֽ��ϴ�.\n",n);
				option.satisfaction_score++;
			}
			else
			{	String n = list.get(i).getName();
				System.out.printf("%s�� �Ǹ��� �� �����ϴ�.\n",n);
				option.satisfaction_score--;
			}
		}
		
	}
	
	public static int[] getOrderquantity()
	{
		return order_quantity;
	}
	
	public static int total_profit(ArrayList<Product> list)
	{
		int total_profit = 0; int profit = 0;
		for(int i = 0;i< list.size();i++)
		{
			price[i] = list.get(i).getPrice();
		}
		for(int i = 0;i<order_quantity.length;i++)
		{
			if(sell_possibility[i]==true)
			{
				profit = price[i]*order_quantity[i];
			}
			total_profit +=profit;
		}
		return total_profit;
	}
}






