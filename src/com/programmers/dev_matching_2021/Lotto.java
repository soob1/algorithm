package com.programmers.dev_matching_2021;

import java.util.Arrays;

// 로또의 최고 순위와 최저 순위
public class Lotto {

	public void main(String[] args) {
		Solution solution = new Solution();

		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		solution.solution(lottos, win_nums);

		int[] lottos2 = {0, 0, 0, 0, 0, 0};
		int[] win_nums2 = {38, 19, 20, 40, 15, 25};
		solution.solution(lottos2, win_nums2);
	}

	class Solution {

		public int[] solution(int[] lottos, int[] win_nums) {

			int match_count = 0;
			int zero_count = 0;

			Arrays.sort(lottos);
			Arrays.sort(win_nums);

			for (int select_num : lottos) {
				for (int win_num : win_nums) {
					if (select_num == 0) {
						zero_count++;
						break;
					} else if (select_num == win_num) {
						match_count++;
						break;
					} else if (select_num < win_num) {
						break;
					}
				}
			}

			int min_rank = (match_count < 2) ? 6 : 7 - match_count;
			int max_rank = (zero_count + match_count < 2) ? 6 : 7 - (zero_count + match_count);
			int[] answer = {max_rank, min_rank};

			return answer;
		}
	}
}
