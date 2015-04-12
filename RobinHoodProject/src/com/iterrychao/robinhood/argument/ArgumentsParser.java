package com.iterrychao.robinhood.argument;

public class ArgumentsParser {
	public interface IAttributeConst {
		public String getKey();
		public String getDescription();
		public String getDefaultValue();
	}
	
	public boolean parseArguments(String[] args) {
		boolean ret = false;
		return ret;
	}
	
	public void printHelp() {
		
	}
}
