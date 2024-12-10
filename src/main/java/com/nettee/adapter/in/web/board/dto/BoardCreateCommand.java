package com.nettee.adapter.in.web.board.dto;

import jakarta.validation.constraints.NotNull;

public record BoardCreateCommand(
        @NotNull String title,
        @NotNull String content
) {
}
