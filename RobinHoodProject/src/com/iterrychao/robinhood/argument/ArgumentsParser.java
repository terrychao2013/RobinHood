package com.iterrychao.robinhood.argument;

import java.util.HashSet;

import com.iterrychao.robinhood.argument.ArgumentAction.Argument;

public class ArgumentsParser {
	private static final String ARGUMENT_PREFIX = "--";
	private static final String KEY_VALUE_SEPARATOR = "=";
	private ActionItem mActionItem = null;
	
	public boolean parseArguments(String[] args) {
		boolean ret = false;
		if (args != null && args.length > 1) {
			ArgumentAction action = null;
			for (ArgumentAction argumentAction : ArgumentAction.values()) {
				if (args[0].equalsIgnoreCase(argumentAction.toString())) {
					action = argumentAction;
					break;
				}
			}
			if (action != null) {
				Argument[] arguments = action.getArguments();
				HashSet<String> availableKeys = new HashSet<String>();
				for (Argument argument : arguments) {
					availableKeys.add(argument.toString());
				}
				mActionItem = new ActionItem(action);
				for (int i = 1; i < args.length; i++) {
					String argString = args[i];
					if (argString != null && argString.startsWith(ARGUMENT_PREFIX)) {
						boolean added = addArgs(mActionItem, availableKeys, argString);
						if (added && i == args.length - 1) {
							ret = true;
						}
					} else {
						break;
					}
				}
			}
		}
		return ret;
	}
	
	private boolean addArgs(ActionItem item, HashSet<String> availableKeys,
			String argString) {
		boolean ret = false;
		if (argString != null) {
			String keyValueStr = argString.replace(ARGUMENT_PREFIX, "");
			String[] keyValue = keyValueStr.split(KEY_VALUE_SEPARATOR);
			if (keyValue != null && keyValue.length == 2) {
				String key = keyValue[0];
				String value = keyValue[1];
				if (availableKeys.contains(key)) {
					item.addAttribute(key, value);
					ret = true;
				}
			}
		}
		return ret;
	}
	
	public void printHelp() {
		
	}
}
