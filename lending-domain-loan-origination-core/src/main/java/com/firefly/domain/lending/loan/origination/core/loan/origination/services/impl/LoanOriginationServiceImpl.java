package com.firefly.domain.lending.loan.origination.core.loan.origination.services.impl;

import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.*;
import com.firefly.domain.lending.loan.origination.core.loan.origination.services.LoanOriginationService;
import com.firefly.domain.lending.loan.origination.core.loan.origination.workflows.RegisterApplicationSaga;
import com.firefly.domain.lending.loan.origination.core.loan.origination.workflows.RegisterApplicationDocumentSaga;
import com.firefly.transactional.core.SagaResult;
import com.firefly.transactional.engine.ExpandEach;
import com.firefly.transactional.engine.SagaEngine;
import com.firefly.transactional.engine.StepInputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class LoanOriginationServiceImpl implements LoanOriginationService {

    private final SagaEngine engine;

    @Autowired
    public LoanOriginationServiceImpl(SagaEngine engine){
        this.engine=engine;
    }

    @Override
    public Mono<SagaResult> submitApplication(SubmitApplicationCommand command) {
        StepInputs inputs = StepInputs.builder()
                .forStep(RegisterApplicationSaga::registerLoanApplication, command.getApplication())
                .forStep(RegisterApplicationSaga::registerApplicationParty, ExpandEach.of(command.getParties()))
                .forStep(RegisterApplicationSaga::registerApplicationDocument, ExpandEach.of(command.getDocuments()))
                .forStep(RegisterApplicationSaga::registerCollateral, ExpandEach.of(command.getCollaterals()))
                .forStep(RegisterApplicationSaga::registerOffer, ExpandEach.of(command.getOffers()))
                .forStep(RegisterApplicationSaga::registerStatus, ExpandEach.of(command.getStatusHistories()))
                .forStep(RegisterApplicationSaga::registerScore, command.getScore())
                .forStep(RegisterApplicationSaga::registerDecision, command.getDecision())
                .build();

        return engine.execute(RegisterApplicationSaga.class, inputs);
    }

    @Override
    public Mono<SagaResult> attachDocuments(UUID appId, RegisterApplicationDocumentCommand command) {
        StepInputs inputs = StepInputs.builder()
                .forStep(RegisterApplicationDocumentSaga::registerApplicationDocument, command.withLoanApplicationId(appId))
                .build();

        return engine.execute(RegisterApplicationDocumentSaga.class, inputs);
    }

    @Override
    public Mono<SagaResult> withdrawApplication(String appId, WithdrawApplicationCommand command) {
        // TODO: Implement application withdrawal logic
        return Mono.empty();
    }

    @Override
    public Mono<SagaResult> scoreApplication(String appId, ScoreApplicationCommand command) {
        // TODO: Implement scoring logic
        return Mono.empty();
    }

    @Override
    public Mono<SagaResult> approveApplication(String appId, ApproveApplicationCommand command) {
        // TODO: Implement approval logic
        return Mono.empty();
    }

    @Override
    public Mono<SagaResult> rejectApplication(String appId, RejectApplicationCommand command) {
        // TODO: Implement rejection logic
        return Mono.empty();
    }

    @Override
    public Mono<Object> getApplication(String appId) {
        // TODO: Implement application retrieval logic
        return Mono.empty();
    }
}
