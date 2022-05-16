package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamEx02 {
	public static void main(String[] args) {
		// 디렉토리 지정
		Path path = Paths.get("d:\\test\\2022\05\10");
		
		// Stream 객체로 변환
		Stream<Path> files;
		try {
			files = Files.list(path);
			files.forEach(file -> System.out.println(file.getFileName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
