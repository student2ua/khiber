package com.tor.hiber.entity.universityaudit

import com.tor.hiber.entity.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "TLGROUP", schema = "UNIVERSITYAUDIT")
//@UniqueConstraint(name="TLROLE_NAME_U",columnNames = {@Col})
class TLGroupEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TLGROUP_SEQ")
        @SequenceGenerator(name = "TLGROUP_SEQ", schema = "UNIVERSITYAUDIT")
        @Column(name = "GROUPID", nullable = false, insertable = false, updatable = false)
        var groupId: Int? = null,
        @Basic
        @Column(name = "NAME", nullable = false, unique = true, length = 40)
//    @Size(max = 40)
        var name: String? = null,
        @ManyToMany(mappedBy = "roleGroups")
        var teacherLogins: List<TeacherLoginEntity>? = null
):BaseEntity<Int>()
