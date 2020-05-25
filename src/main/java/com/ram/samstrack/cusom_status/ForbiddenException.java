package com.ram.samstrack.cusom_status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "Not Created")
public class ForbiddenException extends RuntimeException {

}
