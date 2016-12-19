package mainPackage;

public class DataMain {

	public static void main(String[] args) {
		
		Data data = new Data(0,-999 , 3.20, -0 , -999, 32.8);
		
		data.solveData();
		System.out.println(data);
		
		data = new Data(0,-999 , -999, 0 , 110, 5.21);
		data.solveData();
		System.out.println(data);
	}
}
