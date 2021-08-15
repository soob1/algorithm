package com.programmers.weekly_challenge;

public class Week1 {

	public long solution(int price, int money, int count) {
		long answer = 0;
		long totalPrice = 0;

		for (int i = 1; i <= count; i++) {
			totalPrice += (price * i);
		}

		if (money < totalPrice) {
			answer = totalPrice - money;
		}

		return answer;
	}

}
