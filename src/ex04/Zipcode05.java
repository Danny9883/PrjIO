package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

public class Zipcode05 {

	public static void main(String[] args) throws IOException {
//		4. 한국의 시도명 출력 - 17건 
//		   서울
//		   부산
//		   ... 
//		   충북
		
		String	      path     = Zipcode05.class.getResource("").getPath();
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

		long   startTime = System.nanoTime(); 
		
		HashSet<String>   set   = new HashSet<>();    // 무순 정렬
		
//		TreeSet<String>   set   = new TreeSet<>();    // 오름차순
		
		while ( (line=br.readLine()) != null ) {
			PostVo    vo  = new PostVo( line );
			String  sido  = vo.getSido(); 
			set.add(sido);
//			System.out.println(vo);
			totcnt++;
		}
		
		long   endTime  = System.nanoTime();
		double execTime = (endTime - startTime)/1000000000.0;
		System.out.println("전체 자료수 : " + totcnt );
		System.out.printf("소요 시간 : %.4f 초\n", execTime);
		
		for (String sido : set) {
			System.out.println(sido);
		}
		System.out.println(set.size() + "건");
		
		br.close();
		fr.close();
		
	}

}
