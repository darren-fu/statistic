package df.open.statistic.util.http;


import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.Punycode;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.StringTokenizer;

/**
 * Convenience class for setting and retrieving cookies.
 *
 * @author of546
 */
public final class RequestUtil {

    /**
     * IP长度
     */
    private static final int IPLENGTH = 4;

    /**
     * 获取请求路径
     *
     * @param request
     * @return /url/1
     */
    public static String getRestURL(HttpServletRequest request) {
        return (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    }

    /**
     * 获取请求路径表达式
     *
     * @param request
     * @return /url/{id}
     */
    public static String getRestPatternURL(HttpServletRequest request) {
        return (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
    }

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private RequestUtil() {
    }

    /**
     * Convenience method to set a cookie
     *
     * @param response the current response
     * @param name     the name of the cookie
     * @param value    the value of the cookie
     * @param path     the path to set it on
     */
    public static void setCookie(HttpServletResponse response, String name,
                                 String value, String path) {

        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(false);
        cookie.setPath(path);
        cookie.setMaxAge(3600 * 24 * 30); // 30 days

        response.addCookie(cookie);
    }

    /**
     * Convenience method to set a cookie
     *
     * @param response the current response
     * @param name     the name of the cookie
     * @param value    the value of the cookie
     * @param path     the path to set it on
     */
    public static void setHttpOnlyCookie(HttpServletResponse response, String name,
                                         String value, String path) {

        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(false);
        cookie.setPath(path);
        cookie.setMaxAge(3600 * 24 * 30 * 12); // 30 days
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
    }

    /**
     * Convenience method to get a cookie by name
     *
     * @param request the current request
     * @param name    the name of the cookie to find
     * @return the cookie (if found), null if not found
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        Cookie returnCookie = null;

        if (cookies == null) {
            return returnCookie;
        }

        for (Cookie thisCookie : cookies) {
            if (thisCookie.getName().equals(name)) {
                // cookies with no value do me no good!
                if (!thisCookie.getValue().equals("")) {
                    returnCookie = thisCookie;

                    break;
                }
            }
        }

        return returnCookie;
    }

    /**
     * Convenience method for deleting a cookie by name
     *
     * @param response the current web response
     * @param cookie   the cookie to delete
     * @param path     the path on which the cookie was set (i.e. /ofpay)
     */
    public static void deleteCookie(HttpServletResponse response,
                                    Cookie cookie, String path) {
        if (cookie != null) {
            // Delete the cookie by setting its maximum age to zero
            cookie.setMaxAge(0);
            cookie.setPath(path);
            // cookie.setHttpOnly(false);
            response.addCookie(cookie);
        }
    }

    /**
     * Convenience method to get the application's URL based on request
     * variables.
     *
     * @param request the current request
     * @return URL to application
     */
    public static String getAppURL(HttpServletRequest request) {
        StringBuffer url = new StringBuffer();
        int port = request.getServerPort();
        if (port < 0) {
            port = 80; // Work around java.net.URL bug
        }
        String scheme = request.getScheme();
        url.append(scheme);
        url.append("://");
        url.append(Punycode.toUnicode(request.getServerName()));
        /*if ((scheme.equals("http") && (port != 80)) || (scheme.equals("https") && (port != 443))) {
            url.append(':');
            url.append(port);
        }*/
        url.append(request.getContextPath());
        return url.toString();
    }

    /**
     * Convenience method to get the application's URL based on request
     * variables.
     *
     * @param request the current request
     * @return URL to application
     */
    public static String getAppOriginURL(HttpServletRequest request) {
        StringBuffer url = new StringBuffer();
        int port = request.getServerPort();
        if (port < 0) {
            port = 80; // Work around java.net.URL bug
        }
        String scheme = request.getScheme();
        url.append(scheme);
        url.append("://");
        url.append(request.getServerName());
        if ((scheme.equals("http") && (port != 80)) || (scheme.equals("https") && (port != 443))) {
            url.append(':');
            url.append(port);
        }
        url.append(request.getContextPath());
        return url.toString();
    }

    public static String getDomainUrl(HttpServletRequest request) {
        StringBuffer url = new StringBuffer();
        String origin = request.getHeader("Origin");
        if (StringUtils.isBlank(origin)){
            origin =  request.getHeader("Referer");
        }

        if (StringUtils.contains(origin, "http://")){
            origin = StringUtils.remove(origin,"http://");
        }

        if (StringUtils.contains(origin, "/")){
            origin = StringUtils.split(origin,"/")[0];
        }

        //origin = StringUtils.substringBetween(origin,"http://","/");

        if (StringUtils.contains(origin, ":")){
            origin = StringUtils.split(origin,":")[0];
        }

        url.append(request.getScheme());
        url.append("://");
        url.append(Punycode.toUnicode(origin));
        /*if ((scheme.equals("http") && (port != 80)) || (scheme.equals("https") && (port != 443))) {
            url.append(':');
            url.append(port);
        }*/
        //url.append(request.getContextPath());
        return url.toString();
    }

    /**
     * 获取IP地址
     *
     * @param request
     * @return
     */
    public static String getRemoteIp(HttpServletRequest request) {

//        String ip = request.getHeader("X-Real-IP");
//
//        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("x-forwarded-for");
//        }
//        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//
//        return ip.split(",")[0];

        String ip = request.getHeader("X-Real-IP");
        String xip = request.getHeader("x-forwarded-for");

        if (!checkIP(ip)) {
            ip = request.getHeader("REMOTE-HOST");
        }

        if (StringUtils.isNotBlank(ip) && !ip.equals(xip)) {
//            logger.error("getipne   X-Real-IP  " + ip + "    ,x-forwarded-for " + xip);
        }

        if (!checkIP(ip) || !ip.equals(xip)) {
            String info = request.getHeader("x-forwarded-for");
            if (StringUtils.isNotBlank(info)) {
                String[] ips = info.trim().split(",");
                for (String s : ips) {
                    if (!"unknown".equalsIgnoreCase(s)) {//取第一个非unknown的ip地址
                        ip = s;
                        break;
                    }
                }
            }
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("Proxy-Client-IP");//只在 Apache（Weblogic Plug-In Enable）+WebLogic 搭配下出现
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");//只在 Apache（Weblogic Plug-In Enable）+WebLogic 搭配下出现
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (!checkIP(ip)) {
            ip = request.getRemoteAddr();
        }

        // 多级反向代理
        if (null != ip && !"".equals(ip.trim())) {
            StringTokenizer st = new StringTokenizer(ip, ",");
            if (st.countTokens() > 1) {
//                logger.error("getip StringTokenizer  " + ip);
                return st.nextToken();
            }
        }

        return ip;
    }

    /**
     * 验证ip地址格式是否正确
     *
     * @param ip
     * @return
     * @author lihe 2013-7-4 下午5:26:26
     * @see
     */
    private static boolean checkIP(String ip) {
        if (StringUtils.isNotBlank(ip) && ip.split("\\.").length == IPLENGTH) {
            return true;
        }
        return false;
    }

}
