package com.firefly.domain.lending.loan.origination.core.loan.utils.constants;

public class RegisterApplicationConstants {

    // ============================== SAGA CONFIGURATION ==============================
    public static final String SAGA_REGISTER_APPLICATION = "RegisterApplicationSaga";

    // ============================== STEP IDENTIFIERS ==============================
    public static final String STEP_REGISTER_APPLICATION_PARTY = "registerApplicationParty";
    public static final String STEP_REGISTER_APPLICATION_DOCUMENT = "registerApplicationDocument";
    public static final String STEP_REGISTER_APPLICATION_COLLATERAL = "registerCollaterals";
    public static final String STEP_REGISTER_LOAN_APPLICATION = "registerLoanApplication";
    public static final String STEP_REGISTER_OFFER = "registerOffer";
    public static final String STEP_REGISTER_STATUS = "registerStatus";
    public static final String STEP_REGISTER_SCORE = "registerScore";
    public static final String STEP_REGISTER_DECISION = "registerDecision";


    // ============================== COMPENSATE METHODS ==============================
    public static final String COMPENSATE_REMOVE_LOAN_APPLICATION = "removeLoanApplication";
    public static final String COMPENSATE_REMOVE_APPLICATION_PARTY = "removeApplicationParty";
    public static final String COMPENSATE_REMOVE_APPLICATION_DOCUMENT = "removeApplicationDocument";
    public static final String COMPENSATE_REMOVE_APPLICATION_COLLATERAL = "removeApplicationCollateral";
    public static final String COMPENSATE_REMOVE_OFFER = "removeOffer";
    public static final String COMPENSATE_REMOVE_STATUS = "removeStatus";
    public static final String COMPENSATE_REMOVE_SCORE = "removeScore";
    public static final String COMPENSATE_REMOVE_DECISION = "removeDecision";

    // ============================== EVENT TYPES ==============================
    public static final String EVENT_LOAN_APPLICATION_REGISTERED = "loanApplication.registered";
    public static final String EVENT_APPLICATION_PARTY_REGISTERED = "applicationParty.registered";
    public static final String EVENT_APPLICATION_DOCUMENT_REGISTERED = "applicationDocument.registered";
    public static final String EVENT_APPLICATION_COLLATERAL_REGISTERED = "applicationCollateral.registered";
    public static final String EVENT_OFFER_REGISTERED = "offer.registered";
    public static final String EVENT_STATUS_REGISTERED = "status.registered";
    public static final String EVENT_SCORE_REGISTERED = "score.registered";
    public static final String EVENT_DECISION_REGISTERED = "decision.registered";


}
