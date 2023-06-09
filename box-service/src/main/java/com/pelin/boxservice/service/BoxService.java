package com.pelin.boxservice.service;

import com.pelin.boxservice.client.AuthServerClient;
import com.pelin.boxservice.dto.BoxDto;
import com.pelin.boxservice.dto.BoxWithUserDto;
import com.pelin.boxservice.dto.UserDto;
import static com.pelin.boxservice.mapper.BoxMapper.BOX_MAPPER;
import com.pelin.boxservice.model.Box;
import com.pelin.boxservice.model.DeliveryStatus;
import com.pelin.boxservice.model.request.CreateBoxRequest;
import com.pelin.boxservice.repository.BoxRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoxService {
    private final BoxRepository boxRepository;
    private final AuthServerClient authServerClient;
    private final MailService mailService;

    public BoxService(BoxRepository boxRepository, AuthServerClient authServerClient, MailService mailService) {
        this.boxRepository = boxRepository;
        this.authServerClient = authServerClient;
        this.mailService = mailService;
    }

    public Box addBox(CreateBoxRequest createBoxRequest){
        return boxRepository.save(BOX_MAPPER.createBox(createBoxRequest));
    }

    public BoxWithUserDto getBoxesByUser(String userId){
        Box box = boxRepository.findByRecipientId(userId);
        UserDto senderUser = getUserById(box.getSenderId());
        UserDto recipientUser = getUserById(userId);
        List<BoxDto> boxes = getBoxesByRecipientId(userId);

        BoxWithUserDto boxWithUserDto = new BoxWithUserDto();
        boxWithUserDto.setSender(senderUser);
        boxWithUserDto.setRecipient(recipientUser);
        boxWithUserDto.setBoxes(boxes);

        return boxWithUserDto;
    }

    public List<Box> getAll() {
        return boxRepository.findAll();
    }

    private UserDto getUserById(String userId) {
        return authServerClient.getUserById(userId).getBody();
    }
    private List<BoxDto> getBoxesByRecipientId(String userId) {
        return boxRepository.findAllByRecipientId(userId)
                .stream()
                .map(BOX_MAPPER::convertToBoxDto)
                .collect(Collectors.toList());
    }

    public void updateBoxStatus(String boxId, String status) {
        Box box = boxRepository.findById(boxId).orElseThrow(() -> new NotFoundException("Box not found."));
        UserDto user = getUserById(box.getRecipientId());
        DeliveryStatus newStatus = DeliveryStatus.valueOf(status);
        box.setDeliveryStatus(newStatus);
        boxRepository.save(box);
        mailService.sendMail(user.getEmail(), DeliveryStatus.IN_PROGRESS);
    }
}
