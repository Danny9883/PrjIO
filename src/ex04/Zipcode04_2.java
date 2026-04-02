package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode04_2 {

	public static void main(String[] args) throws IOException {
		// ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
//		4. 한국의 시도명 출력 - 17건 
		// 키보드 입력
		Scanner         in   = new Scanner(System.in); 
		
				
		// File
		String       path    = Zipcode04_2.class.getResource("").getPath();
		String       fname   = "zipcode.csv";
		File         file    = new File( path + fname );
		
		FileReader      fr   = new FileReader(file);
		BufferedReader  br   = new BufferedReader(fr);
		
		String       title   = br.readLine();  // 제목줄 skip
		String       line    = "";
		int  cnt = 0;
		
		System.out.println(" 시/도 ");
		String       inAddr   = "";
		
		while ( (line = br.readLine()) != null ) {
			String [] li      = line.trim().split(",");
			String   zipcode  = li[0].trim();
			String   sido     = li[1].trim();
			String   gugun 	  = li[2].trim();
			String   dong     = li[3].trim();
			String   bunji    = li[4].trim();
			int      seq      = Integer.parseInt(li[5].trim());
			
			
			// 4. 시/도  리스트:
			if ( !sido.equals(inAddr) ) {
				String  fmt = " %s  \n";
				String addr = String.format(fmt,sido);
				System.out.print( addr );
				inAddr = sido;
				cnt++;
			}
		} // while end
		
		System.out.println( cnt + " 건 " );
		
		
		br.close();
		fr.close();
		
		
	} // main end

} // class end
