package de.htwberlin.ToDoList.controller;




import de.htwberlin.ToDoList.model.Task;
import de.htwberlin.ToDoList.service.TaskService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.mockito.ArgumentMatchers.any;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;



    @Test
    @DisplayName("should return 201 http status and Location header when creating a person")
    void should_return_201_http_status_and_location_header_when_creating_a_person() throws Exception {
        // given
        String taskCreate = "{\"title\": \"add1\", \"completed\": true}";
        var task = new Task(23L, "add1", true);
        doReturn(task).when(taskService).create(any());

        // when
        mockMvc.perform(
                        post("/api/a1/task")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(taskCreate)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/a1/task" + task.getId()))));
//            .andExpect(header().string("Location", Matchers.containsString(Long.toString(person.getId()))));

}
    @Test
    @DisplayName("should return 404 if task is not found")
    public void fetchTaskById() throws Exception {
        // given
        doReturn(null).when(taskService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/a1/task/12"))
                // then
                .andExpect(status().isNotFound());


    }
    /** @Test
     @DisplayName("should return found tasks from task service")
     void test2() throws Exception {
     // given
     var task = List.of(
     new Task(36L, "add task 1", true),
     new Task(11L,"zur Moschee gehen",true)
     );
     doReturn(task).when(service).findAll();

     // when
     mockMvc.perform(get("/api/a1/task"))
     // then
     .andExpect(status().isOk())
     .andExpect(jsonPath("$.size()").value(36))
     .andExpect(jsonPath("$[0].id").value(11))
     .andExpect(jsonPath("$[0].title").value("add task 1"))
     ;
     }**/


}
