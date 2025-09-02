package com.springboot.todoapp.models.dto;

public class SpaceSummaryResponseDTO {
    private Long id;
    private String spaceName;

    public SpaceSummaryResponseDTO() {
    }

    public SpaceSummaryResponseDTO(Long id, String spaceName) {
        this.id = id;
        this.spaceName = spaceName;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
