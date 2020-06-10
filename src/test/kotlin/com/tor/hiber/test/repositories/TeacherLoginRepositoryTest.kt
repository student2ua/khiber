package com.tor.hiber.test.repositories

import com.tor.hiber.entity.universityaudit.TLGroupEntity
import com.tor.hiber.entity.universityaudit.TeacherLoginEntity
import org.junit.Assert
import org.junit.jupiter.api.Test

class TeacherLoginRepositoryTest : BaseRepositoryTest() {
    @Test
    fun `test save and update`() {
        val id = teacherLoginRepository
                .save(
                        TeacherLoginEntity(-1, "testUser", "kyky")
                ).id!!
        Assert.assertEquals(1, teacherLoginRepository.count())
        val tl2update = teacherLoginRepository.findById(id).get()
        tl2update.addRoleGroup { TLGroupEntity(name = "testGroup_1") }
        tl2update.addRoleGroup { TLGroupEntity(name = "testGroup_2") }
        teacherLoginRepository.save(tl2update)
        val updatedTL = teacherLoginRepository.findById(id).get()
        Assert.assertEquals("testUser", updatedTL.login)
        Assert.assertEquals(2, updatedTL.roleGroups.size)
    }

    @Test
    fun `test find one by login`() {
        teacherLoginRepository.saveAll(
                listOf(
                        TeacherLoginEntity(
                                login = "Department"
                        ),
                        TeacherLoginEntity(
                                login = "Unit Two"
                        )
                )
        )
        Assert.assertEquals(2, teacherLoginRepository.count())
        val teacherLoginEntity = teacherLoginRepository.findOneByLogin("Department")
        Assert.assertEquals("Department One", teacherLoginEntity.login)
    }
}