package com.prajan.peertechz.networkInterceptor;

import java.io.IOException;

/**
 * Created by JANI SHAIK on 04/09/2019
 */

public class NoConnectivityException extends IOException {

    public String getMessage() {
        return "No connectivity exception";
    }

}
