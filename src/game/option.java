package game;

import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

import record.Record;
import startGUI.StartFrame;
import product.Product_A;
import product.Product_B;
import product.Product_C;
import product.Product_D;
import product.Product_E;
import product.Product;
import order.Order;
import production.Production;
import game.Check_Ending;




public class option {
   public static final int k = 500; //�ֹ��� ���� ���� ����: 1ȸ �ִ� �ֹ��� 
   public static int money=1000000; //�ڱ�
   public static final int success_money = money*10;; // ���� �ڱ� ����
   public static int satisfaction_score = 100; //������
   public static final int production_fee = (int)money/10; //������
   public static final int challenge_money = (int)money/2; // ������ 
   public static int challenge_again = 0; // ������ �޾� �絵�� ����
   public static int sscore_add1 = 106; //��ǰ �߰��� Ư�� ������1
   public static int sscore_add2 = 109; //��ǰ �߰��� Ư�� ������2
   static Scanner sc = new Scanner(System.in);
   private static String user_start; //�������� ����
   private static int select; //�ֹ� �ޱ� / ���� ����/ ���ڵ� ������ ����
   public static int day = 0; //��¥
   public static int opp = 100; //���� Ƚ�� record
   // record ���� ���� per day
   public static int[] a_product_production=new int[opp]; //���귮
   public static int[] b_product_production=new int[opp];
   public static int[] c_product_production=new int[opp];
   public static int[] d_product_production=new int[opp];
   public static int[] e_product_production=new int[opp];
   public static int[] a_product_order=new int[opp]; //�ֹ���
   public static int[] b_product_order=new int[opp];
   public static int[] c_product_order=new int[opp];
   public static int[] d_product_order=new int[opp];
   public static int[] e_product_order=new int[opp]; 
   public static int[] a_product_quantity=new int[opp]; //���
   public static int[] b_product_quantity=new int[opp];
   public  static int[] c_product_quantity=new int[opp];
   public static int[] d_product_quantity=new int[opp];
   public static int[] e_product_quantity=new int[opp]; 
   public static int[] defect_cost_perday=new int[opp]; //�ս�
   public static int[] cost_perday=new int[opp]; //�ڱ�
   public  static int[] profit_perday=new int[opp]; //����
   
   public static String user_name;
   public static String p1name;
   public static String p2name;
   public static String p3name;
   public static String p4name;
   public static String p5name;
   
   public static int p1price;
   public static int p2price;
   public static int p3price;
   public static int p4price;
   public static int p5price;
   
   public static void main(String[] args) {
	   
	  EventQueue.invokeLater(()->
	  {
		  StartFrame sframe = new StartFrame();
		  sframe.setTitle("�� ���� ��������");
		  sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  sframe.setVisible(true);
	  });
	  
	  
	  
      ArrayList<Product> product_list = new ArrayList<Product>(); //�Ǹ� �Ǵ� ���� ������ ��ǰ ����Ʈ
      Product a = new Product_A();
      product_list.add(a);
      Product b = new Product_B();
      product_list.add(b);
      Product c = new Product_C();
      product_list.add(c);
      Product d = new Product_D();
      Product e = new Product_E();
      
      
      for(int i = 0;i<opp;i++) // record�� �迭 �ʱ�ȭ 
	   {
		   a_product_production[i]=0;
		   b_product_production[i]=0;
		   c_product_production[i]=0;
		   d_product_production[i]=0;
		   e_product_production[i]=0;
		   a_product_order[i]=0;
		   b_product_order[i]=0;
		   c_product_order[i]=0;
		   d_product_order[i]=0;
		   e_product_order[i]=0;
		   a_product_quantity[i]=0;
		   b_product_quantity[i]=0;
		   c_product_quantity[i]=0;
		   d_product_quantity[i]=0;
		   e_product_quantity[i]=0;
		   defect_cost_perday[i]=0;
		   cost_perday[i]=0;
		   profit_perday[i]=0;
	   }
      //��Ʈ ���� ++ ��ǰ �̸�
      
      //System.out.println("*$*$*$*-----�� ���� ������------*$*$*$*\n"+"������ �����Ͻðڽ��ϱ�?(yes/no)");
     
      //user_start = sc.nextLine();
      
      //if(user_start.equalsIgnoreCase("yes")) {
        // System.out.println("\n������ �����մϴ�!\n\t"+"+---------+----------+---------+---------+----------+" + "\n\t�� ������ ������ �ֹ����� �����Ͽ� �����ϰ� �Ǹ��ϴ� �����Դϴ�.\n\t�ǸŸ� �Ͽ� ������ ��� ���ؼ��� ������ ���� ��ǰ�� �����ؾ߰���? \n\t"
         		//+ "�ֹ��� ������ �� ��ǰ ������ �Ǿ����� ������ ��ǰ�� �Ǹ��� �� �����ϴ�.\n\t����,�ҷ�ǰ�� ���� �� ������ �����ϼ���!(�ҷ�ǰ�� �ս��� �߻���ŵ�ϴ�.)\n\t������ Ư�� ��ǥġ�� �ڱ��� �Ǹ� �������� ������,\n\t�������� 0��  �ǰų� �ں��� 0�� �Ǹ� ���з� ���̳��ϴ�.\n\t�׷� ������ ������ô�~!"
         		//+ "\n\t+---------+----------+---------+---------+----------+\n" +"�켱, �̸��� �Է����ּ���");
           
           
            
           /* System.out.println("ù ��° ��ǰ�� ��ǰ���� �������ּ���~~"); //��ǰ��
            Scanner in1 = new Scanner(System.in);
            get_Name(a,in1);
            System.out.println("�� ��° ��ǰ�� ��ǰ���� �������ּ���~~");
            get_Name(b,in1);
            System.out.println("�� ��° ��ǰ�� ��ǰ���� �������ּ���~~");
            get_Name(c,in1);
            System.out.println("�� ��° ��ǰ�� ��ǰ���� �������ּ���~~");
            get_Name(d,in1);
            System.out.println("�ټ� ��° ��ǰ�� ��ǰ���� �������ּ���~~");
            get_Name(e,in1); */
            
           
            
     /* while(true){  
      try { //����ڰ� ������ �Է����� �ʾƼ� ���� ������ �ȵ� ��� ����ó��
            Scanner in2 = new Scanner(System.in);
            System.out.println("ù ��° ��ǰ�� ��� ������ �������ּ���~~"); //��ǰ�� ����
             get_Price(a,in2);
             System.out.println("�� ��° ��ǰ�� ��� ������ �������ּ���~~"); //��ǰ�� ����
             get_Price(b,in2);
             System.out.println("�� ��° ��ǰ�� ��� ������ �������ּ���~~"); //��ǰ�� ����
             get_Price(c,in2);
             System.out.println("�� ��° ��ǰ�� ��� ������ �������ּ���~~"); //��ǰ�� ����
             get_Price(d,in2);
             System.out.println("�ټ� ��° ��ǰ�� ��� ������ �������ּ���~~"); //��ǰ�� ����
             get_Price(e,in2);
      }catch(InputMismatchException error1) {
    	  System.out.println("[�߸� �Է��ϼ̽��ϴ�.]");
    	  System.out.println("[������ �Է����ּ���.]");
          continue; //������ �Է��� ������ ����ڿ��� ������ ��� �Է¹޴´�.
      }catch(NullPointerException error2) {
    	  System.out.println("[���� �Է����ּ���.]");
          continue; //������ �Է��� ������ ����ڿ��� ������ ��� �Է¹޴´�.
      }
      break;
      }*/
      
      
           // System.out.println("ȯ���մϴ�~!"+user_name+"�� ������ �����մϴ�!\n");
            System.out.println("���� � �ʹݿ��� �������� ��� �ϱ� ���� \n�켱������ 3������ ��ǰ���� �Ǹ�,�����մϴ�.\n"); //�������� ���׿� ���� �߰� ���� ��Ʈ
            System.out.println("Ư�� �������� �����ϸ� �߰����� ��ǰ�� �Ǹ�,���� �� �� �ְԵȴ�ϴ�!\n");
            System.out.println("���� �غ� �Ǽ����� yes�� �Է����ּ���!");
            Scanner in2 = new Scanner(System.in);
            String an = in2.nextLine();
            if(an.equals("yes"))
            {
            	System.out.println("�����մϴ�!");
            }else
            {
            	System.out.println("�ý����� �����մϴ�.");
            	System.exit(0);
            }
           
            a.product_Name(p1name);
            b.product_Name(p2name);
            c.product_Name(p3name);
            d.product_Name(p4name);
            e.product_Name(p5name);
            
            a.product_Price(p1price);
            b.product_Price(p2price);
            c.product_Price(p3price);
            d.product_Price(p4price);
            e.product_Price(p5price);
            		
            
           while(true) {
        	   try {
    			Scanner inn = new Scanner(System.in);
    			System.out.println("[���� �޴�] 1.�ֹ� �ޱ� �� �Ǹ�/ 2.���� /3.���ڵ�");	 //������ ǥ��
    			System.out.printf("���� �ڱ���  %d �Դϴ�.\n", money); //���� �ڱ� ǥ��
    			System.out.printf("���� ��������  %d �Դϴ�.\n", satisfaction_score); //���� ������ ǥ��
    			System.out.print("���� �� ��ǰ�� ����� "); //���� ��� ǥ��
    			for(int i = 0;i<product_list.size();i++)
    			{
    				System.out.printf("%d ", product_list.get(i).getQuantity()); //�� ��ǰ�� ��� ����
    			}
    			System.out.print("�Դϴ�.\n");
    			select = inn.nextInt();
    			switch(select) { //�������� ����
    			case 1: //�ֹ��ޱ�
    				System.out.println("�ֹ��� �޽��ϴ�!\n�ֹ��� �������� ���Ϳ�~~!");
    				Order.sell(product_list);
    				money +=Order.total_profit(product_list); //�ڱ� ������Ʈ
    				System.out.println("~~~~~~~~~~~~~~~~~�ֹ� �ޱ� �� �Ǹ� ����~~~~~~~~~~~~~~~\n");
    				if(satisfaction_score>=sscore_add1) //Ư��������1 ������ �� ��° ��ǰ ��Ī
    				{
    					if(product_list.size()==3)
    					{
    					System.out.println(p4name + "�� ���� ��Ī�Ǿ����ϴ�!\n");	
    					product_list.add(d);
    					}
    				}
    				if(satisfaction_score>=sscore_add2) //Ư��������2 ������ �ټ� ��° ��ǰ ��Ī
    				{
    					if(product_list.size()==4)
    					{
    					System.out.println(p5name + "�� ���� ��Ī�Ǿ����ϴ�!\n");
    					product_list.add(e);
    					}
    				}
    				
    				a_product_order[day]=product_list.get(0).Order_quantity();
    				b_product_order[day]=product_list.get(1).Order_quantity();
    				c_product_order[day]=product_list.get(2).Order_quantity();
    				if(day>0)
    				{
    				a_product_production[day]=0;
    				b_product_production[day]=0;
    				c_product_production[day]=0;
    				}
    				if(product_list.size()>=4)
    				{
    					if(product_list.size()==5)
    					{
    						e_product_order[day]=product_list.get(4).Order_quantity();
    						if(day>0)
    						e_product_production[day]=0;
    					}
    				d_product_order[day]=product_list.get(3).Order_quantity();
    				if(day>0)
    				d_product_production[day]=0;
    				}		
    				cost_perday[day]=money;
    				profit_perday[day]=Order.total_profit(product_list);
    				a_product_quantity[day]=product_list.get(0).getQuantity();
        			b_product_quantity[day]=product_list.get(1).getQuantity();
        			c_product_quantity[day]=product_list.get(2).getQuantity();
        			if(product_list.size()>=4)
        			{
        				if(product_list.size()==5)
        				{
        					e_product_quantity[day]=product_list.get(4).getQuantity();
        				}
        				d_product_quantity[day]=product_list.get(3).getQuantity();
        			}
        			
        			
    				day++;
    				break;
    			case 2: //����
    				System.out.println("������ �����մϴ�!\n������ ���귮�� �� �����غ�����~~!");
    				money = money - production_fee; //������ ����
    				Production.set_materialfeerange(product_list); //�������� ����
    				Production.set_productionquan(product_list); 
    				Production.defect_quantity(); //�ҷ�ǰ �߻�
    				Production.production_func(product_list); 
    				money=money-Production.material_price_sum(); // �ܰ� ����
    				System.out.println("~~~~~~~~~~~~~~~~~~~���� ����~~~~~~~~~~~~~~~~~~~\n");
    				
    				
    				defect_cost_perday[day]=production.Production.defect_loss();
    				a_product_production[day]=product_list.get(0).getQuantity();
    				b_product_production[day]=product_list.get(1).getQuantity();
    				c_product_production[day]=product_list.get(2).getQuantity();
    				a_product_order[day]=0;
    				b_product_order[day]=0;
    				c_product_order[day]=0;
    				if(product_list.size()>=4)
    				{
    					if(product_list.size()==5)
    					{
    						e_product_production[day]=product_list.get(4).getQuantity();	
    						e_product_order[day]=0;
    					}
    					d_product_production[day]=product_list.get(3).getQuantity();
    					d_product_order[day]=0;
    				}
    				
    				cost_perday[day]=money;
    				a_product_quantity[day]=product_list.get(0).getQuantity();
        			b_product_quantity[day]=product_list.get(1).getQuantity();
        			c_product_quantity[day]=product_list.get(2).getQuantity();
        			if(product_list.size()>=4)
        			{
        				if(product_list.size()==5)
        				{
        					e_product_quantity[day]=product_list.get(4).getQuantity();
        				}
        				d_product_quantity[day]=product_list.get(3).getQuantity();
        			}
        			
        			
    				day++;
    				break;
    			case 3: //���ڵ�
    				System.out.println("���ڵ带 ���� �̷��� ����� �ǸŸ� �����غ���~~!\n��������� ���ڵ带 ���ðھ��(yes/no)?");
    				String record_option = sc.nextLine();
    				if(record_option.equalsIgnoreCase("yes")) 
    				{
    				 Record r = new Record();
    				 r.check();
    				}
    				else if(record_option.equals("no")){
    					System.out.println("������ ���ðھ��?\n [���� �޴�]�� ���ư��ϴ�.");
    					continue;
    				}else
    				{
    					System.out.println("�߸��� �Է��Դϴ�.");
    					continue;
    				}
    				System.out.println("~~~~~~~~~~~~���ڵ� ���� ����~~~~~~~~~~~~~~~\n");
    				break;
    			default:
    				System.out.println("�߸��� �Է��Դϴ�.");
    				break;
    			}
    			
    			Check_Ending check = new Check_Ending();
    			check.Check_Ending_func();
    			continue;
    			}
           catch(InputMismatchException error2) { //���ø޴����� �����Է��� �ƴҰ�� ����ó��
         	  System.out.println("[�߸� �Է��ϼ̽��ϴ�.]");
         	  System.out.println("[������ �Է����ּ���.]");
               continue;
           }
        	
           }
      }
    		/* else if(user_start.equalsIgnoreCase("no")){ //���ӽ��ۿ� ���� ������ no�� �Է����� ���
    			System.out.println("������ �����մϴ�.");
    				System.exit(0);
    			 }
    		else { //ó�� ���忡�� yes/no�� �������� �ʰ� �߸� �Է��� ���
    			System.out.println("yes/no�� �Է����ּ���!\n");
    			
    		} */
    	
    	/*static void get_Name(Product p,Scanner in)
    	{
    		String p_name;
    		do
    		{
    		p_name = in.nextLine();
    		}while(p_name.equals(""));
    		p.product_Name(p_name);	
    		
    	} */
    	
    	/*static void get_Price(Product p,Scanner in)
    	{
    		int p_price = in.nextInt();
    		p.product_Price(p_price);
    		
    	}*/

    }



