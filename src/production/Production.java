package production;
import java.util.ArrayList;
import java.util.Scanner;

import game.option;
import product.Product;
import random.Random_func;
import random.Defect_rand;

public class Production 
{
   static int[] production_plan_quantity = new int[5]; //제픔별 생산할 양
   private static int[] price = {0,0,0,0,0}; //제품별 판매가격
   static int[] range_start = {0,0,0,0,0}; // 단가 가능 범위
   static int[] range_end = {0,0,0,0,0};
   static int[] material_fee = {0,0,0,0,0};
   static int[] production_quantity = {0,0,0,0,0};//(정상+불량품) 총 생산 개수
   static int[] defect_quantity = {0,0,0,0,0};//불량품 생산 개수
  
   public static void check_materialfeerange(ArrayList<Product> list) //단가범위
   {
      for(int i = 0;i<list.size();i++)
      {
         price[i]=list.get(i).getPrice();
      }
      for(int i =0; i<production_quantity.length;i++)
      {
         range_start[i]=(int)(price[i]*0.35); //올림할지 내림할지 생각
      }
      for(int i =0; i<production_quantity.length;i++)
      {
         range_end[i]=(int)(price[i]*0.55); //올림할지 내림할지 생각
      }
   }
   
    public static void set_materialfeerange(ArrayList<Product> list) //단가 범위 내의 흥정
    {
       check_materialfeerange(list);
       for(int i = 0;i<list.size();i++)
       {
       System.out.printf("%d번째 제품의 단가를 입력하세요!",i+1);
       Scanner in = new Scanner(System.in);
       int ans = in.nextInt();
       if(ans>=range_start[i]&&ans<=range_end[i])
       {
          material_fee[i]=ans;
          
       }
       else if(ans>range_end[i])
       {
          System.out.println("단가가 너무 커서 안돼요!");   
          i--;
          continue;
       }
       else if(ans<range_start[i])
       {
          System.out.println("단가가 너무 작아서 안돼요!");
          i--;
          continue;
       }
       
       }
       
    }
    
    public static void set_productionquan(ArrayList<Product> list) //제품별 생산량 입력
    {
       for(int i =0;i<list.size();i++)
       {
          String p_name = list.get(i).getName();
          System.out.printf("%s 제품을 몇 개 생산하시겠습니까?",p_name);
          Scanner in = new Scanner(System.in);
          production_plan_quantity[i] = in.nextInt();
       }
    }
    public static void defect_quantity(){ //불량품의 개수 함수
       Defect_rand dr = new Defect_rand();

       double dp = dr.defect_ran();
       for(int i =0;i<defect_quantity.length;i++)
        {
          defect_quantity[i] = (int) Math.ceil(production_plan_quantity[i]*dp) ;
        }
       
    }
    public static int defect_loss(){ //총 손실 함수
       int loss_sum = 0;
       for(int i =0;i<defect_quantity.length;i++){
          int loss = defect_quantity[i]*material_fee[i];
          loss_sum+=loss;
          
       }
        return loss_sum;
    }
    
    public static int material_price_sum(){ 
        int sum = 0;
        for(int i =0;i<production_plan_quantity.length;i++){
           int mprice = production_plan_quantity[i]*material_fee[i];
           sum+=mprice;
           
        }
         return sum;
     }
     
    
    public static void production_func(ArrayList<Product> list){ //생산 함수(생산개수-불량품개수)
       for(int i =0;i<production_quantity.length;i++){
          production_quantity[i] = production_plan_quantity[i]- defect_quantity[i];
       }
       for(int i =0;i<list.size();i++){  //재고
          int a = list.get(i).getQuantity();
          a += production_quantity[i];
          list.get(i).product_quantity(a);
       }
       System.out.print("생산이 완료되었습니다!\n만들어진 제품 수는 "); //
       for(int i=0;i<production_quantity.length;i++)
       {
    	   int a=production_quantity[i];
    	   System.out.printf("%d ", a);
       }
       
       System.out.print("\n발생한 불량품 수는 "); //
       for(int i=0;i<production_quantity.length;i++)
       {
    	   int a=defect_quantity[i];
    	   System.out.printf("  %d", a);
       }
       System.out.println("");
       
    }
    
    
       
    }
