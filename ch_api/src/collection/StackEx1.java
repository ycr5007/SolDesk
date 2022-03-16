package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
	Stack (Last In First Out)
		마지막에 저장한 데이터를 가장 먼저 꺼냄
		push() : 삽입, pop() : 인출

					│	│					│	│					│	│					│	│
	push("+") >		│	│	push("-") >		│	│	push("*") >		│*	│					│	│
					│	│					│-	│					│-	│	pop("*") >		│-	│
					│+	│					│+	│					│+	│					│+	│
					└───┘					└───┘					└───┘					└───┘
	
	Queue (First In First Out)
		가장 먼저 저장한 데이터를 가장 먼저 꺼냄
		offer() : 삽입, poll() : 인출
			────────┬───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬───────
					│				│				│				│				│				│
					│				│				│				│				│				│
		offer >		│				│				│				│				│				│	poll >
					│				│				│				│				│				│
					│				│				│				│				│				│
			────────┴───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴───────
	
	
*/

public class StackEx1 {
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		Queue<String> queue = new LinkedList<String>();
		
		// Stack push
		stack.push("0");
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		
		// Stack pop
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println();
		
		// Queue offer
		queue.offer("10");
		queue.offer("9");
		queue.offer("8");
		queue.offer("7");
		queue.offer("6");
		
		// Queue poll
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}
}
