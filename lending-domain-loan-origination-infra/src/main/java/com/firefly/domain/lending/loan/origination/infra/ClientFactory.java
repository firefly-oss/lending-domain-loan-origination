package com.firefly.domain.lending.loan.origination.infra;

import com.firefly.core.lending.origination.sdk.api.ApplicationCollateralApi;
import com.firefly.core.lending.origination.sdk.api.ApplicationDocumentApi;
import com.firefly.core.lending.origination.sdk.api.ApplicationPartyApi;
import com.firefly.core.lending.origination.sdk.api.LoanApplicationStatusHistoryApi;
import com.firefly.core.lending.origination.sdk.api.LoanApplicationsApi;
import com.firefly.core.lending.origination.sdk.api.ProposedOfferApi;
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
    public ApplicationCollateralApi applicationCollateralApi() {
        return new ApplicationCollateralApi(apiClient);
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

    @Bean
    public ProposedOfferApi proposedOfferApi() {
        return new ProposedOfferApi(apiClient);
    }

    @Bean
    public LoanApplicationStatusHistoryApi loanApplicationStatusHistoryApi() {
        return new LoanApplicationStatusHistoryApi(apiClient);
    }
}
