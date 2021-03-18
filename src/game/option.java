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
   public static final int k = 500; //주문량 범위 결정 변수: 1회 최대 주문량 
   public static int money=1000000; //자금
   public static final int success_money = money*10;; // 성공 자금 조건
   public static int satisfaction_score = 100; //만족도
   public static final int production_fee = (int)money/10; //생산비용
   public static final int challenge_money = (int)money/2; // 지원금 
   public static int challenge_again = 0; // 지원금 받아 재도전 여부
   public static int sscore_add1 = 106; //제품 추가할 특정 만족도1
   public static int sscore_add2 = 109; //제품 추가할 특정 만족도2
   static Scanner sc = new Scanner(System.in);
   private static String user_start; //게임입장 여부
   private static int select; //주문 받기 / 생산 선택/ 레코드 선택지 선택
   public static int day = 0; //날짜
   public static int opp = 100; //선택 횟수 record
   // record 위한 변수 per day
   public static int[] a_product_production=new int[opp]; //생산량
   public static int[] b_product_production=new int[opp];
   public static int[] c_product_production=new int[opp];
   public static int[] d_product_production=new int[opp];
   public static int[] e_product_production=new int[opp];
   public static int[] a_product_order=new int[opp]; //주문량
   public static int[] b_product_order=new int[opp];
   public static int[] c_product_order=new int[opp];
   public static int[] d_product_order=new int[opp];
   public static int[] e_product_order=new int[opp]; 
   public static int[] a_product_quantity=new int[opp]; //재고량
   public static int[] b_product_quantity=new int[opp];
   public  static int[] c_product_quantity=new int[opp];
   public static int[] d_product_quantity=new int[opp];
   public static int[] e_product_quantity=new int[opp]; 
   public static int[] defect_cost_perday=new int[opp]; //손실
   public static int[] cost_perday=new int[opp]; //자금
   public  static int[] profit_perday=new int[opp]; //이익
   
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
		  sframe.setTitle("내 꿈은 공장장이");
		  sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  sframe.setVisible(true);
	  });
	  
	  
	  
      ArrayList<Product> product_list = new ArrayList<Product>(); //판매 또는 생산 가능한 제품 리스트
      Product a = new Product_A();
      product_list.add(a);
      Product b = new Product_B();
      product_list.add(b);
      Product c = new Product_C();
      product_list.add(c);
      Product d = new Product_D();
      Product e = new Product_E();
      
      
      for(int i = 0;i<opp;i++) // record용 배열 초기화 
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
      //멘트 수정 ++ 제품 이름
      
      //System.out.println("*$*$*$*-----내 꿈은 공장장------*$*$*$*\n"+"게임을 시작하시겠습니까?(yes/no)");
     
      //user_start = sc.nextLine();
      
      //if(user_start.equalsIgnoreCase("yes")) {
        // System.out.println("\n게임을 시작합니다!\n\t"+"+---------+----------+---------+---------+----------+" + "\n\t본 게임은 랜덤한 주문량을 예측하여 생산하고 판매하는 게임입니다.\n\t판매를 하여 이윤을 얻기 위해서는 적절한 양의 제품을 생산해야겠죠? \n\t"
         		//+ "주문이 들어왔을 때 제품 생산이 되어있지 않으면 제품을 판매할 수 없습니다.\n\t또한,불량품도 생길 수 있으니 주의하세요!(불량품은 손실을 발생시킵니다.)\n\t게임은 특정 목표치의 자금이 되면 성공으로 끝나고,\n\t만족도가 0이  되거나 자본이 0이 되면 실패로 끝이납니다.\n\t그럼 공장을 살려봅시다~!"
         		//+ "\n\t+---------+----------+---------+---------+----------+\n" +"우선, 이름을 입력해주세요");
           
           
            
           /* System.out.println("첫 번째 제품의 제품명을 지정해주세요~~"); //제품명
            Scanner in1 = new Scanner(System.in);
            get_Name(a,in1);
            System.out.println("두 번째 제품의 제품명을 지정해주세요~~");
            get_Name(b,in1);
            System.out.println("세 번째 제품의 제품명을 지정해주세요~~");
            get_Name(c,in1);
            System.out.println("네 번째 제품의 제품명을 지정해주세요~~");
            get_Name(d,in1);
            System.out.println("다섯 번째 제품의 제품명을 지정해주세요~~");
            get_Name(e,in1); */
            
           
            
     /* while(true){  
      try { //사용자가 정수를 입력하지 않아서 가격 설정이 안될 경우 예외처리
            Scanner in2 = new Scanner(System.in);
            System.out.println("첫 번째 제품의 희망 가격을 지정해주세요~~"); //제품별 가격
             get_Price(a,in2);
             System.out.println("두 번째 제품의 희망 가격을 지정해주세요~~"); //제품별 가격
             get_Price(b,in2);
             System.out.println("세 번째 제품의 희망 가격을 지정해주세요~~"); //제품별 가격
             get_Price(c,in2);
             System.out.println("네 번째 제품의 희망 가격을 지정해주세요~~"); //제품별 가격
             get_Price(d,in2);
             System.out.println("다섯 번째 제품의 희망 가격을 지정해주세요~~"); //제품별 가격
             get_Price(e,in2);
      }catch(InputMismatchException error1) {
    	  System.out.println("[잘못 입력하셨습니다.]");
    	  System.out.println("[정수를 입력해주세요.]");
          continue; //정수를 입력할 때까지 사용자에게 가격을 계속 입력받는다.
      }catch(NullPointerException error2) {
    	  System.out.println("[값를 입력해주세요.]");
          continue; //정수를 입력할 때까지 사용자에게 가격을 계속 입력받는다.
      }
      break;
      }*/
      
      
           // System.out.println("환영합니다~!"+user_name+"님 게임을 시작합니다!\n");
            System.out.println("공장 운영 초반에는 안정적인 운영을 하기 위해 \n우선적으로 3가지의 제품만을 판매,생산합니다.\n"); //세부적인 사항에 대한 추가 설명 멘트
            System.out.println("특정 만족도에 도달하면 추가적인 제품을 판매,생산 할 수 있게된답니다!\n");
            System.out.println("시작 준비가 되셨으면 yes를 입력해주세요!");
            Scanner in2 = new Scanner(System.in);
            String an = in2.nextLine();
            if(an.equals("yes"))
            {
            	System.out.println("시작합니다!");
            }else
            {
            	System.out.println("시스템을 종료합니다.");
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
    			System.out.println("[선택 메뉴] 1.주문 받기 및 판매/ 2.생산 /3.레코드");	 //선택지 표시
    			System.out.printf("현재 자금은  %d 입니다.\n", money); //현재 자금 표시
    			System.out.printf("현재 만족도는  %d 입니다.\n", satisfaction_score); //현재 만족도 표시
    			System.out.print("현재 각 제품의 재고량은 "); //현재 재고량 표시
    			for(int i = 0;i<product_list.size();i++)
    			{
    				System.out.printf("%d ", product_list.get(i).getQuantity()); //각 제품의 재고량 참조
    			}
    			System.out.print("입니다.\n");
    			select = inn.nextInt();
    			switch(select) { //선택지에 따라
    			case 1: //주문받기
    				System.out.println("주문을 받습니다!\n주문이 마구마구 들어와요~~!");
    				Order.sell(product_list);
    				money +=Order.total_profit(product_list); //자금 업데이트
    				System.out.println("~~~~~~~~~~~~~~~~~주문 받기 및 판매 종료~~~~~~~~~~~~~~~\n");
    				if(satisfaction_score>=sscore_add1) //특정만족도1 만족시 네 번째 제품 런칭
    				{
    					if(product_list.size()==3)
    					{
    					System.out.println(p4name + "이 새로 런칭되었습니다!\n");	
    					product_list.add(d);
    					}
    				}
    				if(satisfaction_score>=sscore_add2) //특정만족도2 만족시 다섯 번째 제품 런칭
    				{
    					if(product_list.size()==4)
    					{
    					System.out.println(p5name + "이 새로 런칭되었습니다!\n");
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
    			case 2: //생산
    				System.out.println("생산을 시작합니다!\n적당한 생산량을 잘 생각해보세요~~!");
    				money = money - production_fee; //생산비용 지출
    				Production.set_materialfeerange(product_list); //제조원가 흥정
    				Production.set_productionquan(product_list); 
    				Production.defect_quantity(); //불량품 발생
    				Production.production_func(product_list); 
    				money=money-Production.material_price_sum(); // 단가 지출
    				System.out.println("~~~~~~~~~~~~~~~~~~~생산 종료~~~~~~~~~~~~~~~~~~~\n");
    				
    				
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
    			case 3: //레코드
    				System.out.println("레코드를 통해 미래의 생산과 판매를 예측해봐요~~!\n현재까지의 레코드를 보시겠어요(yes/no)?");
    				String record_option = sc.nextLine();
    				if(record_option.equalsIgnoreCase("yes")) 
    				{
    				 Record r = new Record();
    				 r.check();
    				}
    				else if(record_option.equals("no")){
    					System.out.println("다음에 보시겠어요?\n [선택 메뉴]로 돌아갑니다.");
    					continue;
    				}else
    				{
    					System.out.println("잘못된 입력입니다.");
    					continue;
    				}
    				System.out.println("~~~~~~~~~~~~레코드 보기 종료~~~~~~~~~~~~~~~\n");
    				break;
    			default:
    				System.out.println("잘못된 입력입니다.");
    				break;
    			}
    			
    			Check_Ending check = new Check_Ending();
    			check.Check_Ending_func();
    			continue;
    			}
           catch(InputMismatchException error2) { //선택메뉴에서 정수입력이 아닐경우 예외처리
         	  System.out.println("[잘못 입력하셨습니다.]");
         	  System.out.println("[정수를 입력해주세요.]");
               continue;
           }
        	
           }
      }
    		/* else if(user_start.equalsIgnoreCase("no")){ //게임시작에 대한 물음에 no를 입력했을 경우
    			System.out.println("게임을 종료합니다.");
    				System.exit(0);
    			 }
    		else { //처음 입장에서 yes/no를 선택하지 않고 잘못 입력한 경우
    			System.out.println("yes/no로 입력해주세요!\n");
    			
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



