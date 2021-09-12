package com.programmers.weekly_challenge;

import java.util.*;

public class Week4 {

	public String solution(String[] table, String[] languages, int[] preference) {
		Map<String, Integer> scores = new HashMap<>();

		for (String data : table) {
			int score = 0;
			String[] arr = data.split(" ");
			String[] copyArr = Arrays.copyOfRange(arr, 1, arr.length);

			List<String> languagesOrderByScore = Arrays.asList(copyArr);
			Collections.reverse(languagesOrderByScore);

			for (int i = 0; i < languages.length; i++) {
				if (languagesOrderByScore.contains(languages[i])) {
					score += (languagesOrderByScore.indexOf(languages[i]) + 1) * preference[i];
				}
			}

			scores.put(arr[0], score);
		}

		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scores.entrySet());
		entryList.sort(((o1, o2) -> {
			int comparision = (o1.getValue() - o2.getValue()) * -1;
			return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
		}));

		return entryList.get(0).getKey();
	}

}
