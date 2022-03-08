package com.testingPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Test1 {

	// @Test
	public void regular() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("leo");
		names.add("ana");
		names.add("conor");
		names.add("armando");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {

			String actual = names.get(i);
			if (actual.startsWith("a")) {
				count++;

			}
		}
		System.out.println(count);
	}

	// @Test
	public void regularStream() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("leo");
		names.add("ana");
		names.add("conor");
		names.add("armando");

		Long c = names.stream().filter(s -> s.startsWith("a")).count();

		System.out.println(c);

	}

	//@Test
	public void moreStreams() {

		Stream.of("leo", "ana", "pepe", "maria").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}

	@Test
	public void streamscolletc() {
		List<String> ls = Stream.of("leo", "ana", "pepe", "maria").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(1,2,4,6,8,8,9,2);
		values.stream().distinct().forEach(System.out::println);		
 	}

}
