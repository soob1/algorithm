package com.programmers.weekly_challenge;

import java.util.ArrayList;
import java.util.Collections;

public class Week2 {

	public String solution(int[][] scores) {
		String answer = "";

		int studentCount = scores.length;

		for (int i = 0; i < studentCount; i++) {
			int selfScore = scores[i][i];
			int totalScore = 0;
			boolean exceptSelfScore = false;
			ArrayList<Integer> scoreList = new ArrayList<>();

			for (int j = 0; j < studentCount; j++) {
				totalScore += scores[j][i];
				scoreList.add(scores[j][i]);
			}

			// + max, min 미리 선언해두고 위의 for문 내에서 Math.max(a, b)로 최댓값 구하는 방법
			if (Collections.frequency(scoreList, selfScore) == 1) {
				int maxScore = Collections.max(scoreList);
				int minScore = Collections.min(scoreList);

				if (selfScore == maxScore || selfScore == minScore) {
					exceptSelfScore = true;
				}
			}

			if (exceptSelfScore) {
				answer += getGrade((totalScore - selfScore) / (studentCount - 1));
			} else {
				answer += getGrade(totalScore / studentCount);
			}
		}

		return answer;
	}

	private String getGrade(int score) {
		String grade = "";

		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 50) {
			grade = "D";
		} else {
			grade = "F";
		}

		return grade;
	}
}
