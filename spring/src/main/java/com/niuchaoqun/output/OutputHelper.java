package com.niuchaoqun.output;

import com.niuchaoqun.output.IOutputGenerator;

public class OutputHelper {
	IOutputGenerator outputGenerator;

	public void generateOutput() {
		outputGenerator.generateOutput();
	}

	// 通过 Bean 注入方法
	public void setOutputGenerator(IOutputGenerator outputGenerator) {
		this.outputGenerator = outputGenerator;
	}
}