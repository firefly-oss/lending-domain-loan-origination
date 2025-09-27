package com.firefly.domain.lending.loan.origination.core.loan.origination.services.impl;

import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.*;
import com.firefly.domain.lending.loan.origination.core.loan.origination.services.LoanOriginationService;
import com.firefly.transactional.core.SagaResult;
import com.firefly.transactional.engine.SagaEngine;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LoanOriginationServiceImpl implements LoanOriginationService {

    private final SagaEngine engine;

    @Autowired
    public LoanOriginationServiceImpl(SagaEngine engine){
        this.engine=engine;
    }

    @Override
    public Mono<SagaResult> submitApplication(SubmitApplicationCommand command) {
        // TODO: Implement loan application submission logic
        return Mono.empty();
    }

    @Override
    public Mono<SagaResult> attachDocuments(String appId, AttachDocumentsCommand command) {
        // TODO: Implement document attachment logic
        return Mono.empty();
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
