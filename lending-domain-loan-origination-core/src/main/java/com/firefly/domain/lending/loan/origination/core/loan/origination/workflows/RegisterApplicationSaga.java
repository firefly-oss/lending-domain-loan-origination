package com.firefly.domain.lending.loan.origination.core.loan.origination.workflows;

import com.firefly.common.domain.cqrs.command.CommandBus;
import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.RegisterApplicationPartyCommand;
import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.RegisterLoanApplicationCommand;
import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.RemoveApplicationPartyCommand;
import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.RemoveLoanApplicationCommand;
import com.firefly.transactional.annotations.Saga;
import com.firefly.transactional.annotations.SagaStep;
import com.firefly.transactional.annotations.StepEvent;
import com.firefly.transactional.core.SagaContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.firefly.domain.lending.loan.origination.core.loan.utils.constants.GlobalConstants.CTX_APPLICATION_PARTY_ID;
import static com.firefly.domain.lending.loan.origination.core.loan.utils.constants.GlobalConstants.CTX_LOAN_APPLICATION_ID;
import static com.firefly.domain.lending.loan.origination.core.loan.utils.constants.RegisterApplicationConstants.*;


@Saga(name = SAGA_REGISTER_APPLICATION)
@Service
public class RegisterApplicationSaga {

    private final CommandBus commandBus;

    @Autowired
    public RegisterApplicationSaga(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @SagaStep(id = STEP_REGISTER_LOAN_APPLICATION, compensate = COMPENSATE_REMOVE_LOAN_APPLICATION)
    @StepEvent(type = EVENT_LOAN_APPLICATION_REGISTERED)
    public Mono<UUID> registerLoanApplication(RegisterLoanApplicationCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd)
                .doOnNext(loanApplicationId -> ctx.variables().put(CTX_LOAN_APPLICATION_ID, loanApplicationId));
    }

    public Mono<Void> removeLoanApplication(UUID loanApplicationId) {
        return commandBus.send(new RemoveLoanApplicationCommand(loanApplicationId));
    }


    @SagaStep(id = STEP_REGISTER_APPLICATION_PARTY, compensate = COMPENSATE_REMOVE_APPLICATION_PARTY, dependsOn = STEP_REGISTER_LOAN_APPLICATION)
    @StepEvent(type = EVENT_APPLICATION_PARTY_REGISTERED)
    public Mono<UUID> registerApplicationParty(RegisterApplicationPartyCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd.withLoanApplicationId(ctx.getVariableAs(CTX_LOAN_APPLICATION_ID, UUID.class)))
                .doOnNext(applicationPartyId -> ctx.variables().put(CTX_APPLICATION_PARTY_ID, applicationPartyId));
    }

    public Mono<Void> removeApplicationParty(UUID applicationPartyId, SagaContext ctx) {
        return commandBus.send(new RemoveApplicationPartyCommand(ctx.getVariableAs(CTX_LOAN_APPLICATION_ID, UUID.class), applicationPartyId));
    }


}
