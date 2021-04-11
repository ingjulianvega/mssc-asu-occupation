package ingjulianvega.ximic.occupation.exception;

import lombok.Getter;

@Getter
public class OccupationException extends RuntimeException {

    private final String code;

    public OccupationException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

