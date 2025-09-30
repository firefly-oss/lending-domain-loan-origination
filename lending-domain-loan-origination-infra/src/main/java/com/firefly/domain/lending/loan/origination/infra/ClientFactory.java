package com.firefly.domain.lending.loan.origination.infra;

import com.firefly.core.lending.origination.sdk.api.ApplicationDocumentApi;
import com.firefly.core.lending.origination.sdk.api.ApplicationPartyApi;
import com.firefly.core.lending.origination.sdk.api.LoanApplicationsApi;
import com.firefly.core.lending.origination.sdk.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Default implementation of the ClientFactory interface.
 * Creates client service instances using the appropriate API clients and dependencies.
 */
@Component
public class ClientFactory {

    private final ApiClient apiClient;

    @Autowired
    public ClientFactory(
            LoanOriginationProperties loanOriginationProperties) {
        this.apiClient = new ApiClient();
        this.apiClient.setBasePath(loanOriginationProperties.getBasePath());
    }

    @Bean
    public ApplicationDocumentApi applicationDocumentApi() {
        return new ApplicationDocumentApi(apiClient);
    }

    @Bean
    public ApplicationPartyApi applicationPartyApi() {
        return new ApplicationPartyApi(apiClient);
    }

    @Bean
    public LoanApplicationsApi loanApplicationsApi() {
        return new LoanApplicationsApi(apiClient);
    }
}
