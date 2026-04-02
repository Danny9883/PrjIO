package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode07 {

	public static void main(String[] args) throws IOException {
//		7. 부산 부산진구 우편번호를 파일( .csv )로 출력

		
		String	      path     = Zipcode07.class.getResource("").getPath();
		String        fname    = "zipcode.csv";
		File          infile   = new File( path + fname );
		File          outfile  = new File( "D:/dev/java/PrjIO/src/ex04/" + "busanjingu.csv" );
		if ( !infile.exists() ) {
			System.out.println(fname + "이 없습니다.");
			System.exit(-1);
		}
		
		FileReader     fr   = new FileReader(infile);
		BufferedReader br   = new BufferedReader(fr);
		
		FileWriter     fw   = new FileWriter(outfile);
		BufferedWriter bw   = new BufferedWriter(fw);
		
		
		br.readLine();       // 제목 skip
		String  line     = "";
		int     totcnt   = 0;
		String  find     = "부산진구";

		long   startTime = System.nanoTime();
		String   title   = "우편번호  시/도  구/군      동        번지           SEQ\n";
		bw.write(title);
		
		int    cnt       = 0;
		while ( (line=br.readLine()) != null ) {
			PostVo    vo  = new PostVo( line );
			String  fmt    = "[%s]  %s  %s  %s  %s  %d\n";
			String  msg    = String.format(fmt, vo.getZipcode(),vo.getSido(),vo.getGugun(),vo.getDong(),vo.getBunji(),vo.getSeq());
			String  gugun  = vo.getGugun(); 
			if ( gugun.equals(find) ) {
				bw.write(msg);
				cnt++;
			} 
			totcnt++;
		} 
		
		
		long   endTime  = System.nanoTime();
		double execTime = (endTime - startTime)/1000000000.0;
		
		
		bw.close();
		br.close();
		
		fw.close();
		fr.close();
		

		
		System.out.println("자료 수 : " + cnt );
		System.out.println("전체 자료수 : " + totcnt );
		System.out.printf("소요 시간 : %.4f 초\n", execTime);
	}

}
