package record;
import java.util.*;
import game.option;

public class Record 
{
	public void check()
	{
		System.out.println("1. 생산량  2. 주문량  3. 재고량  4.손실  5. 자금  6. 이익");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		switch(num)
		{
			case 1:
				for(int i = 0 ;i<option.day;i++ )
				{
					System.out.printf("day%d 1번째 제품: %d 2번째 제품: %d 3번째 제품: %d 4번째 제품: %d 5번째 제품 %d \n",i+1,option.a_product_production[i],option.b_product_production[i],option.c_product_production[i],option.d_product_production[i],option.e_product_production[i]);
				}
				System.out.println();
				break;
			case 2:
				for(int i = 0 ;i<option.day;i++ )
				{
					System.out.printf("day%d 1번째 제품: %d 2번째 제품: %d 3번째 제품: %d 4번째 제품: %d 5번째 제품 %d \n",i+1,option.a_product_order[i],option.b_product_order[i],option.c_product_order[i],option.d_product_order[i],option.e_product_order[i]);
				}
				System.out.println();
				break;
			case 3:
				for(int i = 0 ;i<option.day;i++ )
				{
					System.out.printf("day%d 1번째 제품: %d 2번째 제품: %d 3번째 제품: %d 4번째 제품: %d 5번째 제품 %d \n",i+1,option.a_product_quantity[i],option.b_product_quantity[i],option.c_product_quantity[i],option.d_product_quantity[i],option.e_product_quantity[i]);
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
