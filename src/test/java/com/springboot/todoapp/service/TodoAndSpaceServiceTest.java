package com.springboot.todoapp.service;

import com.springboot.todoapp.mappers.SpaceMapper;
import com.springboot.todoapp.models.dto.SpaceRequestDTO;
import com.springboot.todoapp.models.dto.SpaceSummaryResponseDTO;
import com.springboot.todoapp.models.entity.Space;
import com.springboot.todoapp.repositories.SpaceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoAndSpaceServiceTest {

    @Mock
    private SpaceRepository spaceRepository;

    @InjectMocks
    private TodoAndSpaceService todoAndSpaceService;

    @Test
    void getAllSpaces_shouldReturnListOfSpaceSummaryResponseDTOs() {
        // Arrange
        List<Space> spaces = new ArrayList<>();
        spaces.add(new Space(1L, "Space 1"));
        spaces.add(new Space(2L, "Space 2"));
        when(spaceRepository.findAll()).thenReturn(spaces);

        // Act
        List<SpaceSummaryResponseDTO> result = todoAndSpaceService.getAllSpaces();

        // Assert
        assertEquals(2, result.size());
        verify(spaceRepository, times(1)).findAll();
    }

    @Test
    void createSpace_shouldSaveSpaceAndReturnSpaceSummaryDTO() {
        try (MockedStatic<SpaceMapper> mockedStatic = mockStatic(SpaceMapper.class)) {
            // Arrange
            SpaceRequestDTO spaceRequestDTO = new SpaceRequestDTO("New Space");
            Space space = new Space(null, "New Space"); // Description is not directly set in SpaceRequestDTO to Space entity
            Space savedSpace = new Space(1L, "New Space");
            SpaceSummaryResponseDTO expectedDto = new SpaceSummaryResponseDTO(1L, "New Space");

            mockedStatic.when(() -> SpaceMapper.toEntity(spaceRequestDTO)).thenReturn(space);
            when(spaceRepository.save(space)).thenReturn(savedSpace);
            mockedStatic.when(() -> SpaceMapper.toSummaryDTO(savedSpace)).thenReturn(expectedDto);

            // Act
            SpaceSummaryResponseDTO result = todoAndSpaceService.createSpace(spaceRequestDTO);

            // Assert
            assertNotNull(result);
            assertEquals(expectedDto.getId(), result.getId());
            assertEquals(expectedDto.getSpaceName(), result.getSpaceName()); // Changed from getName() to getSpaceName()
            verify(spaceRepository, times(1)).save(any(Space.class));
            mockedStatic.verify(() -> SpaceMapper.toEntity(spaceRequestDTO), times(1));
            mockedStatic.verify(() -> SpaceMapper.toSummaryDTO(savedSpace), times(1));
        }
    }
}
