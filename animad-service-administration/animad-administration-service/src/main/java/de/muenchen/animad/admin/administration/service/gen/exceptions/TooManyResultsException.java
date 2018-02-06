/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.animad.admin.administration.service.gen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author roland
 */
@ResponseStatus(value=HttpStatus.PAYLOAD_TOO_LARGE, reason="too many search results")  // 413
public class TooManyResultsException extends Exception {
    private final int maxResults;

    
    public TooManyResultsException(int maxResults) {
        this.maxResults = maxResults;
    }


    public int getMaxResults() {
        return maxResults;
    }    
}
