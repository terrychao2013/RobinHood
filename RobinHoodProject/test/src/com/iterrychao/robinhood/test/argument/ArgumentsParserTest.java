package com.iterrychao.robinhood.test.argument;

import com.iterrychao.robinhood.argument.ArgumentsParser;

import junit.framework.TestCase;

public class ArgumentsParserTest extends TestCase {
	private interface TestArguments {
		abstract String[] getArguments();
		abstract boolean expectedResult();
	}
	
	private void test(TestArguments arguments) {
		ArgumentsParser parser = new ArgumentsParser();
		boolean parserResult = parser.parseArguments(arguments.getArguments());
		assertEquals(arguments.expectedResult(), parserResult);
	}
	
	public void testParseCorrect() {
		test(new TestArguments() {

			@Override
			public String[] getArguments() {
				return new String[]{
						"parse", "--resource=~/", "--target=~/result.xls"
				};
			}

			@Override
			public boolean expectedResult() {
				return true;
			}});
	}
}
