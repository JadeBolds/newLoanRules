package com.example.loanRules;

import com.example.loanRules.rules.AgeRule;
import com.example.loanRules.rules.OfferApproved;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LoanRulesApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Name: ");
		String name = scanner.next();
		System.out.println("Welcome, " + name);

		System.out.println("Age: ");
		Integer age = scanner.nextInt();
//
//		Facts fact = new Facts();
//		fact.put("age", age);
//
//		AgeRule ageRule = new AgeRule();
//		Rules rules = new Rules();
//		rules.register(ageRule);
//
//		RulesEngine rulesEngine = new DefaultRulesEngine();
//		rulesEngine.fire(rules, fact);

		System.out.println("Requested loan amount: ");
		Integer loanAmount = scanner.nextInt();

		System.out.println("Credit Score: ");
		Integer credit = scanner.nextInt();

		System.out.println("Annual Income: ");
		Integer annualIncome = scanner.nextInt();

		System.out.println("Monthly Expenses: ");
		Integer expenses = scanner.nextInt();

		Facts facts = new Facts();
		//facts.put("name", name);
		facts.put("age", age);
		facts.put("creditScore", credit);
		facts.put("annualIncome", annualIncome);
		facts.put("monthlyExpenses", expenses);

		AgeRule ageRule = new AgeRule();
		Rules rules = new Rules();
		rules.register(ageRule);

		OfferApproved offerApproved = new OfferApproved();
		Rules rules0 = new Rules();
		rules0.register(offerApproved);

		RulesEngine rulesEngine = new DefaultRulesEngine();
		rulesEngine.fire(rules0, facts);
		rulesEngine.fire(rules, facts);

		SpringApplication.run(LoanRulesApplication.class, args);

	}

}
