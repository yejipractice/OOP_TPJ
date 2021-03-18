package production;
import java.util.ArrayList;
import java.util.Scanner;

import game.option;
import product.Product;
import random.Random_func;
import random.Defect_rand;

public class Production 
{
   static int[] production_plan_quantity = new int[5]; //���ĺ� ������ ��
   private static int[] price = {0,0,0,0,0}; //��ǰ�� �ǸŰ���
   static int[] range_start = {0,0,0,0,0}; // �ܰ� ���� ����
   static int[] range_end = {0,0,0,0,0};
   static int[] material_fee = {0,0,0,0,0};
   static int[] production_quantity = {0,0,0,0,0};//(����+�ҷ�ǰ) �� ���� ����
   static int[] defect_quantity = {0,0,0,0,0};//�ҷ�ǰ ���� ����
  
   public static void check_materialfeerange(ArrayList<Product> list) //�ܰ�����
   {
      for(int i = 0;i<list.size();i++)
      {
         price[i]=list.get(i).getPrice();
      }
      for(int i =0; i<production_quantity.length;i++)
      {
         range_start[i]=(int)(price[i]*0.35); //�ø����� �������� ����
      }
      for(int i =0; i<production_quantity.length;i++)
      {
         range_end[i]=(int)(price[i]*0.55); //�ø����� �������� ����
      }
   }
   
    public static void set_materialfeerange(ArrayList<Product> list) //�ܰ� ���� ���� ����
    {
       check_materialfeerange(list);
       for(int i = 0;i<list.size();i++)
       {
       System.out.printf("%d��° ��ǰ�� �ܰ��� �Է��ϼ���!",i+1);
       Scanner in = new Scanner(System.in);
       int ans = in.nextInt();
       if(ans>=range_start[i]&&ans<=range_end[i])
       {
          material_fee[i]=ans;
          
       }
       else if(ans>range_end[i])
       {
          System.out.println("�ܰ��� �ʹ� Ŀ�� �ȵſ�!");   
          i--;
          continue;
       }
       else if(ans<range_start[i])
       {
          System.out.println("�ܰ��� �ʹ� �۾Ƽ� �ȵſ�!");
          i--;
          continue;
       }
       
       }
       
    }
    
    public static void set_productionquan(ArrayList<Product> list) //��ǰ�� ���귮 �Է�
    {
       for(int i =0;i<list.size();i++)
       {
          String p_name = list.get(i).getName();
          System.out.printf("%s ��ǰ�� �� �� �����Ͻðڽ��ϱ�?",p_name);
          Scanner in = new Scanner(System.in);
          production_plan_quantity[i] = in.nextInt();
       }
    }
    public static void defect_quantity(){ //�ҷ�ǰ�� ���� �Լ�
       Defect_rand dr = new Defect_rand();

       double dp = dr.defect_ran();
       for(int i =0;i<defect_quantity.length;i++)
        {
          defect_quantity[i] = (int) Math.ceil(production_plan_quantity[i]*dp) ;
        }
       
    }
    public static int defect_loss(){ //�� �ս� �Լ�
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
     
    
    public static void production_func(ArrayList<Product> list){ //���� �Լ�(���갳��-�ҷ�ǰ����)
       for(int i =0;i<production_quantity.length;i++){
          production_quantity[i] = production_plan_quantity[i]- defect_quantity[i];
       }
       for(int i =0;i<list.size();i++){  //���
          int a = list.get(i).getQuantity();
          a += production_quantity[i];
          list.get(i).product_quantity(a);
       }
       System.out.print("������ �Ϸ�Ǿ����ϴ�!\n������� ��ǰ ���� "); //
       for(int i=0;i<production_quantity.length;i++)
       {
    	   int a=production_quantity[i];
    	   System.out.printf("%d ", a);
       }
       
       System.out.print("\n�߻��� �ҷ�ǰ ���� "); //
       for(int i=0;i<production_quantity.length;i++)
       {
    	   int a=defect_quantity[i];
    	   System.out.printf("  %d", a);
       }
       System.out.println("");
       
    }
    
    
       
    }
