package com.one.pojian.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AreaTDT {
    private String status;
    private String message;
    private DataRes data;

    @Data
    public class DataRes {
        private String suggestion;
        private DataRes.District district;

        @Data
        public class District {
            private String gb;
            private String name;
            private String boundary;
            private String level;
            private DataRes.District.Center center;

            @Data
            public class Center {
                private BigDecimal lng;
                private BigDecimal lat;
            }
        }
    }
}
