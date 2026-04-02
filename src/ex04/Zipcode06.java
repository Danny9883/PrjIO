package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode06 {

	public static void main(String[] args) throws IOException {
//		4. 한국의 시도명 출력 - 17건 
//		   서울
//		   부산
//		   ... 
//		   충북
		
		String	      path     = Zipcode06.class.getResource("").getPath();
		String        fname    = "zipcode.csv";
		File          infile   = new File( path + fname );
		if ( !infile.exists() ) {
			System.out.println(fname + "이 없습니다.");
			System.exit(-1);
		}
		
		FileReader     fr   = new FileReader(infile);
		BufferedReader br   = new BufferedReader(fr);
		
		br.readLine();       // 제목 skip
		String  line     = "";
		int     totcnt   = 0;
		String  find     = "부전2동";

		long   startTime = System.nanoTime(); 
		
		int    cnt       = 0;
		while ( (line=br.readLine()) != null ) {
			PostVo    vo  = new PostVo( line );
			String  dong  = vo.getDong();
			String  fmt    = "[%s]  %s  %s  %s  %s  %d\n";
			String  msg    = String.format(fmt, vo.getZipcode(),vo.getSido(),vo.getGugun(),vo.getDong(),vo.getBunji(),vo.getSeq());
			if ( dong.contains(find) ) {
				cnt++;
				System.out.printf(msg);
			} 
			totcnt++;
		} 
		
		
		long   endTime  = System.nanoTime();
		double execTime = (endTime - startTime)/1000000000.0;
		
		
		br.close();
		fr.close();
		

		
		System.out.println("자료 수 : " + cnt );
		System.out.println("전체 자료수 : " + totcnt );
		System.out.printf("소요 시간 : %.4f 초\n", execTime);
	}

}
