package game;
import java.util.Scanner;
import game.option;

public class Check_Ending 
{
	public void Check_Ending_func()
	{
		  if(option.money>=option.success_money)
          {
             System.out.println("성공!");
             System.out.println("공장이 성공적인 결과를 이뤄냈네요!\n앞으로는 안정적으로 공장을 운영할 수 있을 것 같아요~\n나는 이제 진정한 공장장~!");
             System.exit(0);
          }
		  
		  if(option.money<0) //실패조건1
			{
				if(option.challenge_again==0) {
				System.out.println("돈부족! 지원금 $$$원을 드립니다! 이어서 도전하시겠습니까?(yes/no)");
				Scanner inin = new Scanner(System.in);
				String ans = inin.nextLine();
				if(ans.equals("yes"))
				{
					option.challenge_again++;
					option.money += option.challenge_money;
					
				}else
				{
					System.out.println("실패!");
  				System.exit(0);
				}
			}else
			{
				System.out.println("실패!");
				System.exit(0);
			}
				}
		  
		  if(option.satisfaction_score<=0) //실패조건2
			{
				System.out.println("실패!");
				System.exit(0);
			}

	}
}
