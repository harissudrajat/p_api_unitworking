package com.psdkp.api.unit_working.util;

import java.util.Map;

public interface BaseUtil {

    Map SUCCESS_GET(Object data);
    Map BAD_REUQEST();
    Map DUPLICATE(String atribut);
    Map SUCCESS_PROCESS_DATA();
    Map NOT_FOUND(String atribut);
    Map NOT_ALLOW();
    Map POSTCODE_NOT_ALLOW();
    Map CALENDAR_NOT_ALLOW();
    Map VALUE_NOT_ALLOW();
}
