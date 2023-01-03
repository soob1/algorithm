package com.programmers.practice;

// 마법의 엘리베이터
// https://school.programmers.co.kr/learn/courses/30/lessons/148653
public class Test148653 {

	public int solution(int storey) {
		System.out.println("storey = " + storey);
		int answer = 0;

		// storey 자릿수
		int log10 = (int) Math.log10(storey);

		for (int i = 0; i <= log10; i++) {
			// 나머지
			int num = storey % 10;

			boolean addFlag = false;
			if (num == 5) {
				addFlag = storey % 100 / 10 >= 5;
			}

			// 현재 자릿수보다 상위 자릿수 고려
			if (num > 5 || addFlag) {
				int magicRockCount = 10 - num;
				answer += magicRockCount;
				storey += magicRockCount;
			} else {
				int magicRockCount = num;
				answer += magicRockCount;
				storey -= magicRockCount;
			}

			// 자릿수가 늘어난 경우
			if ( (int) Math.log10(storey) + i > log10) {
				answer += 1;
				break;
			}

			storey /= 10;
		}

		return answer;
	}
}
