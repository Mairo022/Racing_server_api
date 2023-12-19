package com.driveclub.endpoints.sessions;

import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
public class SessionOverviewDTO {
    private Object session_id;
    private Object date;
    private Object track;
    private Object details;
}
