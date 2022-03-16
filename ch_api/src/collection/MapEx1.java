package api;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
	Map
		- key-value 구조로 저장
		- key 값은 중복 안됨, value 만 중복 가능
*/
public class MapEx1 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		// 요소 추가
		map.put("id_0123", "james");
		map.put("id_0124", "john");
		map.put("id_0125", "lake");
		map.put("id_0126", "park");
		
		System.out.println(map);
		System.out.println();
		System.out.println("키에 해당하는 값 가져오기 : " + map.get("id_0123"));
		System.out.println("키가 존재하는지 확인하기 : " + map.containsKey("id_0123"));
		System.out.println("키가 존재하는지 확인하기 : " + map.containsValue("park"));
		System.out.println("맵이 비어있는지 확인하기 : " + map.isEmpty());
		System.out.println("맵의 크기 : " + map.size());
		System.out.println("맵의 요소 삭제 : " + map.remove("id_0125"));
		System.out.println(map);
		
		// 키 값만 가져오기
		Set<String> keys = map.keySet();
		System.out.println(keys);
		
		// value 값만 가져오기
		Collection<String> values = map.values();
		System.out.println(values);
		
		System.out.println();
		
		// Iterator 를 활용하여 value 값 추출
		Iterator<String> keyIter = keys.iterator();
		
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			String value = map.get(key);
			
			System.out.println(key + " ∥ " + value);
		}
		
	}
}
