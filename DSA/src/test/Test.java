package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import basics.arrays.Arrays1;
import basics.arrays.StreamsTest;
import basics.arrays.StreamsTest.Employee;
import basics.prep.InterviewPrepBasics;
import basics.stacks.Stacks;

public class Test {

	public static void main(String[] args) {
		Map<String, String> routes = new HashMap<>();
		routes.put("Mumbai", "Delhi");
		routes.put("Bangalore", "Chennai");
		routes.put("Delhi", "Bangalore");
		routes.put("Chennai", "Kolkata");
		
		
		
		StringBuilder destination =  new StringBuilder();
		for (String departure : routes.values()) {
			if(!routes.containsKey(departure)) {
				destination.append(departure);
			}
		}
		StringBuilder origin1 = new StringBuilder();
		for (String origin : routes.keySet()) {
			if(!routes.containsValue(origin)) {
				origin1.append(origin);
			}
		}
		
		System.out.println(destination.toString()+origin1.toString());
	}

}
