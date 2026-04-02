package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zipcode08 {

	public static void main(String[] args) throws IOException {
//		8. 각 시/도 별로 파일( .csv ) 출력

		
		String	      path     = Zipcode08.class.getResource("").getPath();
		String        fname    = "zipcode.csv";
		String        fname2  = "log.txt";
		File          infile   = new File( path + fname );
		File          outfile  = new File( "D:/dev/java/PrjIO/src/ex04/CityZipList/" + fname2 );
		if ( !infile.exists() ) {
			System.out.println(fname + "이 없습니다.");
			System.exit(-1);
		}
		
		FileReader     fr   = new FileReader(infile);
		BufferedReader br   = new BufferedReader(fr);
		
		FileWriter     fw     = new FileWriter(outfile);
		BufferedWriter bw     = new BufferedWriter(fw);

		
		
		br.readLine();       // 제목 skip
		String  line     = "";
		int     totcnt   = 0;
		String  prevSido = "";

		long   startTime = System.nanoTime();
		String   title   = "우편번호  시/도  구/군      동        번지           SEQ\n";

		
		int    cnt       = 0;
		while ( (line=br.readLine()) != null ) {
			PostVo    vo   = new PostVo( line );
			String  sido   = vo.getSido(); 
			String  fmt    = "[%s]  %s  %s  %s  %s  %d\n";
			String  msg    = String.format(fmt, vo.getZipcode(),vo.getSido(),vo.getGugun(),vo.getDong(),vo.getBunji(),vo.getSeq());
			if ( !sido.equals(prevSido) ) {
				bw.close();
				fw.close();
				cnt++;
				prevSido  = sido;
				fname2    = cnt + ". " + sido + " 우편번호 List.csv";
				outfile   = new File("D:/dev/java/PrjIO/src/ex04/CityZipList/" + fname2);
				fw        = new FileWriter(outfile);
				bw        = new BufferedWriter(fw);
				bw.write(title);
				bw.write(msg);
			} else {
				bw.write(msg);
			}
			totcnt++;
		} 
		bw.close();
		fw.close();
		
		
		long   endTime  = System.nanoTime();
		double execTime = (endTime - startTime)/1000000000.0;
		
		fname2  = "log.txt";
		outfile = new File("D:/dev/java/PrjIO/src/ex04/CityZipList/" + fname2);
		fw      = new FileWriter(outfile);
		bw      = new BufferedWriter(fw);
		
		String sidocount = String.format("총 시/도 수 : %d\n" , cnt );
		String tot       = String.format("전체 자료 수 : %d\n" , totcnt );
		String time      = String.format("%d 개 파일 생성 소요 시간 : %.4f 초 \n" , cnt,execTime );
		
		bw.write("전국 우편번호 모음 파일 생성 현황 \n\n");
		bw.write(sidocount);
		bw.write(tot);
		bw.write(time);
		
		

		bw.close();
		br.close();
		
		fw.close();
		fr.close();
		

		System.out.println(cnt+" 개 파일 생성 완료 \n");
		System.out.print(sidocount);
		System.out.print(tot);
		System.out.print(time);
	}

}
