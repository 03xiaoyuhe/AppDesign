package com.app.design.demo.model;

public class WxLoginRequest {
        private String token;
        private WxUser user;

        // Getter 和 Setter
        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public WxUser getUser() {
            return user;
        }

        public void setUser(WxUser user) {
            this.user = user;
        }
    }

