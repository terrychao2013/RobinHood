package com.iterrychao.robinhood;

import com.iterrychao.robinhood.argument.ArgumentsParser;

public class Main {
	public static void main(String[] args) {
		ArgumentsParser parser = new ArgumentsParser();
		if (!parser.parseArguments(args)) {
			parser.printHelp();
		}
	}

}
