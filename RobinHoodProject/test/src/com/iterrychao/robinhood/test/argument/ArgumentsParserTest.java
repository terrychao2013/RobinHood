package com.iterrychao.robinhood.test.argument;

import com.iterrychao.robinhood.argument.ArgumentsParser;

import junit.framework.TestCase;

public class ArgumentsParserTest extends TestCase {
	private enum TestArguments {
		NULL {

			@Override
			String[] getArguments() {
				return null;
			}
			
		},
		;
		abstract String[] getArguments();
	};
	
	public void testParserArguments() {
		for (TestArguments test : TestArguments.values()) {
			ArgumentsParser parser = new ArgumentsParser();
			boolean parserResult = parser.parseArguments(test.getArguments());
			assertFalse(parserResult);
		}
	}
}
