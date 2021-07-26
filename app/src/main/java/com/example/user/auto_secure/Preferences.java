package com.example.user.auto_secure;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    /** Pendeklarasian key-data berupa String, untuk sebagai wadah penyimpanan data.
     * Jadi setiap data mempunyai key yang berbeda satu sama lain */
    static final String KEY_NOMOR_TEREGISTER1 ="nomor1", KEY_NOMOR_TEREGISTER2 ="nomor2", KEY_NOMOR_TEREGISTER3 ="nomor3";
    static final String KEY_NOMOR_LOGIN1 = "User_nomor_1", KEY_NOMOR_LOGIN2 = "User_nomor_2", KEY_NOMOR_LOGIN3 = "User_nomor_3";
    static final String KEY_STATUS_SEDANG_LOGIN = "Status_logged_in";

    /** Pendlakarasian Shared Preferences yang berdasarkan paramater context */
    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /** Deklarasi Edit Preferences dan mengubah data
     *  yang memiliki key isi KEY_USER_TEREGISTER dengan parameter username */
    public static void setRegisteredUser1(Context context, String username1){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NOMOR_TEREGISTER1, username1);
        editor.apply();
    }
    public static void setRegisteredUser2(Context context, String username2){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NOMOR_TEREGISTER2, username2);
        editor.apply();
    }
    public static void setRegisteredUser3(Context context, String username3){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NOMOR_TEREGISTER3, username3);
        editor.apply();
    }
    /** Mengembalikan nilai dari key KEY_USER_TEREGISTER berupa String */
    public static String getRegisteredUser1(Context context){
        return getSharedPreference(context).getString(KEY_NOMOR_TEREGISTER1,"");
    }

    public static String getRegisteredUser2(Context context){
        return getSharedPreference(context).getString(KEY_NOMOR_TEREGISTER2,"");
    }

    public static String getRegisteredUser3(Context context){
        return getSharedPreference(context).getString(KEY_NOMOR_TEREGISTER3,"");
    }


    /** Deklarasi Edit Preferences dan mengubah data
     *  yang memiliki key KEY_USERNAME_SEDANG_LOGIN dengan parameter username */
    public static void setLoggedInUser1(Context context, String usernamea){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NOMOR_LOGIN1, usernamea);
        editor.apply();
    }

    public static void setLoggedInUser2(Context context, String usernameb){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NOMOR_LOGIN2, usernameb);
        editor.apply();
    }

    public static void setLoggedInUser3(Context context, String usernamec){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NOMOR_LOGIN3, usernamec);
        editor.apply();
    }
    /** Mengembalikan nilai dari key KEY_USERNAME_SEDANG_LOGIN berupa String */
    public static String getLoggedInUser1(Context context){
        return getSharedPreference(context).getString(KEY_NOMOR_LOGIN1,"");
    }

    public static String getLoggedInUser2(Context context){
        return getSharedPreference(context).getString(KEY_NOMOR_LOGIN2,"");
    }

    public static String getLoggedInUser3(Context context){
        return getSharedPreference(context).getString(KEY_NOMOR_LOGIN3,"");
    }

    /** Deklarasi Edit Preferences dan mengubah data
     *  yang memiliki key KEY_STATUS_SEDANG_LOGIN dengan parameter status */
    public static void setLoggedInStatus(Context context, boolean status){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(KEY_STATUS_SEDANG_LOGIN,status);
        editor.apply();
    }
    /** Mengembalikan nilai dari key KEY_STATUS_SEDANG_LOGIN berupa boolean */
    public static boolean getLoggedInStatus(Context context){
        return getSharedPreference(context).getBoolean(KEY_STATUS_SEDANG_LOGIN,false);
    }

    /** Deklarasi Edit Preferences dan menghapus data, sehingga menjadikannya bernilai default
     *  khusus data yang memiliki key KEY_USERNAME_SEDANG_LOGIN dan KEY_STATUS_SEDANG_LOGIN */
    public static void clearLoggedInUser (Context context){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.remove(KEY_NOMOR_LOGIN1);
        editor.remove(KEY_NOMOR_LOGIN2);
        editor.remove(KEY_NOMOR_LOGIN3);
        editor.remove(KEY_STATUS_SEDANG_LOGIN);
        editor.apply();
    }
}