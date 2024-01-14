package de.htwberlin.ToDoList.service;


import de.htwberlin.ToDoList.api.Task;
import de.htwberlin.ToDoList.api.TaskManipulationCreateRequest;
import de.htwberlin.ToDoList.persistence.Priority;
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

import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
    public void testUpdateTask() {
        // Arrange
        Long taskId = 1L;
        LocalDate deadline = LocalDate.of(2024, 1, 14);
        TaskManipulationCreateRequest request = new TaskManipulationCreateRequest("Updated Title", true, Priority.HIGH,  deadline, "task1");
        TaskEntity existingTaskEntity = new TaskEntity("Original Title", false,  Priority.LOW,  deadline, "task1");
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
