package com.rest.webservices.socialmediademo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Gen {

	public static void main(String[] args) {

//		List<User> users = List.of( new User(1,"ketty",LocalDate.of(1996,2,5)),
//				new User(2,"dan",LocalDate.of(1994,4,6)));
//		
//		Predicate<User> selector = u -> u.getName().equals("ketty");
//		List<User> kettys = filter(users, selector);
//		
//		kettys.forEach(System.out::println);
		
		
		//Question 1
		int[] nums = new int[] {1,2,6,3,3,4,6,2};
		int firstNoneUniqueIndex = noneUniqueIndex(nums);
		System.out.println("first none unique index: " + firstNoneUniqueIndex);
		
		
		//Question 2
		String s = "abcda";
		String t = "abda";
		String c = "ad";
		
		System.out.println("Question 2 : " +  presentInTSandNotW(t,s,c));
		
		//Question 3
		long[] numsFreq = new long[] {3,3,3,1,1,1,2,2,4};
		List<Long> secondMostFreq = frequentKnumber(numsFreq,2);
		System.out.println("second most frequent: " );
		secondMostFreq.forEach(System.out::println);
		
		//Question 4
		int[] q4 = {8,3,9,7,4,5,42,2,12,10,6,24};
		int[] pair = unsortedArrayOfTwoElements(q4,21);
		System.out.println("Question 4 : " + Arrays.toString(pair));
		
		//Question 5
		
		
		for(int i = 0; i < 10; ++i) {
			int[] q5 = {1,2,3,4,5,6,7,8};
			rotateArray(q5, i);
			System.out.println("Question 5 : " + Arrays.toString(q5));
		}
		
		//Question 6
		
		int[] q6 = {7,8,9,1,2,3,4,5};
		int rotationPoint = detectRotationPoint(q6);
		System.out.println("Question 6 : " + rotationPoint);
	}
	
	public static int[] unsortedArrayOfTwoElements(int[] nums, int target){
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(target - nums[i]))
				return new int[] {i, map.get(target - nums[i])};
			map.put(nums[i], i);
		}
		
		return null;	
	}
	
	public static void rotateArray(int[] v, int rot) {
		
		int i = 0;
		int next,nextIndex;
		int current = v[0];
		
		do {
			nextIndex = (i+rot)%v.length;
			next = v[nextIndex];
			v[nextIndex] = current;
			current = next;
			i = nextIndex;
		}while(i!=0);
	}
	
	public static int detectRotationPoint(int[] v) {
		
		int i = 0;
		
		while(v[i]<v[i+1]) {
			i++;
		}
		
		return i+1;	
		

	}
	
	public static int noneUniqueIndex(int[] arr) {
		
		for(int i=0; i<arr.length; i++)
			for(int j=i+1; j<arr.length; j++)
				if(arr[i] == arr[j])
					return i;
		
		return -1;
	}
	
	
	public static long presentInTSandNotW(String t, String s, String w) {
		
		
		Set<Integer> tSet = new HashSet<Integer>();
		Set<Integer> sSet = new HashSet<Integer>();
		Set<Integer> wSet = new HashSet<Integer>();
		
		t.chars().forEach(c -> tSet.add(c));
		s.chars().forEach(c -> sSet.add(c));
		w.chars().forEach(c -> wSet.add(c));
		
		return  tSet.stream().filter(tChar -> sSet.contains(tChar) && !wSet.contains(tChar)).count();
		
	}
	
	public static List<Long> frequentKnumber(long[] nums, int k) {
		
		Map<Long,Integer> numbers = new HashMap<Long,Integer>();
		
		for(int i=0; i<nums.length; i++) 
			numbers.put(nums[i], numbers.getOrDefault(nums[i], 0) + 1);
		
		List<List<Long>> freq = new ArrayList<List<Long>>();
		for(int i=0; i<nums.length; i++) 
			freq.add(new ArrayList<Long>());
		
		for (Map.Entry<Long, Integer> x : numbers.entrySet())
            freq.get(x.getValue()-1).add(x.getKey());
		
		int count = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
            if(!freq.get(i).isEmpty())
            	count++;
            
            if(count == k)
				return freq.get(i);
        }
		return null;
	}
	

	public static <T> List<T> filter(List<T> objects, Predicate<T> selector) {
		final var bySelector = new ArrayList<T>();
		objects.forEach(object -> {
			if (selector.test(object))
				bySelector.add(object);
		});

		return bySelector;
	}
	
	
}
