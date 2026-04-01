package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileScore {

	public static void main(String[] args) throws IOException {
		
		// 입력 파일
		String          path      = "D:/dev/java/PrjIO/src/ex02/";
		String          filename  = "data.txt";
		FileReader      fr        = new FileReader(path + filename);
		BufferedReader  br        = new BufferedReader(fr);
		
		// 출력 파일
		String          filename2 = "result.txt";
		FileWriter      fw        = new FileWriter(path + filename2 , false);
		// append : false or 생략  -> 생성되는 파일이 Overwrite 된다  -> 덮어쓰기
		//          기존 파일이 존재하면 덮어쓰고 없으면 만든다
		// append : true           -> 생성되는 파일에 Append 된다  ->  내용 추가
		BufferedWriter  bw        = new BufferedWriter(fw);
		
		
		
		String          line  = "";
		br.readLine();       // 제목줄 skip
		
		String title     = "번호  이름  국어  영어  수학   총점  평균 \n";
		System.out.print(title);
		bw.write( title );
		
		while ( (line=br.readLine()) != null ) {
			String [] li = line.trim().split(",");
			int    num   = Integer.parseInt(li[0].trim());
			String name  = li[1].trim();
			int    kor   = Integer.parseInt(li[2].trim());
			int    eng   = Integer.parseInt(li[3].trim());
			int    mat   = Integer.parseInt(li[4].trim());
			int    tot   = kor + eng + mat;
			double avg   = tot / 3.0;          // 소수이하 두자리로 반올림 : %.2f
			
			String fmt       = " %d   %4s    %3d   %3d    %3d   %3d   %.2f \n";
			String msg       = String.format(fmt , num , name, kor , eng , mat , tot ,avg);
			System.out.print(msg);
			bw.write( msg );
		}
		
		
		
		
		bw.close();
		br.close();
		
		fr.close();
		fw.close();
		
	}

}
