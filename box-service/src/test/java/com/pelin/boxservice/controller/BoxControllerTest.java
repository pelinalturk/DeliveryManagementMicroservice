package com.pelin.boxservice.controller;

import com.pelin.boxservice.dto.BoxDto;
import com.pelin.boxservice.dto.BoxWithUserDto;
import com.pelin.boxservice.dto.UserDto;
import com.pelin.boxservice.model.Box;
import com.pelin.boxservice.model.DeliveryStatus;
import com.pelin.boxservice.model.request.CreateBoxRequest;
import com.pelin.boxservice.service.BoxService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BoxControllerTest {

    @Mock
    private BoxService mockBoxService;

    @InjectMocks
    private BoxController boxController;

    @Test
    void add_shouldCreateSuccessfully() {

        Box box = new Box();
        box.setSenderId("647776ad5cac6537f4939d1b");
        box.setCreatedAt(LocalDate.now());
        box.setDeliveryStatus(DeliveryStatus.PENDING);
        box.setDimensions("test-case");
        box.setWeight(50);
        box.setRecipientId("647772ca5cac6537f4939d19");
        Optional<Box> expected = Optional.of(box);

        when(mockBoxService.addBox(any())).thenReturn(expected.get());

        CreateBoxRequest createBoxRequest = new CreateBoxRequest();
        ResponseEntity<Box> response = boxController.addBox(createBoxRequest);
        Box actual = response.getBody();

        assertAll(
                ()-> assertNotNull(actual),
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertEquals(expected.get(), actual),
                () -> assertEquals(box.getId(), actual.getId())
        );
    }

    @Test
    void getAll_itShouldReturnBoxList() {
        Box box = new Box();
        List<Box> boxList = Collections.singletonList(box);

        when(mockBoxService.getAll()).thenReturn(boxList);

        ResponseEntity<List<Box>> response = boxController.getAllBox();
        List<Box> actualBoxList = response.getBody();

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(boxList, actualBoxList)
        );

    }

    @Test
    void getBoxByUser_shouldReturnBoxWithUserDto() {
        String recipientId = "647772ca5cac6537f4939d19";
        Box box = new Box();
        box.setSenderId("647776ad5cac6537f4939d1b");
        box.setRecipientId(recipientId);

        UserDto senderUser = new UserDto();
        senderUser.setFirstname("Test");
        senderUser.setLastname("Sender");
        senderUser.setEmail("testSender@gmail.com");

        UserDto recipientUser = new UserDto();
        recipientUser.setFirstname("Test");
        recipientUser.setLastname("Recipient");
        recipientUser.setEmail("RecipientTest@gmail.com");

        List<BoxDto> boxes = Collections.singletonList(new BoxDto());

        BoxWithUserDto expectedBoxWithUserDto = new BoxWithUserDto();
        expectedBoxWithUserDto.setRecipient(recipientUser);
        expectedBoxWithUserDto.setSender(senderUser);
        expectedBoxWithUserDto.setBoxes(boxes);

        when(mockBoxService.getBoxesByUser(recipientId)).thenReturn(expectedBoxWithUserDto);

        ResponseEntity<BoxWithUserDto> response = boxController.getBoxByUser(recipientId);
        BoxWithUserDto actualBoxWithUserDto = response.getBody();

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(expectedBoxWithUserDto, actualBoxWithUserDto)
        );
    }

    @Test
    void updateBoxStatus_shouldUpdateBoxStatus() {
        String boxId = "12345";
        String status = "IN_PROGRESS";

        ResponseEntity<String> response = boxController.updateBoxStatus(boxId, status);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Box status updated successfully.", response.getBody());

    }
}