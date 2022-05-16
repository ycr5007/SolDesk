package lambda;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx07 {
	
	public static void useLambda(Stream<File> stream) {
		// 파일명을 모아서 확장자가 없는 파일명은 제외하고, 파일명 중복 제거 후 출력
		stream.map(File::getName)
			.filter(name -> name.indexOf(".") >= 0)
			.map(name -> name.substring(name.indexOf(".") + 1))
			.distinct()
			.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("사과", "딸기", "바나나", "수박", "참외", "메론", "바나나", "딸기");
		
		// 중간함수 :: distinct() > 중복 제거
		list.stream().distinct().forEach(s -> System.out.print(s + "\t"));
		
		System.out.println();
		System.out.println();
		
		Stream<File> stream = createStream();
		
		useLambda(stream);
	}
	
	public static Stream<File> createStream(){
		Stream<File> stream = Stream.of(new File("file1.txt"), new File("file2.txt"), new File("Ex1"), new File("Ex2.bak"), new File("test.java"));
		
		return stream;
	}
}
