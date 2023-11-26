package com.easynews.easynewsserver.model;

import com.easynews.easynewsserver.model.db.UserRole;

public record UserRequest(
        String name,
        String email,
        String password,
        UserRole role,
        String state,
        String allowSlang,
        String allowRegionalExpressions,
        String isPcd,
        String isPremium,
        String academicDegree,
        String dateOfBirth) {
}
