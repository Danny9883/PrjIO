package ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

	public static void main(String[] args) throws IOException {
		
		String    path    = "D:/dev/java/PrjIO/src/ex01/";
		String   filename = "bts.txt";
		
		FileReader     fr   = new FileReader(path + filename);
		BufferedReader br   = new BufferedReader(fr);
		
		String        line  = "";
		int  n = 0;
		while ( (line =  br.readLine()) != null) {
			System.out.println(line);
			n++;
		}
		System.out.println( n + " 라인 출력했습니다");
		
		br.close();
		fr.close();
		
	}

}
