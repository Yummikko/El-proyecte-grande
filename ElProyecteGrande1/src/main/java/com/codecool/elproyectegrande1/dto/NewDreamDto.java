package com.codecool.elproyectegrande1.dto;

public class NewDreamDto {

        private String dreamTitle;
        private String dreamDescription;

        public NewDreamDto() {
        }

        public NewDreamDto(String dreamTitle, String dreamDescription) {
            this.dreamTitle = dreamTitle;
            this.dreamDescription = dreamDescription;
        }

        public String getDreamTitle() {
            return dreamTitle;
        }

        public void setDreamTitle(String dreamTitle) {
            this.dreamTitle = dreamTitle;
        }

        public String getDreamDescription() {
            return dreamDescription;
        }

        public void setDreamDescription(String dreamDescription) {
            this.dreamDescription = dreamDescription;
        }
    }

