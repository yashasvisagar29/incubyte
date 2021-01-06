package com.core.incubyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

	private static final String NUMBER_FORMAT_EXCEPTION_MSG = "Invalid input";

	private static final String NEGATIVE_NUMBER_EXCEPTION_MSG = "Negatives not allowed ";

	private static int count = 0;

	public int getCalledCount() {
		return count;
	}

	public int add(String numbers) throws NegationNumberCustomException {
		count++;
		int result = 0;
		StringBuilder delimiter = new StringBuilder();
		if (numbers.isEmpty()) {
			return result;
		} else {
			if (numbers.contains("//")) {
				if (numbers.contains("[") && numbers.contains("]")) {
					boolean delimiterFlag = false;
					int countOfDelimiter = 0;
					for (int i = 0; i < numbers.indexOf('\n'); i++) {
						if (numbers.charAt(i) == ']') {
							delimiterFlag = false;
						}
						if (delimiterFlag) {
							delimiter.append(numbers.charAt(i));
						}
						if (numbers.charAt(i) == '[') {
							delimiterFlag = true;
							countOfDelimiter++;
							if (countOfDelimiter > 1) {
								delimiter.append("|");
							}
						}
					}
					numbers = numbers.substring(numbers.indexOf('\n'));
				} else {
					delimiter.append(numbers.substring(2, 3));
					numbers = numbers.substring(numbers.indexOf('\n'));
				}
			} else {
				delimiter.append(",");
			}

			List<Character> specialCharacters = new ArrayList<>();

			populateSpecialCharacterListForDelimiter(specialCharacters);

			StringBuilder delimiterSb = new StringBuilder();
			for (int i = 0; i < delimiter.length(); i++) {
				Character delimiterCh = delimiter.charAt(i);
				if (specialCharacters.contains(delimiterCh)) {
					delimiterSb.append("\\" + delimiterCh);
				} else {
					delimiterSb.append(delimiterCh);
				}

			}

			String[] nums = numbers.split(delimiterSb.toString());

			for (String num : nums) {

				if (!num.contains("-")) {
					if (num.contains("\n")) {
						String[] newLineNums = num.split("\n");
						if (newLineNums.length > 0) {
							for (String newLineNum : newLineNums) {
								if (!newLineNum.isEmpty()) {
									int numI = Integer.parseInt(newLineNum.trim());
									if (numI < 1001) {
										result += numI;
									}
								}
							}
						} else {
							throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MSG);
						}
					} else {
						int numI = Integer.parseInt(num.trim());
						if (numI < 1001) {
							result += numI;
						}
					}
				} else {
					throw new NegationNumberCustomException(NEGATIVE_NUMBER_EXCEPTION_MSG
							+ Arrays.stream(nums).filter(s -> s.contains("-")).collect(Collectors.toList()));
				}
			}

			return result;
		}

	}

	private void populateSpecialCharacterListForDelimiter(List<Character> specialCharacters) {
		specialCharacters.add('*');
		specialCharacters.add('+');
		specialCharacters.add('^');
	}

}
