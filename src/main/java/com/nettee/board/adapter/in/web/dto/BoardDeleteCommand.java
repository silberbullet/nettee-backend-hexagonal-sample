package com.nettee.board.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;

public record BoardDeleteCommand(
        @NotNull Long id
) {
}
