public class HammingDistance {

	public static int hammingDistance(int x, int y){
		int num=0;
		String str=Integer.toBinaryString(x^y);
		for (int i = 0; i <str.length() ; i++) {
			if(str.charAt(i)=='1'){
				num++;
			}
		}
		return num;
	}   
}

public class TortoiseHareRace {
    public void game(int hareSpeed, int hareSleepDuration, int tortoiseSpeed, int distance){
        //add some codes here
        Tortoise gui=new Tortoise(tortoiseSpeed,distance);
        Hare tu=new Hare(hareSpeed,hareSleepDuration,distance,tortoiseSpeed);
        while (tu.getdistance()>0 && gui.getdistance()>0){
            tu.race();
            gui.race();
        }
        if(tu.getdistance()<=0 && gui.getdistance()<=0)
            AnimalRacer.win();
        else if(gui.getdistance()<=0)
            gui.win();
        else
            tu.win();
    }
}
