package com.nettee.application.command.board.dto;

import jakarta.validation.constraints.NotNull;

public record BoardDeleteCommand(
        @NotNull Long id
) {
}
