package com.company;

import java.io.IOException;

public class IncorrectInputException extends Exception {
    public IncorrectInputException(){
        super();

    }

    @Override
    public String getMessage() {
        return ("\r\n!!!!!!!!!!!!!\r\nThat was incorrect input format\r\n!!!!!!!!!!!!!");
    }
}
