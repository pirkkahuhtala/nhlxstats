package com.mediatuotantoph.nhlxstats.domain;

/**
 * Class for business logic exceptions
 * 
 * @author Pirkka Huhtala
 *
 */
public class NHLXStatsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NHLXStatsException(String message) {
        super(message);
    }

}