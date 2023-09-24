package com.train.ticket.booking.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainDetailsDTO {

    private String fromStation;
    private String toStation;
    private String frequency;
}
