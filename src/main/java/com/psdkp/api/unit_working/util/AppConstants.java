package com.psdkp.api.unit_working.util;

public class AppConstants {

    /**
     * Constant for error code
     */

    public final static Integer C_SUCCESS_GET = 200;
    public final static Integer C_SUCCESS_PROCESS = 201;
    public final static Integer C_NO_COTENT = 204;
    public final static Integer C_NOT_FOUND = 404;
    public final static Integer C_DUPLICATE = 409;
    public final static Integer C_BAD_REQUEST = 400;
    public final static Integer C_NOT_ALLOW = 405;
    public final static Integer C_ZIPCODE_NOT_ALLOW = 405;
    public final static Integer C_CALENDAR_NOT_ALLOW = 405;
    public final static Integer C_VALUE_NOT_ALLOW = 405;


    /**
     * Constant for error message
     */

    public final static String SUCCESS_GET = "SUKSES MENGAMBIL DATA";
    public final static String SUCCESS_PROCESS = "SUKSES PROSES DATA";
    public final static String NO_CONTENT = "DATA KOSONG";
    public final static String NOT_FOUND = "DATA TIDAK DITEMUKAN";
    public final static String DUPLICATE = "TERDAPAT DUPLIKASI DATA";
    public final static String BAD_REQUEST = "DATA TIDAK LENGKAP!";
    public final static String NOT_ALLOW = "LEVEL AKSES TIDAK DIIJINKAN, CHILD BUKAN BERADA DIBAWAH PARRENT";
    public final static String ZIPCODE_NOT_ALLOW = "KODE POS TIDAK DI IZINKAN";
    public final static String CALENDAR_NOT_ALLOW = "TANGGAL TIDAK DI IZINKAN";
    public final static String VALUE_NOT_ALLOW = "NILAI TIDAK DI IZINKAN";
}
