package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
        addDefRole();
    }

    @Transactional
    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Transactional
    @Override
    public void removeRoleById(int id) {
        roleDao.removeRoleById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    @Transactional(readOnly = true)
    @Override
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Role getRoleByRole(Role role) {
        return roleDao.getRoleByRole(role);
    }

    @Transactional
    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void addDefRole() {
        roleDao.saveRole(new Role("ROLE_USER"));
        roleDao.saveRole(new Role("ROLE_ADMIN"));
    }

}
