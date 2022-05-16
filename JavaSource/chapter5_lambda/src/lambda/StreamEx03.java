package lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
	Stream 중간 연산
		1 . map(), filter(), skip(), limit() ...
		
	Stream 최종 연산
		1 . forEach(), count(), sum(), reduce() ...
		
	map() 	: 스트림의 요소에 저장된 값 중에서 원하는 필드만 추출하거나 , 특정 형태로 변환 시 사용
	
*/

public class StreamEx03 {
	public static void main(String[] args) {
		// ──────────────────────────────────── 기 존 ────────────────────────────────────
		List<File> fileList = new ArrayList<File>();
		fileList.add(new File("file1.txt"));
		fileList.add(new File("file2.txt"));
		fileList.add(new File("file3.txt"));
		fileList.add(new File("file4.txt"));
		
		List<String> fileNames = new ArrayList<String>();
		
		// 파일명 추출
		for(File file : fileList) {
			System.out.println(file.getName());
			// 파일명 수집
			fileNames.add(file.getName());
		}
		
		// ──────────────────────────────────── 람 다 ────────────────────────────────────
		// Stream 생성
		Stream<File> stream = Stream.of(new File("file1.txt"), new File("file2.txt"), new File("file3.txt"), new File("file4.txt"));
		
		// 		중간연산				최종연산
		stream.map(File::getName).forEach(f -> System.out.println(f));
			// (File::getName) >> ClassName::MethodName
	}
}
