package com.cursor.dto;

// हिंदी में उत्तर:

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;


public class TaskCreationDto {
    @NotBlank(message = "Title आवश्यक है")
    private String title;

    @NotBlank(message = "Description आवश्यक है")
    private String description;

    @NotNull(message = "Due date आवश्यक है")
    @FutureOrPresent(message = "Due date आज या भविष्य की होनी चाहिए")
    private LocalDate dueDate;

    public TaskCreationDto() {
    }

    public TaskCreationDto(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}

