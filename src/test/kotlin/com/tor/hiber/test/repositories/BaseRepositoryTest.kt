package com.tor.hiber.test.repositories

import com.tor.hiber.repository.TeacherLoginRepository
import com.tor.hiber.test.config.PostgresTestContainersInitializer
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@ActiveProfiles("test")
@RunWith(SpringRunner::class)
@ContextConfiguration(initializers = [PostgresTestContainersInitializer::class])
abstract class BaseRepositoryTest {
@Autowired
protected lateinit var teacherLoginRepository: TeacherLoginRepository
  /*  @Autowired
    protected lateinit var */
}