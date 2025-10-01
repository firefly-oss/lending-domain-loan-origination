package com.firefly.domain.lending.loan.origination.web.controller;

import com.firefly.domain.lending.loan.origination.core.loan.origination.commands.*;
import com.firefly.domain.lending.loan.origination.core.loan.origination.services.LoanOriginationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/loan-applications")
@RequiredArgsConstructor
@Tag(name = "Loan Origination", description = "CQ queries and registration for Loan Origination")
public class LoanOriginationController {

    private final LoanOriginationService loanOriginationService;

    @Operation(summary = "Submit application", description = "Submit an application with product, amount, currency, and channel.")
    @PostMapping
    public Mono<ResponseEntity<Object>> submitApplication(@Valid @RequestBody SubmitApplicationCommand command) {
        return loanOriginationService.submitApplication(command)
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Attach documents", description = "Attach supporting documents including income, statements, and collateral.")
    @PostMapping("/{appId}/documents")
    public Mono<ResponseEntity<Object>> attachDocuments(@PathVariable UUID appId, @Valid @RequestBody RegisterApplicationDocumentCommand command) {
        return loanOriginationService.attachDocuments(appId, command)
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Withdraw application", description = "Withdraw the application by applicant request.")
    @PostMapping("/{appId}/withdraw")
    public Mono<ResponseEntity<Object>> withdrawApplication(@PathVariable String appId, @Valid @RequestBody WithdrawApplicationCommand command) {
        return loanOriginationService.withdrawApplication(appId, command)
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Score application", description = "Persist model score with model and version metadata.")
    @PostMapping("/{appId}/score")
    public Mono<ResponseEntity<Object>> scoreApplication(@PathVariable String appId, @Valid @RequestBody ScoreApplicationCommand command) {
        return loanOriginationService.scoreApplication(appId, command)
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Approve application", description = "Approve with terms including rate, tenor, and fees aligned with product rules.")
    @PostMapping("/{appId}/approve")
    public Mono<ResponseEntity<Object>> approveApplication(@PathVariable String appId, @Valid @RequestBody ApproveApplicationCommand command) {
        return loanOriginationService.approveApplication(appId, command)
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Reject application", description = "Reject with reason for risk, eligibility, or documentation issues.")
    @PostMapping("/{appId}/reject")
    public Mono<ResponseEntity<Object>> rejectApplication(@PathVariable String appId, @Valid @RequestBody RejectApplicationCommand command) {
        return loanOriginationService.rejectApplication(appId, command)
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Get application", description = "Retrieve application state and audit log.")
    @GetMapping("/{appId}")
    public Mono<ResponseEntity<Object>> getApplication(@PathVariable String appId) {
        return loanOriginationService.getApplication(appId)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
