package com.one.pojian.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
public class AreaNameTDT {
    private int status;
    private String message;
    private ArrayList<Country> data;

    @Data
    public static class Country {
        private String gb;
        @JsonProperty("pGb")
        private String pGb;
        private String name;
        private ArrayList<Province> children;

        @Data
        public static class Province {
            private String gb;
            @JsonProperty("pGb")
            private String pGb;
            private String name;
            private ArrayList<City> children;

            @Data
            public static class City {
                private String gb;
                @JsonProperty("pGb")
                private String pGb;
                private String name;
                private ArrayList<Region> children;
                @Data
                public static class Region {
                    private String gb;
                    @JsonProperty("pGb")
                    private String pGb;
                    private String name;
                }
            }
        }
    }
}
