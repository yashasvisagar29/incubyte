package com.core.incubyte;

public class StringCalculator {

	private static final String NUMBER_FORMAT_EXCEPTION_MSG = "Invalid input";

	public int add(String numbers) {

		int result = 0;
		String delimiter = ",";

		if (numbers.isEmpty()) {
			return result;
		} else {
			try {
				String[] nums = numbers.split(delimiter);

				for (String num : nums) {

					if (num.contains("\n")) {
						String[] newLineNums = num.split("\n");
						if (newLineNums.length > 0) {
							for (String newLineNum : newLineNums) {
								result += Integer.parseInt(newLineNum);
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
