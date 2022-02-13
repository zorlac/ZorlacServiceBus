package xam.zorlac.servicebus.zorlacservicebus.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanDetails {
     private String clientCode;
     private String planId;
     private String planDescription;
}
