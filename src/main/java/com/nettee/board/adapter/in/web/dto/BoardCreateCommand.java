package com.nettee.board.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;

public record BoardCreateCommand(
        @NotNull String title,
        @NotNull String content
) {
}
