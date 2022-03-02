package com.example.loanRules.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "AgeRule", description = "Deny if age is less than 18")
public class AgeRule {

    @Condition
    public boolean when(@Fact("age") int age) {
        return age < 18;
    }

    @Action
    public void then(@Fact("age") int age) {
        System.out.println("You are " + age + " years old. You are not old enough to apply for a loan.");
    }
}
