package org.example.projekat.exceptions;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class exceptions {
    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

}

