package com.train.ticket.booking.service;

import com.train.ticket.booking.model.response.TrainDetailsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Predicate;

@Service
@Slf4j
public class TrainDetailsService {

    public TrainDetailsDTO getTrainDetails() {

        return   TrainDetailsDTO.builder()
                .fromStation("Kakinada")
                .toStation("Secunderabad")
                .frequency("Daily")
                .build();
    }

    public String postNewTrainDetails(TrainDetailsDTO trainDetailsDTO) {
        log.info("TrainDetailsService::postNewTrainDetails -> "+trainDetailsDTO.toString());
        //post to DB & return generated ID (new train number)
        return "112233";
    }

    public String updateExistingTrainDetails(TrainDetailsDTO trainDetailsDTO) {
        log.info("TrainDetailsService::updateExistingTrainDetails -> "+trainDetailsDTO.toString());
        return "1234";
    }
}
