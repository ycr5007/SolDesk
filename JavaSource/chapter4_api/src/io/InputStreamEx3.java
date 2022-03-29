package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamEx3 {
	public static void main(String[] args) {
		try (InputStream in = System.in; OutputStream out = System.out){
			int input = in.read();
			out.write(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
