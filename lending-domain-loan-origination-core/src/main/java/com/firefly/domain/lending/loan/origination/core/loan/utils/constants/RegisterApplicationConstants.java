package com.firefly.domain.lending.loan.origination.core.loan.utils.constants;

public class RegisterApplicationConstants {

    // ============================== SAGA CONFIGURATION ==============================
    public static final String SAGA_REGISTER_APPLICATION = "RegisterApplicationSaga";

    // ============================== STEP IDENTIFIERS ==============================
    public static final String STEP_REGISTER_APPLICATION_PARTY = "registerApplicationParty";
    public static final String STEP_REGISTER_APPLICATION_DOCUMENT = "registerApplicationDocument";
    public static final String STEP_REGISTER_APPLICATION_COLLATERAL = "registerCollaterals";
    public static final String STEP_REGISTER_LOAN_APPLICATION = "registerLoanApplication";


    // ============================== COMPENSATE METHODS ==============================
    public static final String COMPENSATE_REMOVE_LOAN_APPLICATION = "removeLoanApplication";
    public static final String COMPENSATE_REMOVE_APPLICATION_PARTY = "removeApplicationParty";
    public static final String COMPENSATE_REMOVE_APPLICATION_DOCUMENT = "removeApplicationDocument";
    public static final String COMPENSATE_REMOVE_APPLICATION_COLLATERAL = "removeApplicationCollateral";

    // ============================== EVENT TYPES ==============================
    public static final String EVENT_LOAN_APPLICATION_REGISTERED = "loanApplication.registered";
    public static final String EVENT_APPLICATION_PARTY_REGISTERED = "applicationParty.registered";
    public static final String EVENT_APPLICATION_DOCUMENT_REGISTERED = "applicationDocument.registered";
    public static final String EVENT_APPLICATION_COLLATERAL_REGISTERED = "applicationCollateral.registered";


}
