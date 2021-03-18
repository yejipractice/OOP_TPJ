package record;
import java.util.*;
import game.option;

public class Record 
{
	public void check()
	{
		System.out.println("1. ���귮  2. �ֹ���  3. ���  4.�ս�  5. �ڱ�  6. ����");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		switch(num)
		{
			case 1:
				for(int i = 0 ;i<option.day;i++ )
				{
					System.out.printf("day%d 1��° ��ǰ: %d 2��° ��ǰ: %d 3��° ��ǰ: %d 4��° ��ǰ: %d 5��° ��ǰ %d \n",i+1,option.a_product_production[i],option.b_product_production[i],option.c_product_production[i],option.d_product_production[i],option.e_product_production[i]);
				}
				System.out.println();
				break;
			case 2:
				for(int i = 0 ;i<option.day;i++ )
				{
					System.out.printf("day%d 1��° ��ǰ: %d 2��° ��ǰ: %d 3��° ��ǰ: %d 4��° ��ǰ: %d 5��° ��ǰ %d \n",i+1,option.a_product_order[i],option.b_product_order[i],option.c_product_order[i],option.d_product_order[i],option.e_product_order[i]);
				}
				System.out.println();
				break;
			case 3:
				for(int i = 0 ;i<option.day;i++ )
				{
					System.out.printf("day%d 1��° ��ǰ: %d 2��° ��ǰ: %d 3��° ��ǰ: %d 4��° ��ǰ: %d 5��° ��ǰ %d \n",i+1,option.a_product_quantity[i],option.b_product_quantity[i],option.c_product_quantity[i],option.d_product_quantity[i],option.e_product_quantity[i]);
				}
				System.out.println();
				break;
			case 4:
				for(int i = 0 ;i<option.day;i++ )
				{
					System.out.printf("day%d %d", i+1,option.defect_cost_perday[i]);
				}
				System.out.println();
				break;
			case 5:
				for(int i = 0 ;i<option.day;i++ )
				{
					System.out.printf("day%d %d", i+1,option.cost_perday[i]);
				}
				System.out.println();
				break;
			case 6:
				for(int i = 0 ;i<option.day;i++ )
				{
					System.out.printf("day%d %d", i+1,option.profit_perday[i]);
				}
				System.out.println();
				break;
		}
	}
}
