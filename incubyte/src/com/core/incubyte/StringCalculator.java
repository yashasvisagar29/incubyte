package com.core.incubyte;

public class StringCalculator {

	private static final String NUMBER_FORMAT_EXCEPTION_MSG = "Invalid input";

	public int add(String numbers) {

		int result = 0;
		Character delimiter = ',';

		if (numbers.isEmpty()) {
			return result;
		} else {
			try {
				if (numbers.contains("//")) {
					delimiter = numbers.charAt(2);
					numbers = numbers.substring(3, numbers.length());
				}
				String[] nums = numbers.split(delimiter.toString());

				for (String num : nums) {

					if (num.contains("\n")) {
						String[] newLineNums = num.split("\n");
						if (newLineNums.length > 0) {
							for (String newLineNum : newLineNums) {
								if (!newLineNum.isEmpty()) {
									result += Integer.parseInt(newLineNum);
								}
							}
						} else {
							throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MSG);
						}
					} else {
						result += Integer.parseInt(num);
					}
				}

			} catch (NumberFormatException e) {
				throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MSG);
			}
			return result;
		}

	}

}
