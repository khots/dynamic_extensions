package edu.common.dynamicextensions.query.ast;

import java.util.ArrayList;
import java.util.List;

public class ResultPostProcNode implements Node {
	private String name;
	
	private List<String> args = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}
}
