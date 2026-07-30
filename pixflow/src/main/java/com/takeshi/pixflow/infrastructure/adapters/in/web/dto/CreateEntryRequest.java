package com.takeshi.pixflow.infrastructure.adapters.in.web.dto;

import java.math.BigDecimal;

public record CreateEntryRequest (
        String destinationAccountId,
        BigDecimal amount
){
}
