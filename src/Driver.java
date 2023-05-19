import java.util.Scanner;
import java.util.Random;
public class Driver {

	public static void main(String[] args) {	
		Scanner in=new Scanner(System.in);
		
		System.out.println("------------------- Player Game -------------------\n");
		// in this game the computer choose two player from teams randomly and ask question randomly
				
		String name=null;		
		int age=0;
		double height=0;
		
		
		int num_player=0;
		int num_team=0;
		String s="c";
		for(;;) {
		
		
		if(s.equals("s") || s.equals("S")) {
			System.out.println("\nThe program is closed. ");
			System.out.println("------------------------------------------\n");
			break;
		}
		else {
		System.out.print("Please enter the number of players: ");	
		num_player=in.nextInt();
		while(num_player<=1) {
			System.out.println("################################################");
			System.out.println("number of player should greater than 1 !!!"+"\n");
			System.out.print("please re-enter the number of players: ");
			num_player=in.nextInt();
			System.out.println("------------------------------------------------");
		}
		System.out.print("Please enter number of team: ");	
		num_team=in.nextInt();
		
		while(num_team<=1) {
			System.out.println("################################################");
			System.out.println("number of team should greater than 1 !!!"+"\n");
			System.out.print("please re-enter the number of teams: ");
			num_team=in.nextInt();
			System.out.println("------------------------------------------------");
		}
		
		Player player_arr[][]=new Player[num_team][];	
		
		Random rand=new Random();
		
		
		for(int i=0;i<player_arr.length;i++) {
			int min=((num_player/num_team)-1); 
			int max=((num_player/num_team)+2);	
			
			
			int num_p=rand.nextInt(max);
			
			if(num_team==1) {		
				num_p=num_player;
			}
			else if(num_team==num_player) {
				num_p=1;
			}
			else {
				while(num_p<min || num_p>max || num_p==0 ||num_p==num_player) {
					num_p=rand.nextInt();
				}

				
			}
			num_player=num_player-num_p;
			
			System.out.print("\nTeam #"+(i+1)+" have: "+num_p+" players.\n");
			
			player_arr[i]=new Player[num_p];
			for(int j=0;j<player_arr[i].length;j++) {
				System.out.println("--------------------------------");
				System.out.print("Please enter information about players "+(j+1)
						+ " into team "+(i+1)+": \n");
				System.out.print("Name: ");	//ask user to enter the name
				name=in.next();
				System.out.print("Age: "); //ask user to enter the age
				age=in.nextInt();
				System.out.print("Height: "); //ask user to enter the height
				height=in.nextDouble();
				player_arr[i][j]=new Player(name,age,height);
			}
			num_team--;
			System.out.println("=================================================");
		}
		
	

		
		
		System.out.println("The average height of all players were : "+(int)avgHeight(player_arr));
		System.out.println("\n##################### Let's Start The Game #####################"+"\n");
		int c=3;
		Player pl[]=new Player[c];
		
		askPlayer(pl);
		
		System.out.print("\n"+"press 's' or 'S' to stop the game  OR  press any another key to continue: ");
		s=in.next();
		
			}
		}
	}
	
		
	public static double avgHeight(Player [][] player_arr) { //method to get average of height
		double sum = 0;
		double count = 0;
		for (int i= 0; i<player_arr.length;i++) {
		    for (int j= 0;j<player_arr[i].length;j++) {
		        sum= sum+player_arr[i][j].getheight();
		        count++;
		    }
		}
		double average= sum/count;
		return average;
	}

	
	public static Player[][] choosePlayer(Player[][] player) {//method to chose two player
		int count_player= 0;
		int count_team= 0;
		Random r = new Random();
		 
		for (int i = 0; i < player.length; i++) {
			count_team++;
			 for (int j = 0; j < player[i].length; j++) {
				 count_player++;
			    }
		}
		int rand_player = r.nextInt(count_player);
		int rand_team = r.nextInt(count_team);
		Player n[][]=new Player[rand_player][rand_team];

		
		return n;
	}
	
	public static void askPlayer(Player[] player) { //method to ask 4 question for those two player
		Scanner m=new Scanner(System.in);
		Random r = new Random();
		int count1=0;
		int count2=0;
		int x1=0;
		int [] array1 = new int[x1];
		for(int i=0;i<1;i++) {
			System.out.println("Question for Player #"+(i+1)+": ");
		for(int j=0;j<4;j++) {
		System.out.println("Question #"+(j+1)+"\n");
		int x = r.nextInt(100);
		while(x<=0) {
			x = r.nextInt(100);
		}
		
		int y = r.nextInt(100);
		
		while(y<=0) {
			y = r.nextInt(100);
		}
		
		int index = r.nextInt(3);
		//Player[] array = new Player[index];
		double res;
		
		if(index==0) {
			int q_1 = r.nextInt(3);
			if(q_1==0) {
				System.out.print(x+" * "+y+"= ");
				res=m.nextDouble();
				if(res==x*y) {
					count1++;
				}
			}
			else if(q_1==1) {
				System.out.print(x+" / "+y+"= ");
				res=m.nextDouble();
				if(res==x/y) {
					count1++;
				}
			}
			else if(q_1==2) {
				System.out.print(x+" % "+y+"= ");
				res=m.nextDouble();
				if(res==x%y) {
					count1++;
				}
			}
			else if(q_1==3) {
				System.out.print(x+"^("+y+")= ");
				res=m.nextDouble();
				if(res==Math.pow(x,y)) {
					count1++;
				}
				
			}
		}
		////////////////////////////////////
		else if(index==1) {
			int q_2 = r.nextInt(1);
			if(q_2==0) {
				System.out.print("Floor ("+x+")= ");
				res=m.nextDouble();
				if(res==Math.floor(x)) {
					count1++;
				}
				
			}
			else if(q_2==1) {
				System.out.print("Ceil ("+x+")= ");
				res=m.nextDouble();
				if(res==Math.ceil(x)) {
					count1++;
				}
			}
		}
		///////////////////////////////////
		else if(index==2) {
			int q_3 = r.nextInt(1);
			if(q_3==0) {
				System.out.print("Cos("+x+")= ");
				res=m.nextDouble();
				if(res==Math.cos(Math.toRadians(x))) {
					count1++;
				}
			}
			else if(q_3==1) {
				System.out.print("Sin("+x+")= ");
				res=m.nextDouble();
				if(res==Math.sin(Math.toRadians(x))) {
					count1++;
				}
			}
		}
		////////////////////////////////////
		else if(index==3) {
			System.out.print("Log10("+x+")= ");
			res=m.nextDouble();
			if(res==Math.log10(x)) {
				count1++;
			}
			
		}
		System.out.println("---------------------------");
		}
		for(int l=0;l<1;l++) {
			System.out.println("Question for Player #"+(l+2)+": ");
		for(int j=0;j<4;j++) {
			System.out.println("Question #"+(j+1)+"\n");
			int x = r.nextInt(100);
			while(x<=0) {
				x = r.nextInt(100);
			}
			
			int y = r.nextInt(100);
			
			while(y<=0) {
				y = r.nextInt(100);
			}
			
			int index = r.nextInt(3);
			//Player[] array = new Player[index];
			double res;
			
			if(index==0) {
				int q_1 = r.nextInt(3);
				if(q_1==0) {
					System.out.print(x+" * "+y+"= ");
					res=m.nextDouble();
					if(res==x*y) {
						count2++;
					}
				}
				else if(q_1==1) {
					System.out.print(x+" / "+y+"= ");
					res=m.nextDouble();
					if(res==x/y) {
						count2++;
					}
				}
				else if(q_1==2) {
					System.out.print(x+" % "+y+"= ");
					res=m.nextDouble();
					if(res==x%y) {
						count2++;
					}
				}
				else if(q_1==3) {
					System.out.print(x+"^("+y+")= ");
					res=m.nextDouble();
					if(res==Math.pow(x,y)) {
						count2++;
					}
					
				}
			}
			////////////////////////////////////
			else if(index==1) {
				int q_2 = r.nextInt(1);
				if(q_2==0) {
					System.out.print("Floor ("+x+")= ");
					res=m.nextDouble();
					if(res==Math.floor(x)) {
						count2++;
					}
					
				}
				else if(q_2==1) {
					System.out.print("Ceil ("+x+")= ");
					res=m.nextDouble();
					if(res==Math.ceil(x)) {
						count2++;
					}
				}
			}
			///////////////////////////////////
			else if(index==2) {
				int q_3 = r.nextInt(1);
				if(q_3==0) {
					System.out.print("Cos("+x+")= ");
					res=m.nextDouble();
					if(res==Math.cos(Math.toRadians(x))) {
						count2++;
					}
				}
				else if(q_3==1) {
					System.out.print("Sin("+x+")= ");
					res=m.nextDouble();
					if(res==Math.sin(Math.toRadians(x))) {
						count2++;
					}
				}
			}
			////////////////////////////////////
			else if(index==3) {
				System.out.print("Log10("+x+")= ");
				res=m.nextDouble();
				if(res==Math.log10(x)) {
					count2++;
				}
				
			}
			System.out.println("---------------------------");
			}
		}
		System.out.println("=================================================");
		}
		if(count1>count2) {
			System.out.println("The winner is Player #1\nHe/She has answered "+count1+
					"/4 question but player #2 has answered "+count2+"/4 questions");
		}
		else if(count1<count2) {
			System.out.println("The winner is Player #2\nHe/She has answered "+count2+
					"/4 question but player #1 has answered "+count1+"/4 questions");
		}
		else if(count1==0 && count2==0) {
			System.out.println("We have two losers \nPlayer #1 He/She has answered "+count1+
					"/4 question and player #2 has answered "+count2+"/4 questions");
		}
		else if(count1==4 && count2==4) {
			System.out.println("We have two winners \nPlayer #1 He/She has answered "+count1+
					"/4 question and player #2 has answered "+count2+"/4 questions");
		}
		else if(count1==count2) {
			System.out.println("We have two players tied \nPlayer #1 He/She has answered "+count1+
					"/4 question and player #2 has answered "+count2+"/4 questions");
		}
	}
	
}
