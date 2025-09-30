package com.firefly.domain.lending.loan.origination.core.loan.origination.handlers;

import com.firefly.common.domain.cqrs.annotations.CommandHandlerComponent;
import com.firefly.common.domain.cqrs.command.CommandHandler;
import com.firefly.core.lending.origination.sdk.api.LoanApplicationsApi;
import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.RemoveApplicationPartyCommand;
import reactor.core.publisher.Mono;

@CommandHandlerComponent
public class RemoveLoanApplicationHandler extends CommandHandler<RemoveApplicationPartyCommand, Void> {

    private final LoanApplicationsApi loanApplicationsApi;

    public RemoveLoanApplicationHandler(LoanApplicationsApi loanApplicationsApi) {
        this.loanApplicationsApi = loanApplicationsApi;
    }

    @Override
    protected Mono<Void> doHandle(RemoveApplicationPartyCommand cmd) {
        return loanApplicationsApi.deleteLoanApplication(cmd.loanApplicationId()).then();
    }
}
