package com.biefeng.demo.nio.http;

import java.util.Map;

public class RequestEncoder {

    private String content;

    private RequestHeader requestHeader;

    public RequestEncoder(String content) {
        this.content = content;
    }

    public void decode() {
        String[] strs = content.split("\r\n");
        String major = strs[0];
        requestHeader = new RequestHeader(major);
        String[] majors = major.split(" ");
        String temp = majors[2];
        requestHeader.setPath(majors[1]);
        requestHeader.setHttpMethod(majors[0]);
        requestHeader.setProtocol(((String[]) temp.split("/"))[0]);
        requestHeader.setVersion(((String[]) temp.split("/"))[1]);

        Map<String, String> values = requestHeader.getValues();
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.contains(":")) {
                String[] keyValue = str.split(":");
                values.put(keyValue[0].trim(), keyValue[1].trim());
            }
        }
    }

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }
}
