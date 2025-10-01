package com.firefly.domain.lending.loan.origination.core.loan.origination.services;

import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.*;
import com.firefly.transactional.core.SagaResult;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface LoanOriginationService {

    /**
     * Submits a loan application for processing. The application includes necessary
     * details such as product, amount, currency, and channel information.
     *
     * @param command the command containing the details of the loan application
     * @return a Mono emitting the result of the saga process for the submitted application
     */
    Mono<SagaResult> submitApplication(@Valid SubmitApplicationCommand command);
    
    /**
     * Attaches supporting documents to the specified loan application. These documents might include
     * income statements, bank statements, collateral documentation, and other necessary files.
     *
     * @param appId the unique identifier of the loan application to which documents are being attached
     * @param command the command containing the information and references for the documents to be attached
     * @return a reactive Mono emitting the result of the document attachment operation, encapsulated in a SagaResult
     */
    Mono<SagaResult> attachDocuments(UUID appId, @Valid RegisterApplicationDocumentCommand command);
    
    /**
     * Withdraws an existing loan application based on the provided application ID and command.
     * This method is used to handle the withdrawal request initiated by the applicant.
     *
     * @param appId The unique identifier of the loan application to be withdrawn.
     * @param command The command containing details required for the withdrawal operation.
     * @return A {@code Mono<SagaResult>} indicating the outcome of the withdrawal process.
     */
    Mono<SagaResult> withdrawApplication(String appId, @Valid WithdrawApplicationCommand command);
    
    /**
     * Scores a loan application by persisting a model score along with metadata about the model
     * and its version.
     *
     * @param appId the unique identifier of the loan application to be scored
     * @param command the command containing the details necessary to score the application
     * @return a Mono emitting a SagaResult representing the outcome of the scoring operation
     */
    Mono<SagaResult> scoreApplication(UUID appId, @Valid RegisterUnderwritingScoreCommand command);
    

    /**
     * Approves a loan application by updating its status to an approved state.
     * This method processes the approval operation, including setting the appropriate
     * application status and triggering any related business logic.
     *
     * @param command the command containing the details of the loan application
     *                and the updated status information.
     * @return a Mono emitting the result of the approval process, encapsulated in a SagaResult.
     */
    Mono<SagaResult> updateApplicationStatus(UpdateApplicationStatusCommand command);
    
    /**
     * Rejects a loan application for the specified application ID with the provided rejection details.
     *
     * @param appId the unique identifier of the application to be rejected
     * @param command the command containing details for rejecting the application
     * @return a {@code Mono<SagaResult>} indicating the result of the rejection operation
     */
    Mono<SagaResult> rejectApplication(String appId, @Valid RejectApplicationCommand command);
    
    /**
     * Retrieves the details and state of a specified loan application.
     *
     * @param appId the unique identifier of the loan application to retrieve
     * @return a {@code Mono} emitting the loan application details, or empty if not found
     */
    Mono<Object> getApplication(String appId);
}
