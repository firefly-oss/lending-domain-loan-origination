package com.firefly.domain.lending.loan.origination.core.loan.origination.commands;

import com.firefly.common.domain.cqrs.command.Command;
import lombok.Data;

import java.util.UUID;

@Data
public class SubmitApplicationCommand implements Command<UUID> {
}