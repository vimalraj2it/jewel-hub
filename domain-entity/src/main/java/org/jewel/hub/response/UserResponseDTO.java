package org.jewel.hub.response;

import org.jewel.hub.entity.user.AdminUser;

import java.util.List;

public class UserResponseDTO extends BaseResponse{


    private List<AdminUser> user;

    public List<AdminUser> getUser() {
        return user;
    }

    public void setUser(List<AdminUser> user) {
        this.user = user;
    }
}
