package game;
import java.util.Scanner;
import game.option;

public class Check_Ending 
{
	public void Check_Ending_func()
	{
		  if(option.money>=option.success_money)
          {
             System.out.println("����!");
             System.out.println("������ �������� ����� �̷�³׿�!\n�����δ� ���������� ������ ��� �� ���� �� ���ƿ�~\n���� ���� ������ ������~!");
             System.exit(0);
          }
		  
		  if(option.money<0) //��������1
			{
				if(option.challenge_again==0) {
				System.out.println("������! ������ $$$���� �帳�ϴ�! �̾ �����Ͻðڽ��ϱ�?(yes/no)");
				Scanner inin = new Scanner(System.in);
				String ans = inin.nextLine();
				if(ans.equals("yes"))
				{
					option.challenge_again++;
					option.money += option.challenge_money;
					
				}else
				{
					System.out.println("����!");
  				System.exit(0);
				}
			}else
			{
				System.out.println("����!");
				System.exit(0);
			}
				}
		  
		  if(option.satisfaction_score<=0) //��������2
			{
				System.out.println("����!");
				System.exit(0);
			}

	}
}
