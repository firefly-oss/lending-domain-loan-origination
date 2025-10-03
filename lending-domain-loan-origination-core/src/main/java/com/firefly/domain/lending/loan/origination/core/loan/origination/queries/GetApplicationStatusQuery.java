package com.firefly.domain.lending.loan.origination.core.loan.origination.queries;

import com.firefly.common.domain.cqrs.query.Query;
import com.firefly.core.lending.origination.sdk.model.ApplicationStatusDTO;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetApplicationStatusQuery implements Query<ApplicationStatusDTO> {
    private String applicationStatusCode;
    private UUID applicationStatusId;

    public GetApplicationStatusQuery withApplicationStatusId(UUID applicationStatusId) {
        this.applicationStatusId = applicationStatusId;
        return this;
    }
}