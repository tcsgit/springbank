package com.springbank.ui.bean;

import com.springbank.entity.Operator;

public class LoginBean {
	private Operator operator = new Operator();

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

}
