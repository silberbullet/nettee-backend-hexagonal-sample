package com.nettee.adapter.in.web.board.dto;

import jakarta.validation.constraints.NotNull;

public record BoardDeleteCommand(
        @NotNull Long id
) {
}
