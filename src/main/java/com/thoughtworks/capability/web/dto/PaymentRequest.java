package com.thoughtworks.capability.web.dto;

import com.thoughtworks.capability.domain.Commodity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private List<Commodity> commodities;
}
