package com.springboot.todoapp.mappers;

import com.springboot.todoapp.models.dto.SpaceDetailResponseDTO;
import com.springboot.todoapp.models.dto.SpaceRequestDTO;
import com.springboot.todoapp.models.dto.SpaceSummaryResponseDTO;
import com.springboot.todoapp.models.entity.Space;

import java.util.Optional;
import java.util.stream.Collectors;

public class SpaceMapper {

    public static Space toEntity(SpaceRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        Space space = new Space();
        space.setSpaceName(dto.getSpaceName());
        return space;
    }

    public static SpaceSummaryResponseDTO toSummaryDTO(Space entity) {
        return Optional.ofNullable(entity)
                .map(e -> new SpaceSummaryResponseDTO(e.getId(), e.getSpaceName()))
                .orElse(null);
    }

    public static SpaceDetailResponseDTO toDetailDTO(Space entity) {
        return Optional.ofNullable(entity)
                .map(e -> new SpaceDetailResponseDTO(
                        e.getId(),
                        e.getSpaceName(),
                        e.getTodoItems()
                                .stream()
                                .map(TodoItemMapper::toDTO)
                                .collect(Collectors.toSet())
                ))
                .orElse(null);
    }
}
