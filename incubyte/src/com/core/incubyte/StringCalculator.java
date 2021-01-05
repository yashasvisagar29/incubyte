package com.core.incubyte;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {

	private static final String NUMBER_FORMAT_EXCEPTION_MSG = "Invalid input";

	private static final String NEGATIVE_NUMBER_EXCEPTION_MSG = "Negatives not allowed ";

	public int add(String numbers) throws NegationNumberCustomException {

		int result = 0;
		Character delimiter = ',';

		if (numbers.isEmpty()) {
			return result;
		} else {
			if (numbers.contains("//")) {
				delimiter = numbers.charAt(2);
				numbers = numbers.substring(3, numbers.length());
			}
			String[] nums = numbers.split(delimiter.toString());

			for (String num : nums) {

				if (!num.contains("-")) {
					if (num.contains("\n")) {
						String[] newLineNums = num.split("\n");
						if (newLineNums.length > 0) {
							for (String newLineNum : newLineNums) {
								if (!newLineNum.isEmpty()) {
									result += Integer.parseInt(newLineNum.trim());
								}
							}
						} else {
							throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MSG);
						}
					} else {
						result += Integer.parseInt(num.trim());
					}
				} else {
					throw new NegationNumberCustomException(NEGATIVE_NUMBER_EXCEPTION_MSG
							+ Arrays.stream(nums).filter(s -> s.contains("-")).collect(Collectors.toList()));
				}
			}

			return result;
		}

	}

}
