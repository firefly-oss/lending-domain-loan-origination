package com.firefly.domain.lending.loan.origination.core.loan.origination.commands;

import com.firefly.common.domain.cqrs.command.Command;
import com.firefly.common.domain.cqrs.query.Query;
import com.firefly.core.lending.origination.sdk.model.ApplicationStatusDTO;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetApplicationStatusQuery implements Query<ApplicationStatusDTO> {
    private String applicationStatusCode;

    public GetApplicationStatusQuery withApplicationStatusCode(String applicationStatusCode) {
        this.applicationStatusCode = applicationStatusCode;
        return this;
    }
}