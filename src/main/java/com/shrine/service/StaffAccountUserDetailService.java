package com.shrine.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shrine.entity.StaffAccountEntity;
import com.shrine.repository.StaffAccountRepository;

@Service
public class StaffAccountUserDetailService implements UserDetailsService {

    private final StaffAccountRepository staffAccountRepository;

    public StaffAccountUserDetailService(StaffAccountRepository staffAccountRepository) {
        this.staffAccountRepository = staffAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        StaffAccountEntity staffAccount = staffAccountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりません: " + username));

        return User.withUsername(staffAccount.getUsername())
                .password(staffAccount.getPassword())
                .authorities("ROLE_" + staffAccount.getRole())
                .disabled(!staffAccount.getEnabled())
                .build();
    }
}