package fixtureCreator;

import java.util.*;

public class fixtureGenerator {

	
	public ArrayList<String> teams=new ArrayList<String>();
	public ArrayList<String> weeksPassed=new ArrayList<String>();
	public ArrayList<String> weeksRevenge=new ArrayList<String>();
	
	public int teamsCount;
	public int week=0;
	
	public fixtureGenerator() {
		System.out.println("Fikstur olusturma projesine hosgeldiniz!");
		
		Scanner input=new Scanner(System.in);
		int choosen=0;
		
		while(choosen!=2) {
			System.out.println("Takim eklemek icin 1'i , Fikstur olusturmak icin 2'yi secin");
			choosen=input.nextInt();
			if(choosen==1) {
				this.teamAdd(); //bu satır mevcut sınıf içindeki takım eklemek için oluşturulmuş fonksiyonu çağırmaktadır
			}
		}
		
		if(this.teams.size()%2==1) {
			this.teams.add("BAY");
		}
		
		this.teamsCount=this.teams.size();
		this.teamsListing(); // takımları listeleyen fonksiyonu çağırmaktadır
		
		Random random=new Random();
		int match=0;
		ArrayList<String> copy=new ArrayList<String>(); /*bu arraylist karşılaşan takımların müsabakalarını kaydedecek. böylelikle ev sahibi-deplasman sırası 
		değişmiş ve rövanş gerçekleşmiş olacak*/
		
		while(match<teamsCount/2) {
			String home=this.teams.get(random.nextInt(teamsCount));
			String away=this.teams.get(random.nextInt(teamsCount));
			
			if(!home.equals(away)&& !copy.contains(home) && copy.contains(away) && weeksPassed.contains(home+away) && !weeksRevenge.contains(home+" vs "+ away)) {
				copy.add(home);
				copy.add(away);
				weeksPassed.add(home+away);
				this.weeksRevenge.add(away+" vs "+home);
				System.out.println(home+" vs "+away);
				match++;
			}
		}
		
		printRevenge();
		
	}
	
	
	//Bu fonksiyon, kullanıcıdan alınan string değerini takımlar arraylistine ekler.
	public void teamAdd() {
		Scanner input=new Scanner(System.in);
		System.out.println("Eklemek istediginiz takim adini girin : \n");
		String teamName=input.nextLine();
		this.teams.add(teamName);
		
	}
	

	public void teamsListing() {
		for(int i=0;i<teams.size();i++) {
			System.out.println(teams.get(i));
		}
	}
	
	
	public void printRevenge() {
		System.out.println(this.week+1+"week");
		int matches=0;
		for(String match:weeksRevenge) {
			matches++;
			System.out.println(match);
			if(matches>(this.teamsCount/2-1)) {
				this.week++;
				if(this.week<(this.teamsCount-1)*2) {
					System.out.println(this.week+1+". week");
				}
				matches=0;
			}
			
		}
	}
	
}
