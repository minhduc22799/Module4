package com.example.springjwt.service;

import com.example.springjwt.model.Role;

public interface IRoleService extends IGeneralService<Role>{
    Role findByName(String name);
}
