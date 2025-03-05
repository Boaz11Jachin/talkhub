package org.codenova.talkhub.util;

import jakarta.servlet.http.Cookie;

public class CookieUtil {

    public static boolean findCookie(Cookie[] cookies,String name) {
        boolean found = false;
        if(cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie one = cookies[i];
                String cookieName = one.getName();
                if (cookieName.equals(name)) {
                    found = true;
                }
            }
        }
        return found;
    } //===============================================================

}
