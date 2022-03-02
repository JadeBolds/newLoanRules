package com.example.loanRules.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "OfferDenied" , description = "Offer Denied")
public class OfferDenied {

    //if credit score is good approve offer
    @Condition
    public boolean offerIsDenied(@Fact("creditScore") int creditScore,
                                   @Fact("annualIncome") int annualIncome,
                                   @Fact("monthlyExpenses") int monthlyExpenses) {
        return creditScore < 650 && annualIncome < 26000 && monthlyExpenses > (annualIncome/12) * 0.7;
    }

    @Action
    public void then(@Fact("creditScore") int creditScore,
                     @Fact("annualIncome") int annualIncome,
                     @Fact("monthlyExpenses") int monthlyExpenses) {

        double expenseRatio = monthlyExpenses / (annualIncome / 12);

        System.out.println("Offer Denied for: Amount Requested " + '\n');
    }
}
