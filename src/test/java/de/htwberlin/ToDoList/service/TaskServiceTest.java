package de.htwberlin.ToDoList.service;


import de.htwberlin.ToDoList.model.Task;
import de.htwberlin.ToDoList.model.TaskManipulationCreateRequest;
import de.htwberlin.ToDoList.persistence.TaskEntity;
import de.htwberlin.ToDoList.repository.TaskRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest implements WithAssertions {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        // given
        Long givenId = 111L;
        doReturn(true).when(repository).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if person to delete does not exist")
    void should_return_false_if_person_to_delete_does_not_exist() {
        // given
        Long givenId = 111L;
        doReturn(false).when(repository).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
    @Test
    public void testUpdateTask() {
        // Arrange
        Long taskId = 1L;
        TaskManipulationCreateRequest request = new TaskManipulationCreateRequest("Updated Title", true);
        TaskEntity existingTaskEntity = new TaskEntity("Original Title", false);
        existingTaskEntity.setId(taskId);

        // Mocking repository behavior
        Mockito.when(repository.findById(taskId)).thenReturn(Optional.of(existingTaskEntity));
        Mockito.when(repository.save(Mockito.any(TaskEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Task updatedTask = underTest.update(taskId, request);

        // Assert
        assertEquals(request.getTitle(), updatedTask.getTitle());
        assertEquals(request.getCompleted(), updatedTask.getCompleted());
    }

}
