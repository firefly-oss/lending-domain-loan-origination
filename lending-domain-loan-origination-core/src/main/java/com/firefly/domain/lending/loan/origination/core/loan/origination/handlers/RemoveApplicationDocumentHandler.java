package com.firefly.domain.lending.loan.origination.core.loan.origination.handlers;

import com.firefly.common.domain.cqrs.annotations.CommandHandlerComponent;
import com.firefly.common.domain.cqrs.command.CommandHandler;
import com.firefly.core.lending.origination.sdk.api.ApplicationDocumentApi;
import com.firefly.core.lending.origination.sdk.api.ApplicationPartyApi;
import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.RemoveApplicationDocumentCommand;
import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.RemoveApplicationPartyCommand;
import reactor.core.publisher.Mono;

@CommandHandlerComponent
public class RemoveApplicationDocumentHandler extends CommandHandler<RemoveApplicationDocumentCommand, Void> {

    private final ApplicationDocumentApi applicationDocumentApi;

    public RemoveApplicationDocumentHandler(ApplicationDocumentApi applicationDocumentApi) {
        this.applicationDocumentApi = applicationDocumentApi;
    }

    @Override
    protected Mono<Void> doHandle(RemoveApplicationDocumentCommand cmd) {
        return applicationDocumentApi.deleteDocument(cmd.loanApplicationId(), cmd.applicationDocumentId()).then();
    }
}
