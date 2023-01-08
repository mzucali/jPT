package tools;

public class ArrayTranspose {

	public ArrayTranspose(){
		
	}
	public static String[][] transpose(String[][] x) {
//int i = x.length;
//int j = x[0].length;
//		System.out.println("x.length: "+i+" x[i].length: "+j);
		String[][] data1 = x;
		
		String[][] data2 = new String[x[0].length][x.length];

		for (int row = 0; row < data1.length; row++) {

			for (int col = 0; col < data1[0].length; col++) {

				data2[col][row] = data1[row][col];
			//	System.out.println("MatrixT["+col+"]["+row+"] = " + data2[col][row]);
			}
		}
		System.out.println("");
	return data2;
	}
}
