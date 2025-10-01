package com.firefly.domain.lending.loan.origination.core.loan.origination.handlers;

import com.firefly.common.domain.cqrs.annotations.QueryHandlerComponent;
import com.firefly.common.domain.cqrs.query.QueryHandler;
import com.firefly.core.lending.origination.sdk.api.ApplicationStatusApi;
import com.firefly.core.lending.origination.sdk.api.LoanApplicationsApi;
import com.firefly.core.lending.origination.sdk.model.LoanApplicationDTO;
import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.GetApplicationStatusQuery;
import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.GetLoanApplicationQuery;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@QueryHandlerComponent
public class GetLoanApplicationHandler extends QueryHandler<GetLoanApplicationQuery, LoanApplicationDTO> {

    private final LoanApplicationsApi loanApplicationsApi;

    public GetLoanApplicationHandler(LoanApplicationsApi loanApplicationsApi) {
        this.loanApplicationsApi = loanApplicationsApi;
    }

    @Override
    protected Mono<LoanApplicationDTO> doHandle(GetLoanApplicationQuery cmd) {
        return loanApplicationsApi.getLoanApplication(cmd.getLoanApplicationId());
    }
}