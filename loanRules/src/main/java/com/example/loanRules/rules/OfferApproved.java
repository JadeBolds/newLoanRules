package com.example.loanRules.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "OfferApproved" , description = "Offer Approved")
public class OfferApproved {

    //if credit score is good approve offer
    @Condition
    public boolean when(@Fact("creditScore") int creditScore,
                                                @Fact("annualIncome") int annualIncome,
                                                @Fact("monthlyExpenses") int monthlyExpenses) {
        return creditScore > 649 && annualIncome > 25999 && monthlyExpenses < (annualIncome/12) * 0.7;
    }

    @Action
    public void then(@Fact("creditScore") int creditScore,
                     @Fact("annualIncome") int annualIncome,
                     @Fact("monthlyExpenses") int monthlyExpenses) {

        double expenseRatio = monthlyExpenses / (annualIncome / 12);

        System.out.println("Offer Approved for: Amount Requested " + '\n' +
                "Credit score: " + creditScore + '\n' +
                "Income: " + annualIncome + '\n' +
                "Expense Ratio: " + expenseRatio );
    }
}
