package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerEx {
	public static void main(String[] args) {
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer("조규현", 40, 100));
		customerList.add(new Customer("조발라더", 20, 100));
		customerList.add(new Customer("조정뱅이", 13, 50));
		customerList.add(new Customer("조삐에로", 18, 70));
		
		// 고객 명단 출력
		customerList.stream().map(Customer::getName).forEach(name -> System.out.println(name + "\t"));
		
		// 총 여행 경비 계산
		int sum = customerList.stream().mapToInt(Customer::getPrice).sum();
		System.out.println(sum);
		
		// 고객중 20 세 이상인 사람의 이름을 정렬하여 출력
		customerList.stream().filter(customer -> customer.getAge() >= 20).map(Customer::getName).sorted(Comparator.reverseOrder()).forEach(name -> System.out.println(name + "\t"));
		
		
		
	}
}
