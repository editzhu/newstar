


public class NewStar {
	static final int MAXX=6;
	static final int MAXY=6;
	static int[][] maps= new int[MAXX][MAXY];
	static int[][] maps1= new int[MAXX][MAXY];
	static int[] tmpMap = new int[8];
	public static void iniMaps(){
		for (int i = 0;i<MAXX;i++)
			for (int j = 0 ;j<MAXY;j++){
				maps[i][j]=0;
			}
		maps[2][2]=1;
		maps[5][2]=1;
		maps[5][5]=1;
		maps[2][5]=1;
	}
	public static void iniTmpMap(){
		for (int i =0 ;i<8;i++)
			tmpMap[i]=0;
	}
	public static boolean check(int i,int j){
//		System.out.println("check");
		int total = 0;
		iniTmpMap();
		tmpMap[0]=maps[i-1][j-1];
		tmpMap[1]=maps[i-1][j];
		tmpMap[2]=maps[i-1][j+1];
		tmpMap[3]=maps[i][j-1];
		tmpMap[4]=maps[i][j+1];
		tmpMap[5]=maps[i+1][j-1];
		tmpMap[6]=maps[i+1][j];
		tmpMap[7]=maps[i+1][j+1];
		for(int k = 0 ;k<8;k++)
			total += tmpMap[k];
//		System.out.println("("+i+","+j+")="+total);
		if (total>0&&total<3)
			return true;
		else 
			return false;
	}
	public static void choose1(int i ,int j,boolean b){
//		System.out.println("choose1");
		if(b)maps1[i][j]=1;
		else maps1[i][j]=0;
	}
	public static void choose(int i ,int j){
		 int[] set = new int [8];
		 int k = 0;
		 for(int l=0;l<8;l++)
			 if (tmpMap[l]==0)
				 set[k++]=l;
//		 System.out.println(i+":"+j+":有N个:"+k);
		 int c = (int)(Math.random()*k);
//		 System.out.println("c:"+c);
			if(c==0)maps[i-1][j-1]=1;
			else if(c==1)maps1[i-1][j]=1;
			else if(c==2)maps1[i-1][j+1]=1;
			else if(c==3)maps1[i][j-1]=1;
			else if(c==4)maps1[i][j+1]=1;
			else if(c==5)maps1[i+1][j-1]=1;
			else if(c==6)maps1[i+1][j]=1;
			else if(c==7)maps1[i+1][j+1]=1;
				 
	}
	public static void begin(){
		for (int i = 1;i<MAXX-1;i++)
			for (int j = 1 ;j<MAXY-1;j++){
					choose1(i,j,check(i,j));
			}		
}
	public static void copy(){
		for (int i = 0;i<MAXX;i++)
			for (int j = 0 ;j<MAXY;j++){
				maps[i][j]=maps1[i][j];
			}	

}
	public static String get(){
		String s="";
		for (int i=0;i<MAXX;i++)
			for (int j=0;j<MAXY;j++)
				s=s+(int)(Math.random()*2);
		return s;
	}
	public static String get1(String str){
		if(str.equals("null")){
			System.out.println("is null begin to ini");
			iniMaps();
			iniTmpMap();
		}
		System.out.println("进来的时候是这样的:"+str);
		if(!str.equals("null")){
			for (int i=0;i<str.length();i++){
//				System.out.println("aaa"+((int)(i/MAXX))+":"+(i-(int)(i/MAXX)*MAXX)+":"+(Integer.parseInt(str.substring(i,i+1))));
				maps[(int)(i/MAXX)][i-(int)(i/MAXX)*MAXX]=Integer.parseInt(str.substring(i,i+1));
			}
		}


		String s ="";

			
			int total = 0;
			for (int i=0;i<MAXX;i++){
				for (int j=0;j<MAXY;j++){
					total+=maps[i][j];
					s=s+maps[i][j];
				}
			}
			System.out.println("TOTAL =:"+total);
			System.out.println("转化成数组后是这样的:"+s);			
			begin();
			copy();
			s="";
			for (int i=0;i<MAXX;i++){
				for (int j=0;j<MAXY;j++){
					total+=maps[i][j];
					s=s+maps[i][j];
				}
			}
		System.out.println("经过演算后是这样的:"+s);
		return s;
	}
	
}

