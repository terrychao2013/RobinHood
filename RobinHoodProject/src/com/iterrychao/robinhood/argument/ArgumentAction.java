package com.iterrychao.robinhood.argument;

public enum ArgumentAction {
	PARSE(Argument.parse.class),
	;
	private Argument[] mArguments;
	
	private ArgumentAction(Class<? extends Argument> argumentClazz) {
		mArguments = argumentClazz.getEnumConstants();
	}
	
	public Argument[] getArguments() {
		return mArguments;
	}
	
	public interface Argument {
		public enum parse implements Argument {
			resource {

				@Override
				public String getDescription() {
					return "the resource file path, it's the path of res, like .../TouchPal/res";
				}

				@Override
				public String getDefaultValue() {
					return "~/";
				}
				
			},
			
			target {

				@Override
				public String getDescription() {
					return "the target file, end with .xls";
				}

				@Override
				public String getDefaultValue() {
					return "~/result.xls";
				}
				
			},
			
		};
		
		public String getDescription();
		public String getDefaultValue();

	};
}
