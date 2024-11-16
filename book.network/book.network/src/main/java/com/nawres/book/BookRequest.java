package com.nawres.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

//record is a type where we define the diffrent attributes that we need

public record BookRequest(

                // in record we don't need private or public annotation
                Integer id,

                @NotNull(message = "100") @NotEmpty(message = "100") String title,

                @NotNull(message = "101") @NotEmpty(message = "101") String authorName,

                @NotNull(message = "102") @NotEmpty(message = "102") String isbn,

                @NotNull(message = "103") @NotEmpty(message = "103") String synopsis,

                boolean shareable) {

}
