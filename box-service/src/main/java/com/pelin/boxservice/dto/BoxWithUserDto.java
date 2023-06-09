package com.pelin.boxservice.dto;

import java.util.List;

public class BoxWithUserDto {
    UserDto recipient;
    UserDto sender;
    List<BoxDto>boxes;

    public BoxWithUserDto(){}

    public BoxWithUserDto(UserDto recipient, UserDto sender, List<BoxDto> boxes) {
        this.recipient = recipient;
        this.sender = sender;
        this.boxes = boxes;
    }

    public UserDto getRecipient() {
        return recipient;
    }

    public void setRecipient(UserDto recipient) {
        this.recipient = recipient;
    }

    public UserDto getSender() {
        return sender;
    }

    public void setSender(UserDto sender) {
        this.sender = sender;
    }

    public List<BoxDto> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<BoxDto> boxes) {
        this.boxes = boxes;
    }
}
