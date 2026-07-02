//package com.shrine.service;
//
//import java.util.Optional;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.shrine.entity.StaffAccountEntity;
//import com.shrine.repository.StaffAccountRepository;
//
//@Service
//public class StaffAccountUserDetailService implements UserDetailsService {
//
//    private final StaffAccountRepository staffAccountRepository;
//
//    public StaffAccountUserDetailService(StaffAccountRepository staffAccountRepository) {
//        this.staffAccountRepository = staffAccountRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<StaffAccountEntity> staffOpt = staffAccountRepository.findByUsername(username);
//
//        StaffAccountEntity staff = staffOpt.orElseThrow(
//                () -> new UsernameNotFoundException("ユーザーが見つかりません: " + username)
//        );
//
//        String role = staff.getRole();
//        if (role == null || role.isBlank()) {
//            role = "STAFF";
//        }
//
//        return User.withUsername(staff.getUsername())
//                // 今はDBに平文で入っている前提なので一旦 {noop}
//                .password("{noop}" + staff.getPassword())
//                .roles(role)
//                .disabled(!staff.getEnabled())
//                .build();
//    }
//}