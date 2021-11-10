package com.android.springboot.service;

import com.android.springboot.model.User;

public interface UserService {

	void insert(User vo);

	User select(User vo);

}