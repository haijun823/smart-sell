package com.zhonghaijun.ssj.query;

import com.github.wenhao.jpa.Specifications;
import com.zhonghaijun.ssj.domain.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeQuery extends BaseQuery {

    private String username;
    private String email;
    private Long department_id;

    @Override
    public Specification getSpec() {
        Specification<Employee> specification = Specifications.<Employee>and()
                .like(StringUtils.isNotBlank(username),"username","%"+username+"%")
                .like(StringUtils.isNotBlank(email), "email","%"+email+"%")
                .eq(department_id != null,"department.id",department_id)
                .build();
        return specification;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "EmployeeQuery{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", department_id=" + department_id +
                '}';
    }
}
