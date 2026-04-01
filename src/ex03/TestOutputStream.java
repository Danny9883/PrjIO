package ex03;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestOutputStream {

	public static void main(String[] args) throws IOException {
		// ~Stream 으로 끝나는 클래스는 byte 단위 입출력
		String            fname  = "D:/dev/java/PrjIO/src/ex03/data2.dat";
		FileOutputStream  fos    = new FileOutputStream(fname);
		
		// for (int i = 65; i < 91; i++) {
		for (int i = 'A'; i <= 'Z' ; i++) {
			fos.write(i);
		}
		
		
		fos.close();
		
	}

}
