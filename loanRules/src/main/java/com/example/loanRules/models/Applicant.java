package com.example.loanRules.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Applicant {
    private String name;
    private int amountRequested;
    private int age;
    private int creditScore;
    private int annualIncome;
    private int monthlyIncome = annualIncome / 12;
    private int monthlyExpenses;
    private int loanAmount;

    private Applicant applicant;
}
