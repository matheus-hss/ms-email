package com.ms.email.dto;

public record EmailDTO(
    String emailTo,
    String subject,
    String text
) { }
