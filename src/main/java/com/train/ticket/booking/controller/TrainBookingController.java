package com.train.ticket.booking.controller;

import com.train.ticket.booking.model.response.APIResponse;
import com.train.ticket.booking.model.response.TrainDetailsDTO;
import com.train.ticket.booking.service.TrainDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/book-train",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class TrainBookingController {
    @Autowired
    TrainDetailsService trainDetailsService;

    @GetMapping("/get-train/{number}")
    public ResponseEntity<APIResponse> getTrainDetails(@PathVariable String number) {
        TrainDetailsDTO trainDetailsDTO = trainDetailsService.getTrainDetails();
        APIResponse<TrainDetailsDTO> apiResponse = APIResponse
                .<TrainDetailsDTO>builder()
                .message("Success")
                .results(trainDetailsDTO)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/post-new-train")
    public ResponseEntity<APIResponse> createNewTrain(@RequestBody TrainDetailsDTO trainDetailsDTO) {
        String newTrainNumber = trainDetailsService.postNewTrainDetails(trainDetailsDTO);
        APIResponse<String> apiResponse = APIResponse
                .<String>builder()
                .message("CREATED")
                .results(newTrainNumber)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping("/put-update-existing-train-else-create/{train-number}")
    public ResponseEntity<APIResponse> updateTrain(@RequestBody TrainDetailsDTO trainDetailsDTO) {
        String trainId = trainDetailsService.updateExistingTrainDetails(trainDetailsDTO);
        APIResponse<String> apiResponse = APIResponse
                .<String>builder()
                .results(trainId)
                .message("updated existing train")
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.FOUND);
    }

    /*@PatchMapping("/patch-update-existing-train-else-exception/{train-number}")
    public ResponseEntity<TrainDetailsDTO> patchTrainDetails(@RequestBody TrainDetailsDTO trainDetailsDTO) {

    }*/

}
