package com.tor.hiber.repository

import com.tor.hiber.entity.universityaudit.TeacherLoginEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherLoginRepository:JpaRepository<TeacherLoginEntity,Int> {
    fun findOneByLogin(login:String):TeacherLoginEntity
}