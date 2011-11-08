package com.varun.yfs.client.login;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.varun.yfs.dto.UserDTO;

public interface LoginServiceAsync
{

	void loginServer(String name, String password, AsyncCallback<UserDTO> callback);

	void loginFromSessionServer(AsyncCallback<UserDTO> callback);

	void logout(AsyncCallback<Void> callback);

}
