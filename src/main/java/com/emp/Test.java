package com.emp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		String s = "anusha kumari";
		findDuplicates(s);
	}
	

	public static void findDuplicates(String s) {
		//convert s to list
		List<String> list = Arrays.asList(s.split(""));
		//group the list and get the count
		Map<String, Long> mapObject = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		List<Object> ddd=mapObject.entrySet().stream().collect(Collectors.toList());
		System.out.println(ddd);
		List<Object> mn =mapObject.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toList());
		System.out.println(mn);
		          
	}

}
