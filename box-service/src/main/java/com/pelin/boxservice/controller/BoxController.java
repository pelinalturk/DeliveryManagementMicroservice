package com.pelin.boxservice.controller;

import com.pelin.boxservice.dto.BoxWithUserDto;
import com.pelin.boxservice.model.Box;
import com.pelin.boxservice.model.request.CreateBoxRequest;
import com.pelin.boxservice.service.BoxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/box")
public class BoxController {

    private final BoxService boxService;

    public BoxController(BoxService boxService) {
        this.boxService = boxService;
    }

    @PostMapping
    public ResponseEntity<Box>addBox(CreateBoxRequest createBoxRequest){
        return ResponseEntity.ok(boxService.addBox(createBoxRequest));
    }

    @GetMapping("")
    public ResponseEntity<List<Box>>getBox(){
        return ResponseEntity.ok(boxService.getAll());
    }

    @GetMapping("/getBoxesByUser/{recipientId}")
    public ResponseEntity<BoxWithUserDto> getBoxesByUser(@PathVariable String recipientId){
        return ResponseEntity.ok(boxService.getBoxesByUser(recipientId));
    }

    @PutMapping("/{boxId}/status")
    public ResponseEntity<String> updateBoxStatus(@PathVariable("boxId") String boxId,
                                                  @RequestParam("status") String status) {
        boxService.updateBoxStatus(boxId, status);
        return ResponseEntity.ok("Box status updated successfully.");
    }
}
