package com.firefly.domain.lending.loan.origination.core.loan.origination.commands;

import com.firefly.common.domain.cqrs.command.Command;

import java.util.UUID;

public record RemoveLoanApplicationStatusHistoryCommand(
        UUID loanApplicationId,
        UUID statusHistoryId
) implements Command<Void>{}