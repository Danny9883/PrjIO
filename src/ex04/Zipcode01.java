package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode01 {

	public static void main(String[] args) throws IOException {
		// ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		// 1. 전국의 롯데백화점의 갯수 출력
		
		String       path    = Zipcode01.class.getResource("").getPath();
		String       fname   = "zipcode.csv";
		File         file    = new File( path + fname );
		
		FileReader      fr   = new FileReader(file);
		BufferedReader  br   = new BufferedReader(fr);
		
		String       title   = br.readLine();  // 제목줄 skip
		String       line    = "";
		
		int  cnt = 0;
		while ( (line = br.readLine()) != null ) {
			String [] li      = line.trim().split(",");
			String   zipcode  = li[0].trim();
			String   sido     = li[1].trim();
			String   gugun 	  = li[2].trim();
			String   dong     = li[3].trim();
			String   bunji    = li[4].trim();
			int      seq      = Integer.parseInt(li[5].trim());
			
			String  fmt = "[%s]  %s  %s  %s  %s  %d \n";
			
			// 1. 전국의 롯데백화점의 갯수 출력
			if ( dong.indexOf("현대백화점") > -1 ) {
		//  if ( dong.contains("롯데백화점") ) {
				String addr = String.format(fmt, zipcode,sido,gugun,dong,bunji,seq);
				System.out.print( addr );
				cnt++;
			}
		} // while end
		
		System.out.println( cnt + " 건 " );
		
		
		br.close();
		fr.close();
		
		
	} // main end

} // class end
